package ResumeUpdate;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.support.ui.Select;

public class Screen_1_Naukari {
 WebDriver driver;
 WebElement wb;

   public void operation(String UserName,String Password) throws InterruptedException,NoSuchElementException,SessionNotFoundException{
	 String lastUpdate, update;
	 try{  
	   try{
		   String path = new File("").getAbsolutePath();
	   //driver = new FirefoxDriver();
    	  System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
  		//WebDriver driver = new FirefoxDriver();
  		driver = new ChromeDriver();
    	 // driver = new HtmlUnitDriver();
	  //going to the desired website
	  driver.get("https://login.naukri.com/nLogin/Login.php?URL=http%3A%2F%2Fmy.naukri.com%2FMailers%2Fshowdnc%2F%3Furl%3Dhttp%3A%2F%2Fmy.naukri.com%2FHomePage%2Fview%3Fid%3D6e346be1ad03f4d67d75e5911b88ec3df281f50b07bbd08fb4c7f074e87577b79a86cc384cde9c370d99ad6a3af22255");
	  //maximize
	  driver.manage().window().maximize();
	  //wait
	  driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
      }catch(Exception e){
    	  //Get status of Welcome page
    	  driver.get("https://login.naukri.com/nLogin/Login.php?URL=http%3A%2F%2Fmy.naukri.com%2FMailers%2Fshowdnc%2F%3Furl%3Dhttp%3A%2F%2Fmy.naukri.com%2FHomePage%2Fview%3Fid%3D6e346be1ad03f4d67d75e5911b88ec3df281f50b07bbd08fb4c7f074e87577b79a86cc384cde9c370d99ad6a3af22255");
    	  //maximize
    	  driver.manage().window().maximize();
    	  //wait
    	  driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
      }//catch
      
      
      //User id
      try{ 
	  wb = driver.findElement(By.xpath(".//*[@id='logFormI']/div[3]/input"));
	  wb.click();
	  wb.sendKeys(UserName);
	  }catch(NoSuchElementException e){
		  wb = driver.findElement(By.xpath(".//*[@id='logFormI']/div[3]/input[@id='emailTxt']"));
		  wb.click();
		  wb.sendKeys(UserName);
	  }//catch
		 catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
      
      
      //Password
	  try{
	  wb=driver.findElement(By.id("pwd1"));
	  wb.click();
	  wb.sendKeys(Password);
	  }catch(NoSuchElementException e){
		  wb = driver.findElement(By.xpath(".//*[@id='pwd1']"));
		  wb.click();
		  wb.sendKeys(Password);
	  }//catch
		 catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  //Login Button
	  try{
	  driver.findElement(By.xpath(".//*[@id='logFormI']/div[7]/input")).click();
	  Thread.sleep(4000);
	  }catch(NoSuchElementException e){
		  wb = driver.findElement(By.xpath(".//*[@id='logFormI']/div[7]/input[@id='sbtLog']"));
		  wb.click();
	  }//catch
		 catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  //if Usename/Password is incorrect
	  try{
	  wb=driver.findElement(By.id("srvErr"));
	  String error=wb.getText();
	  String expected = "Invalid Details. Please check the EmailID-Password combination.";
	  if(expected.equals(error)){
		  System.out.println(error);
		  driver.close();
	  }//if
	  }catch(NoSuchElementException e){
	  }//catch
		 catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  //Displaying the profile name from welcome page
	  try{
		  wb = driver.findElement(By.id("nameDisplaySpan"));
		  String name = wb.getText();
		  System.out.println(name);
	  }catch(NoSuchElementException e){
		  wb = driver.findElement(By.xpath(".//*[@id='nameDisplayDiv']/span"));
		  String name = wb.getText();
		  System.out.println(name);
	  }//catch
		 catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  //Captuaring the Last Update
	  try{
		  wb = driver.findElement(By.xpath(".//*[@class='grytxt8 f11']"));
		  update = wb.getText();
		  System.out.println(update);
	  }catch(NoSuchElementException e){
		  wb = driver.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[2]"));
		  update = wb.getText();
		  System.out.println(update);
	  }//catch
		 catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 wb = driver.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[2]"));
			 update = wb.getText();
			 System.out.println(update);
		 }//catch
	  
	  //Clicking on update button
	  try{
		  driver.findElement(By.xpath(".//*[@class='w205']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }catch(NoSuchElementException e){
		  driver.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[1]/button")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }//catch
	  catch(SessionNotFoundException e){
		     Thread.sleep(4000);
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  // 1st edit button 
	  try{
		  driver.findElement(By.xpath(".//*[@class='f12 ml8']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }catch(NoSuchElementException e){
		  try{
		  driver.findElement(By.xpath(".//*[@class='bt_Bdr_org h1_20 f18']/a")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }catch(NoSuchElementException ee){
			  driver.findElement(By.xpath(".//*[@class='f12 ml8 txtnor']")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		  }//catch
	  }//catch
	  catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  // 1st edit button save path
	  try{
		  driver.findElement(By.xpath(".//*[@class='w150bt fl']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }catch(NoSuchElementException e){
		  driver.findElement(By.xpath(".//button[@class='w150bt fl']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }//catch
	  catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  // Confirmation massage
	  try{
		  driver.findElement(By.id("confirmMessage")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }catch(NoSuchElementException e){
		  driver.findElement(By.xpath(".//*[@class='pNotify']/span")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }//catch
	  catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  // Navigate to homepage
	  try{
		  driver.findElement(By.xpath(".//*[@id='colL']/h2/a")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }catch(NoSuchElementException e){
		  driver.findElement(By.xpath(".//*[@id='colL']/h2/a[contains(@href,'http://my.naukri.com/HomePage/view?id=64504ef9a8dd11141bd4be9032367642f281f50b07bbd08fb4c7f074e87577b79a86cc384cde9c370d99ad6a3af22255')]")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }//catch
	  catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	  
	  
	  
	//Captuaring the Last Update
	  try{
		  wb = driver.findElement(By.xpath(".//*[@class='grytxt8 f11']"));
		  lastUpdate = wb.getText();
		  System.out.println(lastUpdate);
	  }catch(NoSuchElementException e){
		  wb = driver.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[2]"));
		  lastUpdate = wb.getText();
		  System.out.println(lastUpdate);
	  }//catch
	  catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 wb = driver.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[2]"));
			 lastUpdate = wb.getText();
			 System.out.println(lastUpdate);
		 }//catch

	  
	  if(update.equalsIgnoreCase(lastUpdate)){
		  try{
			  wb = driver.findElement(By.xpath("//*[@rel='mnaukNav']"));
			  Actions mouse = new Actions(driver);
			  mouse.moveToElement(wb).perform();
			  Select select = new Select(wb);
			  select.selectByIndex(3);
		  }catch(NoSuchElementException e){
			  wb = driver.findElement(By.xpath(".//*[@id='mNav']/div/ul/li[4]/a"));
			  Actions mouse = new Actions(driver);
			  mouse.moveToElement(wb).perform();
			  Select select = new Select(wb);
			  select.selectByVisibleText("Education");
		  }//catch
		  catch(SessionNotFoundException e){
				 driver.navigate().refresh();
				 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 }//catch
		  
		  
		  //clicking on submit button
		  try{
			  driver.findElement(By.id("submitButton")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }catch(NoSuchElementException e){
			  driver.findElement(By.xpath(".//button[@value='Save Changes']")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }//catch
		  catch(SessionNotFoundException e){
				 driver.navigate().refresh();
				 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 }//catch
		  
		  
		  // Confirmation massage
		  try{
			  driver.findElement(By.id("confirmMessage")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }catch(NoSuchElementException e){
			  driver.findElement(By.xpath(".//*[@class='pNotify']/span")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }//catch
		  catch(SessionNotFoundException e){
				 driver.navigate().refresh();
				 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 }//catch
		  
		  
		  // Navigate to homepage
		  try{
			  driver.findElement(By.xpath(".//*[@id='colL']/h2/a")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }catch(NoSuchElementException e){
			  driver.findElement(By.xpath(".//*[@id='colL']/h2/a[contains(@href,'http://my.naukri.com/HomePage/view?id=64504ef9a8dd11141bd4be9032367642f281f50b07bbd08fb4c7f074e87577b79a86cc384cde9c370d99ad6a3af22255')]")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }//catch
		  catch(SessionNotFoundException e){
				 driver.navigate().refresh();
				 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 }//catch
		  
		  
		//Captuaring the Last Update
		  try{
			  wb = driver.findElement(By.xpath(".//*[@class='grytxt8 f11']"));
			  lastUpdate = wb.getText();
			  System.out.println(lastUpdate);
		  }catch(NoSuchElementException e){
			  wb = driver.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[2]"));
			  lastUpdate = wb.getText();
			  System.out.println(lastUpdate);
		  }//catch
		  catch(SessionNotFoundException e){
				 driver.navigate().refresh();
				 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 }//catch
		  
	  
	     // Logging out
	      try{
	    	  driver.findElement(By.xpath(".//a[contains(@href,'http://login.naukri.com/nLogin/Logout.php?id=63c116256cc370fcf82b6165af1ceac5f281f50b07bbd08fb4c7f074e87577b79a86cc384cde9c370d99ad6a3af22255')]")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      }catch(NoSuchElementException e){
	    	  driver.findElement(By.xpath("//div[@class='fl']/a[2]")).click();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      }//catch
		  catch(SessionNotFoundException e){
				 driver.navigate().refresh();
				 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
			 }//catch
	      
	  }//if
	 }
	  catch(SessionNotFoundException e){
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		 }//catch
	 catch(Exception e){
	 }//main catch
	 finally{
		 driver.close();
	 }//finally
	  
    }//operation
   
  /* public static void main(String args[]) throws  InterruptedException {
	   Screen_1_Naukari s = new Screen_1_Naukari();
	   s.operation();
	   
   }//main */
}//Scrren_1_Monster

