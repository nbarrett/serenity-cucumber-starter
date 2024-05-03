package issue.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunStepDesignedToFailOnEvenCycles implements Interaction {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunStepDesignedToFailOnEvenCycles.class);
    private final Integer value;

    public RunStepDesignedToFailOnEvenCycles(Integer value) {
        this.value = value;
    }

    @Override
    @Step("{0} executes a step with #value passed to it")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Beginning execution of step with value {}", value);
        if (value % 2 == 0) {
            throw new RuntimeException("Throwing an exception because value is " + value);
        } else {
            LOGGER.info("Execution with value {} ran successfully", value);
        }
    }

}
