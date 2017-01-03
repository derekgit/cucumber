package Stepdefs.google;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Stepdefs.HooksSelenium;

/**
 * Created by elquiff on 03/01/2017.
 */
public class googleaddition {

    private WebDriver driver;

    public googleaddition()
    {
        driver = HooksSelenium.driver;
    }

    @Given("^I open google\\.com$")
    public void i_open_google_com(){
        //driver.navigate().to("https://www.google.com/");
        String currentUrl = driver.getCurrentUrl();
        //System.out.println("currentURL");
        driver.get("https://www.google.com/");
    }
    @When("^I enter \"([^\"]*)\" in search textbox$")
    public void I_enter_in_search_textbox(String additionTerms)  {

        //Write term in google textbox
        WebElement googleTextBox = driver.findElement(By.id("lst-ib"));
        googleTextBox.sendKeys(additionTerms);

        //Click on searchButton
        WebElement searchButton = driver.findElement(By.name("btnG"));
        searchButton.click();
    }

    @Then("^I should get result as (\\d+)$")
    public void I_should_get_correct_result(String expectedResult) {
        //Get result from calculator
        WebElement calculatorTextBox = driver.findElement(By.id("cwos"));
        String result = calculatorTextBox.getText();

        //Verify that result of 2+2 is 4
        Assert.assertEquals(result, expectedResult);


    }



}
