package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchItemsPage {

	/*************** Web Element **********************/

	protected WebDriver driver;
	By seach_box = By.xpath("//input[@id='small-searchterms']");
	By seach_buttom = By.xpath(
			"/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/form[1]/input[2]");

	/*************** Constructor **********************/
	public SearchItemsPage(WebDriver driver) {

		this.driver = driver;

	}

	/*************** Methods **********************/

}
