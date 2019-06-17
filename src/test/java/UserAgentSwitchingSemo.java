import java.io.File;
import java.io.IOException;
import java.util.Calendar;

//import org.apache.commons.io.FileSystemUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class UserAgentSwitchingSemo {

	//
	@Test
	public void testMotoGSiteWithMobieUA() throws IOException {

		System.setProperty("webdriver.gecko.driver", "c:/selenium_drivers/geckodriver.exe");
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12A366 Safari/600.1.4");
//		WebDriver driver = new FirefoxDriver(profile);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(375, 667));
		driver.get("https://www.motorola.in/products/moto-g-plus");
		
		TakesScreenshot obj = (TakesScreenshot) driver;
		File snap = obj.getScreenshotAs(OutputType.FILE);
		System.out.println("Snap is saved at:"+snap.getAbsolutePath()); // temp
		
		String currentTimeStamp = Calendar.getInstance().getTime().toString().replaceAll(":", "-"); 
		
		Files.copy(snap, new File("c:\\tmp\\snap"+currentTimeStamp+"_sel3.png"));
		
	}
}
