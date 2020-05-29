package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import nopcommerce_packages.ProductEmail;

public class EmailFriendPage extends PageBase {

    /********************************* Global Variables *****************/
    /**************************** Web Elements Locators ***************************/
    protected WebDriver driver;
    By friendEmail = By.xpath("//input[@id='FriendEmail']");
    By MyEmail = By.xpath("//input[@id='YourEmailAddress']");
    By Message = By.xpath("//textarea[@id='PersonalMessage']");
    By Send = By.xpath("//input[@name='send-email']");

    /********************* Constructor ***************************/
    public EmailFriendPage(WebDriver driver) {
	this.driver = driver;

    }

    /***************************** Methods ************************************/

    public void sendProduct_as_user(ProductEmail data) {
	Send_Keys(driver.findElement(friendEmail), data.GetFriendEmail());
	Send_Keys(driver.findElement(Message), data.GetMessage());
	click_Element(driver.findElement(Send));

    }

}
