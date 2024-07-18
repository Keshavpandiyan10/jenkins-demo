package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class example {

	@Test
	public void myTest() {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		//		driver.findElementById("fruits")
		WebElement fruits = driver.findElement(By.cssSelector("#fruits"));
		Select myFruits = new Select(fruits);
		myFruits.selectByVisibleText("Apple");
		myFruits.selectByVisibleText("Banana");
		System.out.println(myFruits.isMultiple());
		List<WebElement> allFruits = myFruits.getOptions();
		allFruits.forEach(i -> System.out.println(i.getText()));

		WebElement country = driver.findElement(By.id("country"));
		Select myCountry = new Select(country);
		myCountry.selectByValue("India");
		WebElement selectedCountry = myCountry.getFirstSelectedOption();
		System.out.println(selectedCountry.getText());

		WebElement heros = driver.findElement(By.id("superheros"));
		Select myHeros = new Select(heros);
		boolean isMul = myHeros.isMultiple();
		System.out.println("Is Multiple? "+isMul);
		myHeros.selectByIndex(1);
		myHeros.selectByValue("bt");
		// TODO: loops
		List<WebElement> allHeros = myHeros.getAllSelectedOptions();
		for (WebElement webElement : allHeros) {
			System.out.println(webElement.getText());
		}

		myHeros.deselectByIndex(1);

		driver.quit();

	}

}
