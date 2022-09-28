package org.felipe.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    public static final Target ADD_TO_CAR_BUTTON = Target.the("Add to cart button")
            .located(By.linkText("Add to cart"));

    //*[@id='tbodyid']//a/@onclick

}
