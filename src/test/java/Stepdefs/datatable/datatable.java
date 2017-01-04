package Stepdefs.datatable;

import Stepdefs.HooksSelenium;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
/**
 * Created by elquiff on 03/01/2017.
 */
public class datatable {

    final Logger logger = LoggerFactory.getLogger(datatable.class);
    private WebDriver driver;

    public datatable()
    {
        driver = HooksSelenium.driver;
    }

        @Given("^I am on the login page$")
        public void i_am_on_the_login_page()throws Throwable{
            //Intiate web browser instance. driver = new FirefoxDriver();
            driver.navigate().to("https://www.facebook.com/");
            String url = driver.getCurrentUrl();
            logger.info(url);
        }

        @When("^I enter invalid data on login$")
        public void i_enter_invalid_data_on_login(DataTable usercredentials)throws Throwable{
            //Initialize data table
            //Write the code to handle Data Table
            List<List<String>> data = usercredentials.raw();

            //This is to get the first data of the set (First Row + First Column)
            driver.findElement(By.id("email")).sendKeys(data.get(1).get(0));

            //This is to get the first data of the set (First Row + Second Column)
            driver.findElement(By.id("pass")).sendKeys(data.get(1).get(1));

            driver.findElement(By.id("loginbutton")).click();
        }

        @Then("^the login should be unsuccessful$")
        public void the_login_should_be_unsuccessful() throws Throwable{
            // Write code here that turns the phrase above into concrete actions
            driver.findElement(By.cssSelector("._50f6"));
        }
}


