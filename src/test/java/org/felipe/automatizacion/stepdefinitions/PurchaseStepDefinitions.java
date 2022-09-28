package org.felipe.automatizacion.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.felipe.automatizacion.model.Product;
import org.felipe.automatizacion.model.Purchaser;
import org.felipe.automatizacion.task.Add;
import org.felipe.automatizacion.userinterface.DemoBlazeHomePage;
import org.felipe.automatizacion.userinterface.LoginPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.felipe.automatizacion.model.Purchaser.PURCHASER_INFORMATION;
import static org.felipe.automatizacion.model.PurchaserFactory.createByName;
import static org.felipe.automatizacion.questions.PurchaseSuccesfull.thePurchaseSuccesful;
import static org.felipe.automatizacion.task.Authenticate.withCredentials;
import static org.felipe.automatizacion.task.Buy.buy;

public class PurchaseStepDefinitions {

    private DemoBlazeHomePage homePage;


    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is authenticated")
    public void authenticate(String actorName) {
        /*
        * Actor - habilities
        *           Interacciones - Interface
        *           Tareas - Grupo de interacicones
        *
        * Performance extienden --- task
        *                       --- Actions
        *                       --- Interaction
        *
        *
        * Selenium - WebDriver - By
        *          - WebElement
        *
        *Serenity  - WebElementFacade
        *          - Target
        *
        */
        Purchaser purchaser = createByName(actorName);
        theActorCalled(actorName).attemptsTo(
                Open.browserOn(homePage),
                withCredentials(purchaser.getCredentials())
        );
        theActorInTheSpotlight().remember(PURCHASER_INFORMATION, purchaser);
    }
    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCart(String category, String name) {
        Product product = Product.builder().category(category).name(name).build();
        theActorInTheSpotlight().wasAbleTo(
                Add.toCart(product)
        );
    }

    @When("^[a-zA-Z]{3,20} makes the purchase")
    public void purchase() {
        theActorInTheSpotlight().attemptsTo(
                buy()
        );
    }
    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() {
        //theActorInTheSpotlight().should(seeThat(the(MESSAGE_SUCCESS_PURCHASE), isVisible()));
        theActorInTheSpotlight().should(seeThat(thePurchaseSuccesful()));
    }
}
//hacer propias interacciones. Interaccion para manipular alert
//linea 41 Add.java