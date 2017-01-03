package Stepdefs.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.*;
import Stepdefs.HooksSelenium;


public class facebook {

    private WebDriver driver;

    public facebook()
    {
        driver = HooksSelenium.driver;
    }

    @Given("^I have opened the browser$")
    public void openBrowser() {
        //System.setProperty("webdriver.gecko.driver", "C://Users//elquiff//IdeaProjects//cucumber//browsers//geckodriver.exe");
        //driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com/");
    }

    @When("^I open Facebook website$")
    public void goToFacebook() {
        driver.navigate().to("https://www.facebook.com/");
    }

    @Then("^Login button should exist$")
    public void loginButton() {
        if(driver.findElement(By.id("loginbutton")).isEnabled()) {
            System.out.println("Test 1 Pass");
        } else {
            System.out.println("Test 1 Fail");
        }


    }
}
