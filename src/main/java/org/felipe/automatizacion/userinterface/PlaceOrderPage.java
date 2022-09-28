package org.felipe.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlaceOrderPage {
    public static final Target NAME = Target.the("input name")
            .located(By.id("name"));

    public static final Target COUNTRY = Target.the("input country")
            .located(By.id("country"));

    public static final Target CITY = Target.the("input city")
            .located(By.id("city"));

    public static final Target CREDIT_CARD = Target.the("input credit card")
            .located(By.id("card"));

    public static final Target MONTH = Target.the("input month")
            .located(By.id("month"));

    public static final Target YEAR = Target.the("input year")
            .located(By.id("year"));

    public static final Target PURCHASE_BUTTON = Target.the("Purchase button")
            .locatedBy("//*[@id='orderModal']//button[text()='Purchase']");

    public static final Target MESSAGE_SUCCESS_PURCHASE = Target.the("Message Thank you for your purchase!")
            .locatedBy("//h2[text()='Thank you for your purchase!']");
}