package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nopcommerce_packages.UserLogin;

public class UserLoginPage extends PageBase {

    /************* Web Locators **************************/
    protected WebDriver driver;
    By Email = By.xpath("//input[@id='Email']");
    By Pass = By.xpath("//input[@id='Password']");
    By Remember = By.xpath("//input[@id='RememberMe']");
    By Login = By.xpath("//input[@value='Log in']");
    By forgot = By.xpath("//a[contains(@href,'passwordrecovery')]");
    By register = By.xpath("//a[contains(@href,'register')]");

    /************* Web construcctor **************************/

    public UserLoginPage(WebDriver driver) {

	this.driver = driver;
    }

    /*************
     * Web Elements actions
     *
     * @throws InterruptedException
     **************************/

    public WebDriver login(UserLogin user) throws InterruptedException {

	Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement EmailElement = wait.until(ExpectedConditions.presenceOfElementLocated(Email));
	Send_Keys(EmailElement, user.get_email());

	// Enter the password
	WebElement PassElement = wait.until(ExpectedConditions.presenceOfElementLocated(Pass));
	Send_Keys(PassElement, user.get_Password());

	Thread.sleep(1000);
	click_Element(driver.findElement(Login));

	return driver;

    }

}
