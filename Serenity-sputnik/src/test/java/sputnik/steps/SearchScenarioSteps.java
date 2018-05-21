package sputnik.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sputnik.pages.ResultPage;
import sputnik.pages.SearchPage;

import static org.junit.Assert.assertTrue;

public class SearchScenarioSteps {
    SearchPage searchPage;
    ResultPage resultPage;

    @Given("User on the Sputnik search page")
    public void givenUserOnSearchPage() {
        searchPage.open();
    }

    @When("User search for (.*)")
    public void givenUserClicksOnInput(String query) {
        searchPage.search(query);
    }

    @Then("Search results contains (.*)")
    public void searchResultsListContainsQuery(String results) {
        resultPage.resultsAreDisplayed();
        assertTrue(resultPage.searchBarGetText().contains(results));
    }
}
