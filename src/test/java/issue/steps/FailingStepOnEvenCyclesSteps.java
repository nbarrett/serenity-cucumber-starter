package issue.steps;


import net.serenitybdd.screenplay.Actor;

import io.cucumber.java.en.Then;
import issue.tasks.RunStep;

public class FailingStepOnEvenCyclesSteps {

    @Then("{actor} sees that a step that internally throws an error when value {int} is passed should not fail")
    public void aStepThatInternallyThrowsAnErrorWhenValueIsPassedShouldNotFail(Actor actor, int value) {
        actor.attemptsTo(RunStep.designedToFailOnEvenCyclesWithValue(value));
    }

}
