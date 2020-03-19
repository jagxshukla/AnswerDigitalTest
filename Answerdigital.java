package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Answerdigital {
	
	
	
	@Test
	public void login() {
		//Test case 1 Scenario 1
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagxs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(21) > a")).click();
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("#login > button > i")).click();
		System.out.println(driver.findElement(By.id("flash")).getText());
		String errorMessage1="Your password is invalid!";
		Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains(errorMessage1));
		
		//Test case 1 Scenario 2
		driver.findElement(By.id("username")).sendKeys("abcxyz");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("#login > button > i")).click();
		System.out.println(driver.findElement(By.id("flash")).getText());
		String errorMessage2="Your username is invalid!";
		Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains(errorMessage2));
		
		
		//Test case 1 Scenario 3
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("#login > button > i")).click();
		driver.findElement(By.cssSelector("#content > div > a > i")).click();
		
			}
	@Test
	public void infinitescroll() throws InterruptedException {
		//Test case 2
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagxs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(26) > a")).click();
		Actions a=new Actions(driver);
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		String actualText=driver.findElement(By.cssSelector("#content > div > h3")).getText();
		System.out.println(actualText);
		String expectedText="Infinite Scroll";
		Assert.assertEquals(actualText, expectedText);

	}
	@Test
	public void keyEventTest() throws InterruptedException {
		//Test case 3
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagxs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(31) > a")).click();
		
		WebElement textBox = driver.findElement(By.id("target"));
		textBox.sendKeys(Keys.TAB);
		WebElement target=driver.findElement(By.id("result"));
		System.out.println(target.getText());
		String tabResult="You entered: TAB";
		Assert.assertEquals(target.getText(), tabResult);
		
		textBox.sendKeys(Keys.CONTROL);
		System.out.println(target.getText());
		String controlResult="You entered: CONTROL";
		Assert.assertEquals(target.getText(), controlResult);
		
		textBox.sendKeys(Keys.ESCAPE);
		System.out.println(target.getText());
		String escapeResult="You entered: ESCAPE";
		Assert.assertEquals(target.getText(), escapeResult);
		
		textBox.sendKeys(Keys.ALT);
		System.out.println(target.getText());
		String altResult="You entered: ALT";
		Assert.assertEquals(target.getText(), altResult);
		System.out.println("Test Passed");
		
			
	}


}
	

