package week2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		String url = "https://en-gb.facebook.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.findElement(By.linkText("Create New Account")).click();
		
		WebElement ele_dateOfBirth = driver.findElement(By.name("birthday_day"));
		Select ss_dateOfBirth = new Select(ele_dateOfBirth);
		ss_dateOfBirth.selectByIndex(0);
		driver.findElement(By.xpath("//input[@name='sex']/preceding-sibling::label[1]")).click();
		
		//To know the count of dropdown options 
		List<WebElement> list_options = ss_dateOfBirth.getOptions();
	
		for(WebElement each_options:list_options)
		{
			System.out.println(each_options.getAttribute("value"));
		}
		
		System.out.println("Size of the dropdown:" +list_options.size());
	}
	

}
