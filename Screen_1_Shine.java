package ResumeUpdate;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screen_1_Shine {
WebDriver driver;
WebElement wb ;
String update;

public void operation(String UserName,String Password) throws InterruptedException{

 String lastUpdate;

    //Opeaning chrom browser ....
    try{
    	String path=new File("").getAbsolutePath();
    	System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("http://www.shine.com/myshine/login/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(Exception e){
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().refresh();
        driver.get("http://www.shine.com/myshine/login/");
        driver.manage().window().maximize();
    }//catch
    
    
    //Going to username section
    try{
    	wb = driver.findElement(By.id("id_email"));
    	wb.click();
    	wb.sendKeys(UserName);
    }catch(NoSuchElementException e){
    	wb = driver.findElement(By.xpath(".//*[@id='id_email']"));
    	wb.click();
    	wb.sendKeys(UserName);
    }//catch
    
    
    //Going to password section
    try{
    	wb = driver.findElement(By.id("id_password"));
    	wb.click();
    	wb.sendKeys(Password);
    }catch(NoSuchElementException e){
    	wb = driver.findElement(By.xpath(".//*[@id='id_password']"));
    	wb.click();
    	wb.sendKeys(Password);
    }//catch
    
    
    //Clicking on login button
    try{
    	driver.findElement(By.id("btn_login")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(NoSuchElementException e){
    	driver.findElement(By.xpath(".//*[@id='btn_login']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }//catch
    
    
    //If userid/password is incorrect
    try{
    	wb = driver.findElement(By.xpath(".//*[@class='cls_loginnotmatch error_text']"));
    	String error = wb.getText();
    	System.out.println(error);
    	OutputDisplay.dialogue(error);
    }catch(NoSuchElementException e){   	
    }//catch
    catch(NullPointerException e){
    }//catch
    
    
    //Capturing the last update
    try{
    	wb = driver.findElement(By.xpath("//*[@class='txresumeprofile_mid']/span/i"));
    	lastUpdate=wb.getText();
    	System.out.println(lastUpdate);
    }catch(NoSuchElementException e){
    	try{
    	wb = driver.findElement(By.xpath("//span/i"));
    	lastUpdate=wb.getText();
    	System.out.println(lastUpdate);
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    catch(NullPointerException e){
    }//catch
    
    
    //1st edit button
    try{
    	driver.findElement(By.xpath("//*[@class='txresumeprofile_mid']/span/a/em")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(NoSuchElementException e){
    	try{
    	driver.findElement(By.xpath("//div[@class='txresumeprofile_mid']/span/a/em")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    
    //Goto save button ....
    try{
    	driver.findElement(By.xpath("//li[12]/a[1][@name='pro_editpd']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(NoSuchElementException e){
    	try{
    	driver.findElement(By.xpath("//*[@id='id_pd_edit_form']/ul/li[12]/a[1]")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    
    
    //going to 2nd edit
    try{
    	driver.navigate().refresh();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(".//*[@id='wrkexp']/div[4]/div/div/ul/li[1]/a[1]")).click(); 
    }catch(NoSuchElementException e){
    	try{
    	driver.navigate().refresh();
    	Thread.sleep(4000);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(".//*[@id='wrkexp']/div[4]/div/div/ul/li[1]/a[1]")).click(); 
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    
    
    //going to save .....
    try{
    	driver.findElement(By.xpath("//a[@class='submitred cls_editregistration_save']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(NoSuchElementException e){
    	try{
    	driver.findElement(By.xpath(".//*[@id='id_job_edit_profile_form_NTMzZTQ2YjAzNTBkOWQ4MWYzNTJhMGNl']/ul/li[12]/a[1]")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    
    
    //Going to welcome page
    try{
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//*[@class='cls_can_Account profile_left_current']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(NoSuchElementException e){
    	try{
    	driver.findElement(By.xpath(".//*[@class='cls_can_Account profile_left_current']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    catch(WebDriverException e){
    	try{
    	driver.navigate().refresh();
    	Thread.sleep(4000);
    	driver.findElement(By.xpath("//*[@class='cls_can_Account profile_left_current']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    
  //Capturing the final update
    try{
    	wb = driver.findElement(By.xpath("//*[@class='txresumeprofile_mid']/span/i"));
    	update=wb.getText();
    	System.out.println(update);
    }catch(NoSuchElementException e){
    	try{
    	wb = driver.findElement(By.xpath("//span/i"));
    	update=wb.getText();
    	System.out.println(update);
    }catch(Exception ee){
    	driver.close();
    }//catch
    }//catch
    catch(NullPointerException e){
    }//catch
    
    finally{
    	driver.close();
    	//driver.quit();
    }//finally
    
}//operation1 

/* public static void main(String[] args) throws InterruptedException{
	(new Screen_1_Shine()).operation();
}//main */

}//Screen_1_Shine
