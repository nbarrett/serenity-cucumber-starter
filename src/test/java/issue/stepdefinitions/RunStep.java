package issue.stepdefinitions;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RunStep {

    public static Performable thatWillFailOnEvenCyclesWithValue(Integer value) {
        return instrumented(RunStepDesignedToFailOnEvenCycles.class, value);
    }

    public static Performable designedToCallFailOnEvenCyclesWithValue(Integer value) {
        return instrumented(RunStepDesignedToCallFailOnEvenCyclesTaskAndHandleError.class, value);
    }
}
