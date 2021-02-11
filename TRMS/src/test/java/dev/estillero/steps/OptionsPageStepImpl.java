package dev.estillero.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.estillero.pages.OptionsPage;
import dev.estillero.runners.TestRunner;

public class OptionsPageStepImpl {
	
	public static OptionsPage optionspage = TestRunner.optionspage;
	public static WebDriver driver = TestRunner.driver;
	
	@Given("^User is on Options page$")
	public void user_is_on_Options_page() {
	    driver.get("http://localhost:8080/TRMS/options.html");
	}

	@When("^User clicks Create New Request$")
	public void user_clicks_create() {
	    optionspage.create.click();
	}

	@Then("^The title of the page should be Tuition Reimbursement Form$")
	public void the_title_of_the_page_should_be_tuition_reimbursement_form() {
	    Assert.assertEquals("Tuition Reimbursement Form", driver.getTitle());
	}
	
	@When("^User clicks View My Requests$")
	public void user_clicks_view() {
	    optionspage.read.click();
	}

	@Then("^The title of the page should be Request Viewer$")
	public void the_title_of_the_page_should_be_request_viewer() {
	    Assert.assertEquals("Request Viewer", driver.getTitle());
	}
	
	@When("^User clicks Open Message Center$")
	public void user_clicks_update() {
	    optionspage.update.click();
	}

	@Then("^The title of the page should be Message Center$")
	public void the_title_of_the_page_should_be_message_center() {
	    Assert.assertEquals("Message Center", driver.getTitle());
	}

}
