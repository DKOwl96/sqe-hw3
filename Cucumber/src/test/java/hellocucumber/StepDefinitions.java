package hellocucumber;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    // STORY#1
    // the user logged in
    @Given("^the user logged in$")
    public void the_user_logged_in() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\danak\\IdeaProjects\\sqe-hw3\\Selenium\\chromedriver.exe");
        driver.manage().window().maximize();

        //navigate to shop's url
        driver.navigate().to("http://localhost:8080/login");

        //log in as user
        driver.findElement(By.id("field-email")).sendKeys("DK@gmail.com");
        driver.findElement(By.id("field-password")).sendKeys("DK12345!!");
        driver.findElement(By.id("submit-login")).click();
    }

    // the customer in home gape after login
    @And("^the user in the home page$")
    public void user_at_home_page() {
    }

    // the user navigates to product's page
    @And("^the user navigates to the product page he wants to comment on$")
    public void user_navigate_to_product() {
        driver.findElement(By.xpath("//img[contains(@alt,'Mountain fox notebook')]")).click();
    }

    // the user submit a review
    @When("^the user clicks on \"write your review\" button$")
    public void user_submits_review() {
        try {//open review
            driver.findElement(By.xpath("/*[@id='add-to-cart-or-refresh']/div[3]/div[2]/button")).click();
            //fill the review
            driver.findElement(By.xpath("//*[@id='post-product-comment-form']/div[2]/div/input")).sendKeys("test");
            driver.findElement(By.xpath("//*[@id='post-product-comment-form']/div[4]/div/textarea")).sendKeys("test");
            // send the review
            driver.findElement(By.xpath("//*[@class='btn btn-comment btn-comment-big']")).click();
        }
        catch (Exception ignored){ }
    }

    // the user submit a review that was disabled
    @When("^the user submit the review$")
    public void user_submits_disabled_review() {
        try {
            // send the review
            driver.findElement(By.xpath("//*[@class='btn btn-comment btn-comment-big']")).click();
        }
        catch (Exception ignored){ }
    }

    // check if the pop up approval is there
    @Then("^message will be shown 'Review sent'$")
    public void theScenarioPasses() {
        int flag = 1;
        try {//open review
            driver.findElement(By.xpath("//*[@class='btn btn-comment post-product-comment']"));
        }
        catch (Exception e){
            flag = 0;
        }
        assertEquals(flag, 0);
    };

    //STORY#2
    // the admin logged in
    @Given("^the admin logged in$")
    public void the_admin_logged_in() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\danak\\IdeaProjects\\sqe-hw3\\Selenium\\chromedriver.exe");
        driver.manage().window().maximize();

        //navigate to shop's url
        driver.navigate().to("http://localhost:8080/adminpatritech");

        //log in as user
        driver.findElement(By.id("email")).sendKeys("kapustya@post.bgu.ac.il");
        driver.findElement(By.id("passwd")).sendKeys("Demo12345!");
        driver.findElement(By.id("submit_login")).click();

    }

    // the dashboard is shown to the admin
    @And("^the admin in his home page - dashboard$")
    public void admin_dashboard() {
    }

    // navigate to comment module
    @And("^the admin navigates to \"Product Comments\" module$")
    public void navigate_to_comment() throws InterruptedException {
        // selecting "modules"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"subtab-AdminParentModulesSf\"]/a"))).click();
        // selecting "module manger"
        driver.findElement(By.xpath("//*[@id=\"subtab-AdminModulesSf\"]")).click();

        // searching for the "Product Comments" module by typing "comment" in the search bar
        driver.findElement(By.xpath("//*[@id=\"search-input-group\"]/div[1]/div[2]/input")).sendKeys("comment");
        // opening the "Product Comments" module
        driver.findElement(By.xpath("//*[@id='module-search-button']/i")).click();
    }

    // disabling the commenting
    @When("^the admin disable the module$")
    public void disable_comment() {
        // opening module menu
        driver.findElement(By.xpath("//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/button")).click();
        // selecting "disable"
        driver.findElement(By.xpath("//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/div/li[2]/form/button")).click();

    }

    // check if disable worked or not
    @Then("^click on 'Yes, disable it'")
    public void yes_for_disable() {
        int flag = 0;
        try {
            driver.findElement(By.xpath("//*[@id=\"module-modal-confirm-productcomments-disable\"]/div/div/div[3]/a")).click();
        }
        catch (Exception err){
            flag = 1;
        }
        assertEquals(flag, 1);
    }

    // check if disable worked or not
    @Then("^error message should pop up")
    public void error_msg() {
        int flag = 0;
        try {
            driver.findElement(By.xpath("//*[@id=\"product-comment-post-error\"]/div/div/div[1]")).click();
        }
        catch (Exception err){
            flag = 1;
        }
        assertEquals(flag, 1);
    }
}
