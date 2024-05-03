package issue.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.steps.StepEventBus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class RunStepDesignedToCallFailOnEvenCyclesTaskAndHandleError implements Interaction {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunStepDesignedToCallFailOnEvenCyclesTaskAndHandleError.class);
    private final Integer value;

    public RunStepDesignedToCallFailOnEvenCyclesTaskAndHandleError(Integer value) {
        this.value = value;
    }

    @Override
    @Step("{0} executes a performable step that throws an error when an even value is passed to it with #value passed to it")
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(RunStep.thatWillFailOnEvenCyclesWithValue(value));
        } catch (Throwable caughtThrowable) {
            clearStepFailuresIfTheyHappen(caughtThrowable);
        } finally {
            clearStepFailuresIfTheyHappen(null);
        }
    }

    private void clearStepFailuresIfTheyHappen(Throwable caughtThrowable) {
        LOGGER.info("Scenario execution at value {} - Calling clearStepFailuresIfTheyHappen {}", value, Optional.ofNullable(caughtThrowable).map(e -> "with " + e.getMessage() + " passed in").orElse("in finally block"));
        if (StepEventBus.getEventBus().aStepInTheCurrentTestHasFailed()) {
            LOGGER.error("Scenario execution failed at value {} - clearing step failures - getting exception", value);
            Throwable throwable = StepEventBus.getEventBus().getBaseStepListener().getTestFailureCause().asException();
            // next line not needed now to control test execution as we've caught the exception thrown by the performable in the catch block
            // However we are unable to clear reporting which remains amber (not a problem in my case) regardless of whether we clearStepFailures or not
            // StepEventBus.getEventBus().clearStepFailures();
            LOGGER.error("Scenario execution failed at value {} - clearing step failures", value, throwable);
        } else {
            LOGGER.info("No Step failures happened with value {}", value);
        }
    }

}
