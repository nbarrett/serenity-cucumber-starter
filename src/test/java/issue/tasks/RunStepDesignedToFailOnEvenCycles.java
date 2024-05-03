package issue.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunStepDesignedToFailOnEvenCycles implements Interaction {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunStepDesignedToFailOnEvenCycles.class);
    private final Integer value;

    public RunStepDesignedToFailOnEvenCycles(Integer value) {
        this.value = value;
    }

    @Override
    @Step("{0} executes a performable step with no error handling that throws an error when an even value is passed to it (#value passed in this case)")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Beginning execution of step with value {}", value);
        if (value % 2 == 0) {
            throw new RuntimeException("Throwing an exception that should be cleared with value " + value);
        } else {
            LOGGER.info("Execution with value {} ran successfully", value);
        }
    }
}
