package SeleniumCodePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Da2PracticeNykaa {

	public static void main(String[] args) throws InterruptedException {
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://nykaa.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			// Mouse over on Brands
			Actions Builder = new Actions(driver);
			Actions Builder1 = new Actions(driver);
			WebElement brandMenu = driver.findElementByXPath("//a[text()='brands']");
			Thread.sleep(5000);
			WebElement popularMenu = driver.findElementByXPath("//a[text()='Popular']");
			Builder.moveToElement(brandMenu).build().perform();
			Builder1.moveToElement(popularMenu).build().perform();
			driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']").click();
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> reqwindow = new ArrayList<String>(windowHandles);
			String reqWindow = reqwindow.get(1);
			driver.switchTo().window(reqWindow);
			System.out.println(driver.getTitle());

			// Click on SortBY

			driver.findElementByXPath("//i[@class='fa fa-angle-down']").click();

			// Select Customer Top rated

			driver.findElementByXPath("//span[text()='customer top rated']").click();

			// Click on Category menu

			Thread.sleep(3000);

			driver.findElementByXPath("//div[text()='Category']").click();

			Actions Builder2 = new Actions(driver);

			WebElement source = driver.findElementByXPath("//span[text()='Makeup (355)']");

			WebElement target = driver.findElementByXPath("//span[text()='Shampoo (21)']");

			Builder2.dragAndDrop(source, target).build().perform();

			// Click on Shampoo

			target.click();

			// Check filter is applied with shampoo

			if (driver.findElementByXPath("(//input[@id='chk_Shampoo_undefined'])[1]").isSelected()) {
				System.out.println("Shampoo checkbox is selected");
			} else {
				System.out.println("Shampoo checkbox is not selected");
			}

			// Click on Paris Color Protection shampoo

			driver.findElementByXPath("//span[contains(text(),'Paris Colour')]").click();

			Set<String> windowHandles1 = driver.getWindowHandles();

			List<String> windowhandleobj = new ArrayList<String>(windowHandles1);

			String newwindowObj = windowhandleobj.get(2);

			// Navigate to new window

			driver.switchTo().window(newwindowObj);

			// Select the size

			driver.findElementByXPath("//span[text()='175ml']").click();

			// Print the MRP of the product

			WebElement mrpPrice = driver.findElementByXPath("(//span[text()='150'])[1]");

			String mrpFinalPrice = mrpPrice.getText();

			System.out.println("MRP price of the product is" + mrpFinalPrice);

			driver.findElementByXPath("(//button[text()='ADD TO BAG'])[1]").click();

			// Click on Shopping Icon

			driver.findElementByXPath("//div[@class='AddBagIcon']").click();

			// Printing the Grand Total

			WebElement printGrandTotal = driver.findElementByXPath("//div[@class='value medium-strong']");

			System.out.println("Grand Total is:" + printGrandTotal);

			// Click on Proceed button

			driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();

			// Click on Continue as Guest

			driver.findElementByXPath("//button[@class='btn full big']").click();

			// Print the warning message

			WebElement printWarningMsg = driver.findElementByXPath("//div[@class='message']");

			System.out.println(printWarningMsg.getText());
			
			//Close all the windows

			driver.quit();

		} catch (Exception e) {

		}

	}

}
