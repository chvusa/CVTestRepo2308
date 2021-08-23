package practise2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlineOrderE2E {

	WebDriver driver;
	Actions mouse;

	@BeforeClass
	public void Openbrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void OnlineOrdere2e() throws InterruptedException

	{

		WebElement key = driver.findElement(By.xpath("//a[text()='Women']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(key).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Casual Dresses']")).click();
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.xpath("//div[@class='product-image-container']"));
		mouse.moveToElement(img).perform();
		driver.findElement(By.className("quick-view")).click();
		Thread.sleep(10000);
		// driver.switchTo().frame("fancybox-frame1625598892200");
		driver.switchTo().frame(0);
		System.out.println("successful switched to iframe");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		System.out.println("Add quantity as 2");
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[1]")).click();
		System.out.println("Add to Cart");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();
		System.out.println("proceed to check out");
		Thread.sleep(3000);
		String Total = driver.findElement(By.id("total_price")).getText();
		System.out.println(Total);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		System.out.println("Proceed to checkout first program on Summary");
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void signin() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("chakri.vusa@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("vusa1234");
		driver.findElement(By.id("SubmitLogin")).click();
		System.out.println("successfully logged in on Test 2");
		Thread.sleep(2000);

	}

	@Test(priority = 3)

	public void Addressdetails() throws InterruptedException {
		System.out.println("Enter in Test 3");
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Adress Selected");
		Thread.sleep(2000);
		System.out.println("Address selected successfully");
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		Thread.sleep(3000);
		WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(cart).perform();
		System.out.println("View the cart");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Check')]")).click();
		System.out.println("click on checkout on cart");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		Thread.sleep(3000);
		System.out.println("Clicked successfully on Proceed Check out on Summary");
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		Thread.sleep(2000);
		System.out.println("Clicked successfully on Proceed Check out on Addresss");
		driver.findElement(By.id("cgv")).click();
		Thread.sleep(1000);
		System.out.println("Select shipping checkbox");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		Thread.sleep(2000);
		System.out.println("Proceed to check out on Shipping");
		String shipping = driver.findElement(By.xpath("//td[@id='total_price_container']")).getText();
		System.out.println(shipping);
		System.out.println("Payment page should displayed");
		Thread.sleep(1000);

	}

	@Test(priority = 4)
	public void contactus() {
		System.out.println("click on contactus");
		driver.findElement(By.id("contact-link")).click();
		WebElement SubjectHeading = driver.findElement(By.id("id_contact"));
		Select reasons = new Select(SubjectHeading);
		reasons.selectByVisibleText("Customer service");
		List<WebElement> sbh = reasons.getOptions();
		System.out.println(sbh.size());
		for (int cnt = 0; cnt < sbh.size(); cnt++) {
			System.out.println(sbh.get(cnt).getText());
		}

		System.out.println("Print option successfully");
	}

	@AfterClass
	public void closebrowser() {
		driver.close();
	}

}
