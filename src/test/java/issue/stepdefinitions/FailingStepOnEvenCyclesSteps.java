package issue.stepdefinitions;


import net.serenitybdd.screenplay.Actor;

import io.cucumber.java.en.Then;

public class FailingStepOnEvenCyclesSteps {

    @Then("{actor} sees that a step that internally throws an error when value {int} is passed should not fail")
    public void aStepThatInternallyThrowsAnErrorWhenValueIsPassedShouldNotFail(Actor actor, int value) {
        actor.attemptsTo(RunStep.designedToCallFailOnEvenCyclesWithValue(value));
    }

}
