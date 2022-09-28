package org.felipe.automatizacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.felipe.automatizacion.userinterface.PlaceOrderPage.MESSAGE_SUCCESS_PURCHASE;

public class PurchaseSuccesfull implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return MESSAGE_SUCCESS_PURCHASE.isVisibleFor(actor);
    }

    public static PurchaseSuccesfull thePurchaseSuccesful(){
        return new PurchaseSuccesfull();
    }
}
