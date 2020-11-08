package computerDatabase.util;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	private WebDriver driver;

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenShot() throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("src/test/resources/printScreen/" + new Date());


		FileUtils.copyFile(SrcFile, DestFile);
	}

}
