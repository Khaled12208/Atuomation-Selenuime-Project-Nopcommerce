package services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShoots {

	public String getScreenShotPath(String TestCaseName, WebDriver Driver)
			throws IOException {

		TakesScreenshot ts = (TakesScreenshot) Driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")
				+ "\\ScreenShoots\\" + TestCaseName + ".png";
		FileUtils.copyFile(source, new File(DestinationFile));

		return DestinationFile;
	}

}
