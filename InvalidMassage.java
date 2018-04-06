package ResumeUpdate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvalidMassage{
	WebDriver driver;
	WebElement wb;
	
	public WebElement wb1(String xpath){
		WebElement wb2 = driver.findElement(By.xpath(xpath));
		return wb2;	
	}
	
	public void connect() throws NoSuchElementException{
			 try{
				 driver = new FirefoxDriver();
			  //going to the desired website
			  driver.get("https://login.naukri.com/nLogin/Login.php?URL=http%3A%2F%2Fmy.naukri.com%2FMailers%2Fshowdnc%2F%3Furl%3Dhttp%3A%2F%2Fmy.naukri.com%2FHomePage%2Fview%3Fid%3D6e346be1ad03f4d67d75e5911b88ec3df281f50b07bbd08fb4c7f074e87577b79a86cc384cde9c370d99ad6a3af22255");
			  //maximize
			  driver.manage().window().maximize();
			  //wait
			  driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
			  wb = wb1(".//*[@id='logFormI']/div[3]/input");
			  wb.click();
			  wb.sendKeys("Your Account User ID");
			  
			  //Password
			  wb=driver.findElement(By.id("pwd1"));
			  wb.click();
			  wb.sendKeys("Your Account Password");
			  
			  //Login Button
			  driver.findElement(By.xpath(".//*[@id='logFormI']/div[7]/input")).click();
			  wb=driver.findElement(By.id("srvErr"));
			  String error=wb.getText();
			  String expected = "Invalid Details. Please check the EmailID-Password combination.";
			  if(expected.equals(error)){
				  System.out.println(error);
			  }
			 }catch(NoSuchElementException e){
				 System.out.println("First connect");
				 driver.close();
			 }
		}//connect

	public void connect1() throws NoSuchElementException{
		 try{
			 driver = new FirefoxDriver();
		  //going to the desired website
		  driver.get("https://login.naukri.com/nLogin/Login.php?URL=http%3A%2F%2Fmy.naukri.com%2FMailers%2Fshowdnc%2F%3Furl%3Dhttp%3A%2F%2Fmy.naukri.com%2FHomePage%2Fview%3Fid%3D6e346be1ad03f4d67d75e5911b88ec3df281f50b07bbd08fb4c7f074e87577b79a86cc384cde9c370d99ad6a3af22255");
		  //maximize
		  driver.manage().window().maximize();
		  //wait
		  driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);	
		  
		  driver.findElement(By.xpath("")).click();
		  wb=driver.findElement(By.id("srvErr"));
		  
	}catch(NoSuchElementException e){
		 System.out.println("Second connect");
		 driver.close();
	 }
   }

	public static void  main(String args[]){
		InvalidMassage i = new InvalidMassage();
		i.connect();
		i.connect1();
	}
}
