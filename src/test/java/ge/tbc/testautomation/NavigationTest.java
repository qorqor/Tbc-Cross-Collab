package ge.tbc.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class NavigationTest {
    WebDriverWait wait;

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Constants.DEMO_URL);
    }

    @Test(priority = 1, description = "Log in to the System")
    public void Authentication() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder=\"Enter your email\"]"));
        WebElement passField = driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]"));
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        emailField.sendKeys(Constants.EMPLOYEE_USR);
        passField.sendKeys(Constants.EMPLOYEE_PWD);
        submitButton.click();
        Assert.assertEquals(js.executeScript("return document.readyState"), "complete");


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
