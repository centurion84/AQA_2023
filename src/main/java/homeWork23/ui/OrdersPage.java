package homeWork23.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OrdersPage {

    public final SelenideElement totalOrderPrice = $("td.cdk-column-orderTotal");
    public final SelenideElement orderDate = $("td.cdk-column-orderedOn");
    public final SelenideElement orderId = $("td.cdk-column-orderId");
    public final SelenideElement bookOrderTitle = $("a[href*='/books/details/']");
    public final SelenideElement bookOrderQuantity = $("table.tbl-orderdetails tr.ng-star-inserted td:nth-child(2)");
    public final SelenideElement bookOrderPrice = $("table.tbl-orderdetails tr.ng-star-inserted td:nth-child(3)");

    public OrdersPage showOrderDetails() {

        orderId.click();
        bookOrderTitle.shouldBe(visible);

        return this;
    }
}

