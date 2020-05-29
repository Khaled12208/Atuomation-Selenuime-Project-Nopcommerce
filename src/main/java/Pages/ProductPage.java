package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase {

    /**************** locator *********************/

    protected WebDriver driver;
    By EmailProduct = By.xpath(
	    "/html[1]/body[1]/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[10]/div[3]/input[1]");

    /***** Contractor variables to init the driver *********************/

    public ProductPage(WebDriver driver) throws IOException {
	this.driver = driver;
    }

    /**************** Methods *********************/
    public WebDriver clickEmailProuct() {

	click_Element(driver.findElement(EmailProduct));

	return driver;
    }

}
