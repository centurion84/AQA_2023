package homeWork23;

import homeWork23.api.dto.UserDTO;
import homeWork23.api.services.UserService;
import homeWork23.ui.AddressPage;
import homeWork23.ui.CartPage;
import homeWork23.ui.HomePage;
import homeWork23.ui.OrdersPage;
import homeWork23.utils.BaseUITest;
import homeWork23.utils.DataGenerator;
import org.testng.annotations.Test;

import static homeWork23.api.services.helpers.BaseHelper.currentDate;
import static homeWork23.utils.TestData.randomUserData;
import static org.testng.Assert.*;

public class BookCartUITest extends BaseUITest {

    @Test
    public void bookPurchaseTest() {

        // create user via API and get credentials
        UserDTO userDTO = randomUserData();
        UserService.createUser(userDTO);
        String userName = userDTO.getUsername();
        String userPassword = userDTO.getPassword();

        // login and find book
        HomePage homePage = opeHomePage()
                .goToLogin()
                .performLogin(userName, userPassword)
                .searchForBook("Slayer")
                .addBookToCart();
        assertTrue(homePage.isCartSnackBarShown());
        String bookTitle = homePage.getBookTitle();
        String bookPrice = homePage.getBookPrice();

        //check cart
        CartPage cartPage = homePage.goToCart();
        assertEquals(cartPage.bookTitleInCart.getText(), bookTitle);
        assertEquals(cartPage.bookPriceInCart.getText(), bookPrice);
        assertEquals(cartPage.totalPriceInCart.getText(), bookPrice);
        assertEquals(cartPage.bookQuantityInCart.getText(), "1");
        AddressPage addressPage = cartPage.proceedToCheckout();

        // check order details, fill customer data and checkout
        assertEquals(addressPage.bookTitleInOrder.getText(), bookTitle);
        assertEquals(addressPage.bookPriceInOrder.getText(), bookPrice);
        assertEquals(addressPage.totalPriceInOrder.getText(), bookPrice);
        assertEquals(addressPage.bookQuantityInOrder.getText(), "1");
        OrdersPage ordersPage = addressPage.fillAddressDetails(
                        DataGenerator.randomFullName(),
                        DataGenerator.randomAddress(),
                        DataGenerator.randomAddress(),
                        DataGenerator.randomStringId(),
                        DataGenerator.randomState())
                .placeOrder();

        //confirm order
        assertTrue(addressPage.isCheckOutSnackBarShown());
        ordersPage.showOrderDetails();
        assertFalse(ordersPage.orderId.getText().isEmpty());
        assertEquals(ordersPage.orderDate.getText(), currentDate());
        assertEquals(ordersPage.totalOrderPrice.getText(), bookPrice);
        assertEquals(ordersPage.bookOrderTitle.getText(), bookTitle);
        assertEquals(ordersPage.bookOrderQuantity.getText(), "1");
        assertEquals(ordersPage.bookOrderPrice.getText(), bookPrice);
    }
}
