package week2.assignments;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.id("dropdown1"));;
		Select sel = new Select(ele);
		sel.selectByIndex(1);
		Select sele = new Select(driver.findElement(By.name("dropdown2")));
		sele.selectByVisibleText("Selenium");
		Select s = new Select(driver.findElement(By.name("dropdown3")));
		s.selectByValue("1");
		
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("praveen.vp93@gmail.com");
		driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']//input[@value='Append ']")).sendKeys("TIme to Spend");
		String str = driver.findElement(By.xpath("//input[@name='username'][1]")).getAttribute("value");
		System.out.println(str);
		driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']//input[@value='Clear me!!']")).clear();
		Boolean boo = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input")).isEnabled();
		System.out.println(boo);
	}
}
