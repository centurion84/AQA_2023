package homeWork23.ui;

import com.codeborne.selenide.SelenideElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OrdersPage {

    public final SelenideElement totalOrderPrice = $("td.cdk-column-orderTotal");
    public final SelenideElement orderDate = $("td.cdk-column-orderedOn");
    public final SelenideElement orderId = $("td.cdk-column-orderId");
    public final SelenideElement bookOrderTitle = $("a[href*='/books/details/']");
    public final SelenideElement bookOrderQuantity = $("table.tbl-orderdetails tr.ng-star-inserted td:nth-child(2)");
    public final SelenideElement bookOrderPrice = $("table.tbl-orderdetails tr.ng-star-inserted td:nth-child(3)");

    public boolean areOrderDetailsCorrect(String bookTitle, String bookPrice) {

        String id = orderId.getText();
        String date = orderDate.getText();
        String totalPrice = totalOrderPrice.getText();

        orderId.click();
        bookOrderTitle.shouldBe(visible);
        String title = bookOrderTitle.getText();
        bookOrderQuantity.shouldBe(visible);
        String quantity = bookOrderQuantity.getText();
        bookOrderPrice.shouldBe(visible);
        String price = bookOrderPrice.getText();

        return !id.isEmpty() &&
                date.equals(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(new Date())) &&
                totalPrice.equals(bookPrice) &&
                title.equals(bookTitle) &&
                quantity.equals("1") &&
                price.equals(bookPrice);
    }
}

