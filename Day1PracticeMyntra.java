package SeleniumCodePractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Day1PracticeMyntra {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Set the path to Chrome driver using set property 
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		//Initialize the Chrome driver
		ChromeDriver driver=new ChromeDriver(options);
		
	
		//navigate to the page
		driver.get("https://www.myntra.com");
		//Maximize the window
		driver.manage().window().maximize();
		//Provided timeout 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    WebElement WebElementObj1 = driver.findElementByXPath("//a[text()='Women']");
	    Actions Builder1=new Actions(driver);
		Builder1.moveToElement(WebElementObj1).build().perform();
		
	   driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
	   
	   String text = driver.findElementByXPath("//span[@class='title-count']").getText();
	   
	   String text1=text.replaceAll("\\D","");
	   int TotalCount=Integer.parseInt(text1);
	   System.out.println("Total Item Count is:"+TotalCount);
	   
	   //Validate Sum of Categories matched with total count
	   
	   String jacketsCount=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
	   String coatsCount=driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
	   
	   String jacketsCountRep=jacketsCount.replaceAll("\\D","");
	   String coatsCountRep=coatsCount.replaceAll("\\D","");
	   int jacketCt=Integer.parseInt(jacketsCountRep);
	   int coatCt=Integer.parseInt(coatsCountRep);
	   int sumofItemCount=jacketCt+coatCt;
	   if(TotalCount==sumofItemCount)
	   {
		   System.out.println("Total Items count matched with individual items count");
	   }
	    
	   //Thread.sleep(10000);
	   //Check the Coats checkbox
	   
	   driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
	   

	   //Click on more link under BRand
	   
	   driver.findElementByXPath("//div[@class='brand-more']").click();
	   
	   //Enter Brand name
	   
	   WebElement brandName = driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']");
	   brandName.sendKeys("MANGO");
	   	
	   //Click MANGO check box
	   
	   Thread.sleep(3000);
	   
	   driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div").click();
	   
	   //Close pop
	   
	   driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
	   
	   Thread.sleep(10000);
	   
	   List<WebElement> allItemMango = driver.findElements(By.xpath("//ul[@class='results-base']//h3[@class='product-brand']"));
	   
	   for (WebElement eachitemmango : allItemMango) {
		   
		   
		   if(eachitemmango.getText().equalsIgnoreCase("MANGO"))
		   {
			   //System.out.println(eachitemmango.getText());
			   System.out.println("All the coats having the text MANGO");
		   }
		   else
		   {
			   System.out.println("All the coats not having the text MANGO"); 
		   }
		   
		   
		   
     	}
	   
	   //Sort by Better Discount
	   
	   WebElement drpdownSort = driver.findElementByXPath("//div[@class='sort-sortBy']");
	   Actions Builder2=new Actions(driver);
	   Builder2.moveToElement(drpdownSort).build().perform();
	   Thread.sleep(3000);
	   driver.findElementByXPath("(//label[@class='sort-label '])[3]").click();
		
		
		//Get the first discounted item
		
		List<WebElement> getPriceDiscount = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		
		String firstItem=getPriceDiscount.get(0).getText().replaceAll("\\D","");
        int convertIntDiscount = Integer.parseInt(firstItem);
			
	     System.out.println("The First Discounted Item is:"+convertIntDiscount);
			
	     Thread.sleep(3000);
			 
		//Mouse over on Size of first item
			
		WebElement getFirstItem = driver.findElementByXPath("//span[@class='product-discountedPrice']");
		Actions Builder3=new Actions(driver);
		Builder3.moveToElement(getFirstItem).build().perform();
		driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
		
		//Close the window
		
		driver.close();
			 	
		
	}

}
