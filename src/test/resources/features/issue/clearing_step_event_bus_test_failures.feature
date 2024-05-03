@event_bus_test
Feature: Clearing Step Event Bus Test Failures

  Scenario: Tests Steps with Even Values passed in should internally throw exception but be cleared by StepEventBus.getEventBus().clearStepFailures()
    Then Nick sees that a step that internally throws an error when value 1 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 2 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 3 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 4 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 5 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 6 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 7 is passed should not fail

  Scenario: Tests Steps with all Odd values should pass without internal exceptions
    Then Nick sees that a step that internally throws an error when value 1 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 3 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 5 is passed should not fail
    Then Nick sees that a step that internally throws an error when value 7 is passed should not fail

