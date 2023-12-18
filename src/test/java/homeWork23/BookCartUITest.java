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

import static homeWork23.utils.TestData.randomUserData;
import static org.testng.Assert.assertTrue;

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
        assertTrue(cartPage.areBookDetailsInCartCorrect(bookTitle, bookPrice));
        AddressPage addressPage = cartPage.proceedToCheckout();

        // fill customer details and checkout
        assertTrue(addressPage.isOrderOnAddressPageCorrect(bookTitle, bookPrice));
        OrdersPage ordersPage = addressPage.fillAddressDetails(
                        DataGenerator.randomFullName(),
                        DataGenerator.randomAddress(),
                        DataGenerator.randomAddress(),
                        DataGenerator.randomStringId(),
                        DataGenerator.randomState())
                .placeOrder();

        //confirm order
        assertTrue(addressPage.isCheckOutSnackBarShown());
        assertTrue(ordersPage.areOrderDetailsCorrect(bookTitle, bookPrice));
    }
}
