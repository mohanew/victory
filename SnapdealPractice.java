package SeleniumCodePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapdealPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./DriversNew/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Mouse over on Toys Kids Fashion & more

		Actions Builder = new Actions(driver);
		WebElement mouseToys = driver.findElementByLinkText("Toys, Kids' Fashion & more");
		Builder.moveToElement(mouseToys).build().perform();

		// Click on Toys

		driver.findElementByXPath("//span[text()='Toys']").click();

		// Click on Educational Toys in Toys & Games

		driver.findElementByXPath("//div[text()='Educational Toys']").click();

		// Click on Customer Rating

		driver.findElementByXPath("//label[@for='avgRating-4.0']").click();

		Thread.sleep(6000);

		// Click on Discount

		WebElement discval = driver.findElementByXPath("(//a[contains(text(),'50')])[1]");

		Actions buildercls = new Actions(driver);

		buildercls.moveToElement(discval).click().perform();

		// Click on enter pincode

		driver.findElementByXPath("//input[@placeholder='Enter your pincode']").sendKeys("600061");

		driver.findElementByXPath("//button[@class='pincode-check']").click();

		// Mouse over the first product

		WebElement mouseFirstProduct = driver.findElementByXPath("(//img[@class='product-image wooble'])[1]");

		Actions Builder1 = new Actions(driver);

		Builder1.moveToElement(mouseFirstProduct).build().perform();

		Thread.sleep(4000);

		// Click on Quick view

		WebElement findElementByXPath = driver.findElementByXPath(
				"(//div[@class='product-tuple-description ']/preceding::div[contains(text(),'Quick')])[1]");

		Actions buildercls1 = new Actions(driver);

		buildercls1.moveToElement(findElementByXPath).click().perform();

		// Click on View Details
		System.out.println("Entering View Details");

		Thread.sleep(2000);

		// driver.findElementByXPath("//a[@class=' btn btn-theme-secondary
		// prodDetailBtn']").click();
		System.out.println("Completed View Details");

		// String firstWIndow = listItems.get(1);

		// Switch to first window

		// driver.switchTo().window(firstWIndow);

		System.out.println(driver.getTitle());

		// Capture the price

		String price = driver.findElementByXPath("//span[@class='payBlkBig']").getText();

		String priceamt = price.replaceAll("\\D", "");

		int priceint = Integer.parseInt(priceamt);

		System.out.println("Price of the product:" + priceint);

		// Capture the delivery charge

		driver.findElementByXPath("//a[contains(text(),'view')]").click();

		String deliverycharge = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();

		String delcharge = deliverycharge.replace("Rs", "");

		String removeChar = delcharge.replaceAll("[^a-zA-Z0-9]", "");

		int delchargeint = Integer.parseInt(removeChar);

		System.out.println("Delivery charge is:" + delchargeint);

		// Click on Add to Cart

		driver.findElementByXPath("//span[text()='add to cart']").click();

		// Payamount

		String payamt = driver.findElementByXPath("(//span[@class='price'])[2]").getText();

		String payAmount = payamt.replaceAll("\n", "");

		String payconvert = payAmount.replace("Rs. ", "");

		int payamountTotal = Integer.parseInt(payconvert);

		// Validate sum of price and delivery charge is pay amount

		int total = priceint + delchargeint;

		if (total == payamountTotal) {
			System.out.println("Pay amount is validated and working fine");
		} else {
			System.out.println("Pay amount is not working");
		}

		// Search for sanitizer

		driver.findElementByXPath("(//input[@name='keyword'])[1]").sendKeys("Sanitizer");

		// Click on search

		driver.findElementByXPath("//span[@class='searchTextSpan']").click();

		// Click on Bio ayurveda Neem powder

		driver.findElementByXPath("(//img[@class='product-image '])[1]").click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listItems = new ArrayList<String>(windowHandles);

		String firstWIndow = listItems.get(1);

		// Switch to first window

		driver.switchTo().window(firstWIndow);

		// Fetch the price of sanitizer

		String pricesan = driver.findElementByXPath("//span[@itemprop='price']").getText();

		int pricesanitizer = Integer.parseInt(pricesan);

		// Fetch the delivery charge of sanitizer

		String delicharge = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();

		String delchargeSanitizer = delicharge.replaceAll("\n", "");

		String delconvertString = delchargeSanitizer.replace("(+) Rs ", "");

		int delChargeSanInt = Integer.parseInt(delconvertString);

		// Add the price and delivery charge

		int TotalamtSanitizer = pricesanitizer + delChargeSanInt;

		// Click on Add to cart

		driver.findElementByXPath("(//span[text()='ADD TO CART'])[1]").click();

		Thread.sleep(2000);

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listItems1 = new ArrayList<String>(windowHandles1);

		String secondWIndow = listItems1.get(1);

		driver.switchTo().window(secondWIndow);

		String getTextverify = driver.findElementByXPath("//div[text()='Daily Needs Basket']").getText();
		System.out.println("Popup Header is:" + getTextverify);
		driver.findElementByXPath("//div[text()='CHECKOUT']").click();

		Thread.sleep(5000);

		String firstprodText = driver.findElementByXPath("//span[@class='item-subtotal-black']").getText();

		int tt = Integer.parseInt(firstprodText.replaceAll("\\D", ""));

		System.out.println("First Product Price:" + tt);

		String secondProd = driver.findElementByXPath("(//span[@class='item-subtotal-black'])[4]").getText();

		int sp = Integer.parseInt(secondProd.replaceAll("\\D", ""));

		System.out.println("Second product price:" + sp);

		// Proceed to pay price

		String proceedprice = driver
				.findElementByCssSelector("#checkout-continue > input.btn.btn-xl.rippleWhite.cart-button")
				.getAttribute("value");

		System.out.println(proceedprice);

		int pp = Integer.parseInt(proceedprice.replaceAll("\\D", ""));

		System.out.println("Proceed to pay amount:" + pp);

		// Validate Proceed to pay amount is the sum of individual items

		if (pp == tt + sp) {
			
			System.out.println("Proceed to pay amount is matches with the sum of individual product amount");
			
		} else {
			
			System.out.println("Proceed to pay amount is not matches with the individual amount");
		}

		driver.quit();

	}

}
