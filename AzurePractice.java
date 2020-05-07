package SeleniumCodePractice;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AzurePractice {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./DriversNew/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://azure.microsoft.com/en-in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on pricing

		driver.findElementByLinkText("Pricing").click();

		// Click on Pricing calculator

		driver.findElementByLinkText("Pricing calculator").click();

		// Click on Containers

		driver.findElementByXPath("//button[text()='Containers']").click();

		// Click on Container Instances

		driver.findElementByXPath("(//span[@class='sd-truncateText'])[56]").click();

		Thread.sleep(1000);

		// Click on Container Instance Added view

		driver.findElementByXPath("//a[text()='View']").click();

		// Select Region as South India

		WebElement findElementByXPath = driver.findElementByXPath("//select[@name='region']");

		Select select = new Select(findElementByXPath);

		select.selectByVisibleText("South India");

		// Set the Duration as 180000 seconds

		driver.findElementByXPath("(//div[@class='wa-textNumber'])[2]//input").clear();

		Thread.sleep(1000);

		driver.findElementByXPath("(//div[@class='wa-textNumber'])[2]//input").sendKeys("180000");

		// Select the memory as 4 GB

		WebElement findElementByXPath2 = driver.findElementByXPath("(//div[@class='calculator-dropdown '])[3]//select");

		Select selectMemory = new Select(findElementByXPath2);

		selectMemory.selectByVisibleText("4 GB");

		Thread.sleep(1000);

		// Enable Show Dev/test Pricing

		driver.findElementByXPath("//button[@id='devtest-toggler']").click();

		// Select the currency

		WebElement findElementByXPath3 = driver.findElementByXPath("//select[@class='select currency-dropdown']");

		Select selectCurrency = new Select(findElementByXPath3);

		selectCurrency.selectByValue("INR");

		// Print the Estimated Monthly Cost

		String getEstMonCost = driver.findElementByXPath("(//span[@class='numeric'])[6]").getText();

		System.out.println("Estimated Monthly Cost is:" + getEstMonCost);

		// Click on Export button

		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		// Check the file in local folder

		chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("download.default_directory", "C:\\Users\\MohanNiru\\Downloads");
		ChromeOptions options2 = new ChromeOptions();
		options2.setExperimentalOption("prefs", chromePrefs);
		File file = new File("C:\\\\Users\\\\MohanNiru\\\\Downloads\\ExportedEstimate.xlsx");

		if (file.exists()) {

			System.out.println("File exist for container instance in the specified path");
		}

		// Click on Example Scenarios

		Thread.sleep(3000);

		WebElement findElementByLinkText = driver.findElementByLinkText("Example Scenarios");

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", findElementByLinkText);

		// Click on CI/CD for containers

		WebElement findElementByXPath4 = driver.findElementByXPath("//button[@title='CI/CD for Containers']");

		executor.executeScript("arguments[0].click();", findElementByXPath4);

		// Click on Add to Estimate

		WebElement findElementByXPath5 = driver.findElementByXPath("//button[text()='Add to estimate']");

		executor.executeScript("arguments[0].click();", findElementByXPath5);

		selectCurrency.selectByValue("INR");

		// Enable Show Dev/test Pricing

		WebElement findElementByXPath6 = driver.findElementByXPath("//button[@id='devtest-toggler']");

		executor.executeScript("arguments[0].click();", findElementByXPath6);

		// Click on Export button

		Thread.sleep(3000);

		WebElement findElementByXPath7 = driver
				.findElementByXPath("//button[@class='calculator-button button-transparent export-button']");

		executor.executeScript("arguments[0].click();", findElementByXPath7);

		Thread.sleep(2000);

		chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("download.default_directory", "C:\\Users\\MohanNiru\\Downloads");
		ChromeOptions options3 = new ChromeOptions();
		options3.setExperimentalOption("prefs", chromePrefs);
		File file1 = new File("C:\\\\Users\\\\MohanNiru\\\\Downloads\\ExportedEstimate.xlsx");

		if (file1.exists()) {

			System.out.println("Downloaded file exist in the specified path");
		}
		driver.quit();

	}

}
