package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends PageBase {
	/********** global variables ********************************/
	protected WebDriver driver;
	By Name_box = By.xpath("//input[@id='FullName']");
	By Email_box = By.xpath("//input[@id='Email']");
	By submit = By.xpath("//input[@name='send-email']");
	By Enquire = By.xpath("//textarea[@id='Enquiry']");
	By result = By.xpath("//div[@class='result']");

	public ContactUsPage(WebDriver driver2) {
		this.driver = driver2;

	}

	/**********
	 * Methods
	 *
	 * @return
	 * @throws InterruptedException
	 ********************************/

	public String valid_send_Enquire() throws InterruptedException {
		Thread.sleep(200);
		Send_Keys(driver.findElement(Name_box), "Khaled Mohamed Farh");
		Thread.sleep(200);

		Send_Keys(driver.findElement(Email_box), "Khaled@gmil.com");
		Thread.sleep(200);

		Send_Keys(driver.findElement(Enquire),
				"i wanna ask about new products");
		click_Element(driver.findElement(submit));

		return get_text(driver.findElement(result));

	}

}
