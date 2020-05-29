package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import nopcommerce_packages.User;

public class UserRegestration extends PageBase {

	/*************************** Locators ***************************/
	protected WebDriver driver;
	By genderMale = By.xpath("//input[@id='gender-male']");
	By genderFmale = By.xpath("//input[@id='gender-female']");
	By firstName = By.xpath("//input[@id='FirstName']");
	By lastName = By.xpath("//input[@id='LastName']");
	By date_day = By.xpath("//div/select[@name='DateOfBirthDay'][1]");
	By date_month = By.xpath("//div/select[@name='DateOfBirthMonth'][1]");
	By date_year = By.xpath("//div/select[@name='DateOfBirthYear'][1]");
	By email = By.xpath("//input[@id='Email']");
	By companyName = By.xpath("//input[@id='Company']");
	By Newsletter = By.xpath("//input[@id='Newsletter']");
	By Password = By.xpath("//input[@id='Password']");
	By ConfirmPassword = By.xpath("//input[@id='ConfirmPassword']");
	By submit = By.xpath("//input[@id='register-button']");
	By result = By.xpath("//div[@class='result']");
	By Rgcontinue = By.xpath("//input[@value='Continue']");

	/**************************** Driver Initialization ***************/
	public UserRegestration(WebDriver driver) {

		this.driver = driver;

	}

	/****************************
	 * WebElemnts Method
	 *
	 * @throws InterruptedException
	 ***************/
	public void registration(User user) throws InterruptedException {

		Thread.sleep(2000);

		if ((user.get_gender()).contains("Fmale")) {
			click_Element(driver.findElement(genderFmale));
		} else if (user.get_gender().contains("male")) {

			click_Element(driver.findElement(genderMale));

		}

		Send_Keys(driver.findElement(firstName), user.get_firsrname());

		Send_Keys(driver.findElement(lastName), user.get_lastName());

		Send_Keys(driver.findElement(email), user.get_email());

		Select_value(driver.findElement(date_day), user.get_date_day());

		Select_value(driver.findElement(date_month), user.get_date_month());

		Select_value(driver.findElement(date_year), user.get_date_year());

		Send_Keys(driver.findElement(companyName), user.get_companyName());

		Assert.assertTrue(driver.findElement(Newsletter).isSelected());

		Send_Keys(driver.findElement(Password), user.get_Password());

		Send_Keys(driver.findElement(ConfirmPassword), user.get_Password());

		click_Element(driver.findElement(submit));

		Assert.assertEquals("Your registration completed",
				driver.findElement(result).getText());

		click_Element(driver.findElement(Rgcontinue));

	}

}
