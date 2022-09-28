package org.felipe.automatizacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.felipe.automatizacion.exceptions.AuthenticationError;
import org.felipe.automatizacion.model.Credentials;
import org.felipe.automatizacion.userinterface.LoginPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.felipe.automatizacion.exceptions.AuthenticationError.MESSAGE_FAILED_AUTHENTICATION;
import static org.felipe.automatizacion.userinterface.LoginPage.LOG_IN_BUTTON;
import static org.felipe.automatizacion.userinterface.MenuPage.LOG_IN_MENU;
import static org.felipe.automatizacion.userinterface.MenuPage.LOG_OUT_MENU;

public class Authenticate implements Task {

    private final Credentials credentials;


    public Authenticate(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    @Step("{0} performs an authentication")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOG_IN_MENU),
                Enter.theValue(credentials.getUsername()).into(LoginPage.USER_NAME),
                Enter.theValue(credentials.getPassword()).into(LoginPage.PASSWORD),
                Click.on(LOG_IN_BUTTON)
        );
        actor.should(seeThat(the(LOG_OUT_MENU), isVisible())
                .orComplainWith(AuthenticationError.class,MESSAGE_FAILED_AUTHENTICATION));
    }

    public static Performable withCredentials(Credentials credentials){
        return instrumented(Authenticate.class, credentials);
    }
}
