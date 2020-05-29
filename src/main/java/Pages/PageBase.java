package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    public void click_Element(WebElement Element) {

	Element.click();
    }

    public void Send_Keys(WebElement Element, String values) {

	System.out.println("page basee  " + values);

	Element.sendKeys(values.trim());
    }

    public void Send_Keys(WebElement Element, Keys modifierKey) {

	Element.sendKeys(modifierKey);
    }

    public void Select_value(WebElement Element, String values) {
	Element.click();
	Select s = new Select(Element);
	s.selectByVisibleText(values);
    }

    public String get_text(WebElement Element) {

	return Element.getText();

    }

    public void check_value_AutoSugg(WebElement Element, JavascriptExecutor js, String value)
	    throws InterruptedException {
	Send_Keys(Element, Keys.DOWN);
	String Script = "return document.getElementById(\"small-searchterms\").value ;";
	String visible = (String) js.executeScript(Script);

	int timeout = 0;
	while (!visible.equalsIgnoreCase("Apple iCam")) {
	    timeout++;
	    Send_Keys(Element, Keys.DOWN);
	    Thread.sleep(1000);
	    visible = (String) js.executeScript(Script);
	    if (visible.equalsIgnoreCase("Apple iCam")) {
		Send_Keys(Element, Keys.ENTER);
	    }
	    if (timeout >= 5) {

		break;
	    }

	}

    }

    public int validatelinks(WebElement elemnt) throws MalformedURLException, IOException {
	int responseValue = 0;
	String url;
	HttpURLConnection huc;

	url = elemnt.getAttribute("href");
	huc = (HttpURLConnection) (new URL(url)).openConnection();
	huc.setRequestMethod("HEAD");
	huc.connect();

	responseValue = huc.getResponseCode();

	return responseValue;
    }

}
