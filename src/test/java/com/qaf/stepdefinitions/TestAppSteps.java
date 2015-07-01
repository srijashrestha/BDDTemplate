package com.qaf.stepdefinitions;



import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestAppSteps {

    private static WebDriver driver;
    private static String browser;


    public WebDriver getDriver() {
       if (browser.equalsIgnoreCase ("Firefox")) {
           driver = new FirefoxDriver();
       }else if(browser.equalsIgnoreCase ("IE")){
           System.setProperty("webdriver.ie.driver", "src/test/browser/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        return driver;

    }

    @After
    public void cleanUp() {driver.quit();
    }


    @Given("^I navigate to Gmail site with browser (.*?)$")
    public void i_navigate_to_Gmail_site(String browserName) throws Throwable {
       browser=browserName;
        getDriver().get("https://www.gmail.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Then("^I should see the message 'Sign in to continue to Gmail'$")
    public void i_should_see_the_message_Sign_in_to_continue_to_Gmail() throws Throwable {
        Assert.assertEquals("Sign in to continue to Gmail", driver.findElement(By.className("hidden-small")).getText());
    }

    @When("^I enter username as 'kaplantesters'$")
    public void i_enter_username_as_kaplantesters() throws Throwable {
        driver.findElement(By.id("Email")).sendKeys("kaplantesters");
    }

    @When("^I click the Next$")
    public void i_click_the_Next() throws Throwable {
        driver.findElement(By.id("next")).click();
    }

    @When("^I enter password as 'Kaplan(\\d+)'$")
    public void i_enter_password_as_Kaplan(int arg1) throws Throwable {
        driver.findElement(By.id("Passwd")).sendKeys("Kaplan2015");
    }

    @When("^I click on Sign In$")
    public void i_click_on_Sign_In() throws Throwable {
        driver.findElement(By.id("signIn")).click();
    }

    @Then("^I should see an error message 'Please enter your email\\.'$")
    public void i_should_see_an_error_message_Please_enter_your_email() throws Throwable {
        Assert.assertEquals("Please enter your email.", driver.findElement(By.id("errormsg_0_Email")).getText());

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("target/" + browser + "loginFailScreenShot.png"));
    }

    @Then("^I should be see 'kaplantesters@gmail\\.com'$")
    public void i_should_be_see_kaplantesters_gmail_com() throws Throwable {
        Assert.assertEquals("kaplantesters@gmail.com",
                driver.findElement(By.xpath("//a[contains(@class,'gb_ga gb_l gb_r gb_h')]")).getText());

    }

    @Then("^I should be able to SignOut$")
    public void i_should_be_able_to_SignOut() throws Throwable {
        driver.findElement(By.xpath("//a[contains(@class,'gb_ga gb_l gb_r gb_h')]")).click();
        driver.findElement(By.id("gb_71")).click();
    }
  }

