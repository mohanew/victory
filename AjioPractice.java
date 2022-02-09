package SeleniumCodePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AjioPractice {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./DriversNew/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/women");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//input[@placeholder='Search AJIO']").sendKeys("Bags");

		// Click on Women HandBags

		driver.findElementByXPath("(//a[@class='search-suggestionList  '])[2]").click();

		// Click on Five Grid

		driver.findElementByXPath("//div[@class='five-grid']").click();

		WebElement findElementByXPath = driver.findElementByXPath("//div[@class='filter-dropdown']//select");

		Select select = new Select(findElementByXPath);

		// Select sort by whats new

		select.selectByValue("newn");

		Thread.sleep(3000);

		// Click on Price
		WebElement price = driver.findElementByXPath("(//span[@class='facet-left-pane-label'])[3]");

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;

		executor2.executeScript("arguments[0].click();", price);

		// Enter Min price

		driver.findElementByXPath("//*[@id=\"minPrice\"]").sendKeys("2000");

		// Enter Max price

		driver.findElementByXPath("//*[@id=\"maxPrice\"]").sendKeys("5000");

		// Click enter
		.

		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();

		// Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)");

		// Click on Puma Ferari LS Shoulder Bag

		driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']").click();

		Set<String> windows = driver.getWindowHandles();

		List<String> values = new ArrayList<String>(windows);

		String string = values.get(1);

		// navigate to new window

		driver.switchTo().window(string);

		// Calculate the discount price

		String price1 = driver.findElementByXPath("//div[@class='prod-sp']").getText();

		String price2 = price1.replaceAll("\\D", "");

		// Get the Price

		int convertedpriceInt = Integer.parseInt(price2);

		// Get the Discounted price

		String discountPrice = driver.findElementByXPath("//div[@class='promo-discounted-price']//span").getText();

		String discountPrice1 = discountPrice.replaceAll("\\D", "");

		int discountedprice = Integer.parseInt(discountPrice1);

		if ((convertedpriceInt > 2690)) {
			int actualPrice = convertedpriceInt - discountedprice;
		}

		// Check the availablity of the product for the pincode 560043

		// Click on enter pin code to know estimated delivery link

		driver.findElementByXPath("(//div[@id='edd']//span)[2]").click();

		// Enter the pin code

		driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("560043");

		// Click on Confirm Pin code

		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();

		// Get the Expected Delivery date and print it

		WebElement expDeliveryDate = driver
				.findElementByXPath("//span[@class='edd-message-success-details-highlighted']");

		String expectedDelDateoutput = expDeliveryDate.getText();

		System.out.println("Expected Delivery Date is:" + expectedDelDateoutput);

		// Click on Other information

		driver.findElementByXPath("//div[@class='other-info-toggle']").click();

		// Get the Customer care address

		String getCuscareAddress = driver.findElementByXPath("(//span[@class='other-info'])[6]").getText();

		// Print the customer care address

		System.out.println("Customer care address:" + getCuscareAddress);

		Thread.sleep(5000);

		// Click on Add to bag button

		driver.findElementByXPath("//div[@class='pdp-addtocart-button']").click();

		Thread.sleep(15000);

		// Click on Go to Bag

		Actions action = new Actions(driver);

		WebElement findElementByXPath2 = driver.findElementByXPath("//div[@class='pdp-addtocart-button']");

		action.moveToElement(findElementByXPath2).click();

		Thread.sleep(3000);

		Actions action1 = new Actions(driver);

		WebElement findElementByXPath3 = driver.findElementByXPath("//span[text()='GO TO BAG']");

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", findElementByXPath3);

		// Check the order total

		String orderTot = driver.findElementByXPath("//span[@class='price-value bold-font']").getText();

		String OrderTotal1 = orderTot.replaceAll("\\D", "");

		int convertorderTotal = Integer.parseInt(OrderTotal1);

		System.out.println("Order Total is:" + convertorderTotal);

		// Click on proceed

		driver.findElementByXPath("//button[text()='Proceed to shipping']").click();

		// Enter Coupon code

		driver.findElementByXPath("//input[@id='couponCodeInput']").sendKeys("EPIC");

		// Click on close window

		driver.findElementByXPath("//div[@class='ic-close-quickview']").click();

		// Click on apply button

		driver.findElementByXPath("//button[text()='Apply']").click();

		// Check for the coupon savings amount

		String couponDisAmt = driver.findElementByXPath("//p[@class='you-save-text']").getText();

		System.out.println("Coupon Discount is:" + couponDisAmt);

		String couponAmtInt = couponDisAmt.replace("[^a-zA-Z0-9,-:space:]", "");

		System.out.println("Coupon Savings amount is:" + couponAmtInt);

		// Click on Delete link

		driver.findElementByXPath("//div[@class='delete-btn']").click();

		// Click on Delete Item

		driver.findElementByXPath("(//div[@class='delete-btn'])[2]").click();

		// Close all the browsers]
		driver.quit();

	}

}
