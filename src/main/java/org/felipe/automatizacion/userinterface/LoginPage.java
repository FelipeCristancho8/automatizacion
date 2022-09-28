package org.felipe.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USER_NAME = Target.the("username")
            .located(By.id("loginusername"));

    public static final Target PASSWORD = Target.the("password")
            .located(By.id("loginpassword"));

    public static final Target LOG_IN_BUTTON = Target.the("Log in button")
            .locatedBy("//*[@id='logInModal']//button[text()='Log in']");
    //*[@id="logInModal"]/div/div/div[3]/button[2]
    //*[@id='logInModal']//button[2]
}

