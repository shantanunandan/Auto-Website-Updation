package ResumeUpdate;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen_1_Monster {
WebDriver driver;
WebElement wb;
String path;
String update;
String error;



 public void wait1(WebElement wb){
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(wb));
 }//Wait1

  public void wait2(){
	  driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
  }//wait2
  
 public void operation(String UserName,String Password) throws InterruptedException{
try{  
 path=new File("").getAbsolutePath();
 // driver = new FirefoxDriver();
  System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
  driver = new ChromeDriver();
 // driver = new HtmlUnitDriver();
  driver.get("https://my.monsterindia.com/login.html?src=http://my.monsterindia.com/my_monster.html&rand=5257");
  System.out.println(driver.getTitle());
  driver.manage().window().maximize();
  wait2();
  //driver.navigate().refresh();
  //Goto login id
  try{
	//  driver.navigate().refresh();
	  wait2();
	  wb=driver.findElement(By.id("username_login"));
	  wb.click();
      wb.sendKeys(UserName);
  }catch(NoSuchElementException e){
	     wb=driver.findElement(By.xpath(".//*[@id='username_login']"));
	     wb.click();
	     wb.sendKeys(UserName);
  }//catch
  
  //Password
  try{
	  wb=driver.findElement(By.id("password_input"));
	  wb.click();
	  wb.sendKeys(Password);  
  }catch(NoSuchElementException e){
		 wb=driver.findElement(By.id(".//*[@id='password_input']"));
		 wb.click();
		 wb.sendKeys(Password);
  }//catch
  
  
  //Clicking on Login button
  try{
	  wb = driver.findElement(By.name("submit"));
      wait1(wb);
	  wb.click();
	  wait2();
  }catch(NoSuchElementException e){
	  wb=driver.findElement(By.xpath("//input[@name='submit']"));
	  wait1(wb);
	  wb.click();
	  wait2();
  }//catch
  
  /// if Usename/Password is incorrect
  try{
	  wb=driver.findElement(By.className("txt_red")); 
	  error = wb.getText();
	  String expected="Please recheck, Username/E-mail id/Password is incorrect. Remember you can also login with your E-mail id. (Please check if the box is ticked in case e-mail id is selected)";
		 if(expected.length()==error.length()){
			System.out.println(error); 
			OutputDisplay.dialogue(error);
		 }//if
		 wait2();
  }catch(NoSuchElementException e){
  }//catch
  catch(StaleElementReferenceException ee){}//catch
  
  
  //Getting last update .... 
  try{
	  wait2();
	  wb=driver.findElement(By.xpath(".//div[@style='float:left; margin-top:4px;']"));
	  update = wb.getText();
	  System.out.println(update);
	  wait2();
  }catch(NoSuchElementException e){
	  driver.navigate().refresh();
	  wait2();
	  wb=driver.findElement(By.xpath(".//td[contains(@style,'border:#bfbfbf 1px solid; padding:1px 5px;')]/div[1]"));
	  System.out.println(wb.getText());
	  wait2();
  }//catch
  
  
  //Getting details of old window
  String oldwindow = driver.getWindowHandle();
  
  
  //clicking on update button
  try{
	  wb=driver.findElement(By.xpath(".//img[@src='http://media.monsterindia.com/monster_2012/btn_update2.gif']"));
	  wait1(wb);
	  wb.click();
	  wait2();
  }catch(NoSuchElementException e){
	  driver.navigate().refresh();
	  Thread.sleep(8000);
	  wb=driver.findElement(By.xpath(".//a[@href='http://my.monsterindia.com/view_resume.html?resid=51706134&mode=edit']/img"));
	  wait1(wb);
	  wait2();
	  wb.click();
	  wait2(); 
  }//catch
  catch(WebDriverException w){
	  driver.navigate().refresh();
	  wb=driver.findElement(By.xpath(".//img[@src='http://media.monsterindia.com/monster_2012/btn_update2.gif']"));
	  wait1(wb);
	  wb.click();
	  wait2();
  }//catch
  
  
  //Getting focus on update page
  try{
	  ArrayList<String> newwindow = new ArrayList<String>(driver.getWindowHandles());
	  newwindow.remove(oldwindow);
	    // change focus to new tab
	    driver.switchTo().window(newwindow.get(0));
	    driver.navigate().refresh();
	    Thread.sleep(4000);
  }catch(Exception e){
	  e.printStackTrace();
  }//catch
  
  wb = driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td[3]"));
  String up = wb.getText();
  System.out.println(up);
  
  //Going to 1st edit 
  try{
	  wb=driver.findElement((By.xpath(".//*[@id='edit_resume_section1_open']")));
	  wait1(wb);
	  wb.click();
	  Thread.sleep(6000);
	  System.out.println(driver.getTitle());
  }catch(NoSuchElementException e){
	  driver.navigate().refresh();
	  Thread.sleep(6000);
	  driver.navigate().refresh();
	  Thread.sleep(6000);
	  wb=driver.findElement((By.xpath(".//*[@title='Contact Information']")));
	  wait1(wb);
	  wb.click();
	  wait2();
  }//catch
  
  
  //Clicking on Update button
  try{
	wb=driver.findElement(By.id("update"));
	wait1(wb);
	wb.click();
	try{
	wb = driver.findElement(By.xpath("//*[@id='ErrorMsgOnEditPage']/table/tbody/tr/td/div[2]"));
	String error = wb.getText();
	System.out.println(error.length());
	}catch(NoSuchElementException ee){	
	}//catch
	catch(NullPointerException n){}//catch
  }catch(NoSuchElementException e){
	driver.navigate().refresh();
	try{
		Thread.sleep(2000);
		wb=driver.findElement(By.id("edit_resume_section2_open"));
		wait1(wb);
		wait2();
		wb.click();
		Thread.sleep(6000);
		wb=driver.findElement(By.id("update"));
		wait1(wb);
		wb.click();
	}catch(NoSuchElementException ee){
	}//catch
  }//catch
  
  //Getting the final update 
  try{
	  wb = driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td[3]"));
	  String update = wb.getText();
	  System.out.println(update);
  }catch(NoSuchElementException e){
	  wb = driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td[3]"));
	  String update = wb.getText();
	  if(up.equals(update)){}else{operation(UserName, Password);}
  }//catch
    
  driver.switchTo().window(oldwindow);
  
}catch(Exception e){
	driver.close();  
}//catch
finally{
	driver.close();
	driver.quit();
}//finally
 }//operation 
  
 
 public static void main(String[] args) throws InterruptedException{
	 Screen_1_Monster s = new Screen_1_Monster();
	 s.operation("shantanunandan8@gmail.com","Ferrari2738");
 } //main   */
}//Screen_1_Monster

