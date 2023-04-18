package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on sign in
        driver.findElement(By.linkText("Sign In")).click();
//verify the welcome back message
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class= 'page__heading']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test

    public void verifyTheErrorMessage(){
        //click on sign in
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("Sam123@yahoo.com");
        //enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("123xyz");
        //click on login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //Verify the error message ‘Invalid email or password.’
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement =driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessge = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessge);
    }
    @After
    public void tearDown() {
        closeBrowser(); //from base test
    }
}
