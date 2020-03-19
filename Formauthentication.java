package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Formauthentication {

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
		String actualError1=driver.findElement(By.id("flash")).getText();
		System.out.println(actualError1);
		String expectedError1="Your password is invalid!";
		Assert.assertTrue(actualError1.contains(expectedError1));
		
		//Test case 1 Scenario 2
		driver.findElement(By.id("username")).sendKeys("abcxyz");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("#login > button > i")).click();
		String actualError2=driver.findElement(By.id("flash")).getText();
		System.out.println(actualError2);
		String expectedError2="Your username is invalid!";
		Assert.assertTrue(actualError2.contains(expectedError2));
		
		
		//Test case 1 Scenario 3
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("#login > button > i")).click();
		driver.findElement(By.cssSelector("#content > div > a > i")).click();
		System.out.println("All Tests Passed");
	}
}
	

