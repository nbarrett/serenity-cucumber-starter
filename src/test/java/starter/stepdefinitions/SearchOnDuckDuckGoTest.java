package starter.stepdefinitions;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import starter.navigation.NavigateTo;
import starter.search.SearchFor;
import starter.search.SearchResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.*;
import static starter.matchers.StringContainsIgnoringCase.containsIgnoringCase;

@RunWith(SerenityRunner.class)
public class SearchOnDuckDuckGoTest {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void UsingShouldAPI() {
        final Actor actor = theActorCalled("nick");
        actor.attemptsTo(NavigateTo.theDuckDuckGoHomePage(),
                SearchFor.term("cucumber"));
        actor.should(
                seeThat("search result titles",
                        SearchResult.titles(), hasSize(greaterThan(0))),
                seeThat("search result titles",
                        SearchResult.titles(), everyItem(containsIgnoringCase("cucumber"))));

    }

    @Test
    public void usingEnsureAPI() {
        final Actor actor = theActorCalled("nick");
        actor.attemptsTo(NavigateTo.theDuckDuckGoHomePage(),
                SearchFor.term("cucumber"),
                Ensure.thatTheAnswersTo(SearchResult.titlesCollection()).hasSizeGreaterThan(0));
    }

}
