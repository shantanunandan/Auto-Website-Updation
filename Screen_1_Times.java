package ResumeUpdate;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen_1_Times {
	WebDriver driver;
	WebElement wb ;
	String update;

	public void operation(String UserName,String Password) throws InterruptedException{

	 String lastUpdate;
       String path = new File("").getAbsolutePath();
	    //Opeaning chrom browser ....
	    try{
	    	System.out.println(path);
	        System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
	        //driver = new FirefoxDriver();
	        driver = new ChromeDriver();
	        driver.get("http://www.timesjobs.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(Exception e){
	        try{
	    	driver.navigate().refresh();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.navigate().refresh();
	        driver.get("http://www.timesjobs.com/");
	        driver.manage().window().maximize();
	        }catch(Exception ee){
	        	driver.close();
	        }//catch
	    }//catch
	    
	    
	    //Click on sign in
	    try{
	       driver.findElement(By.xpath("//a[contains(@href,'javascript:showLoginBox')]")).click();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(NoSuchElementException e){
	       try{
	    	driver.findElement(By.xpath("//li[1][@class='bdr-left']/a")).click();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       }catch(Exception ee){
	    	   driver.close();
	       }//catch
	    }//catch
	    
	    
	    //Switching to frames
	    try{
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      wb=driver.findElement(By.id("GB_frame1"));
	      driver.switchTo().frame(wb);
	      Thread.sleep(2000);
	      WebElement wb1=driver.findElement(By.id("GB_frame"));
	      driver.switchTo().frame(wb1);
	      Thread.sleep(2000);
	    }catch(NoSuchFrameException n){
	      try{
	      Thread.sleep(4000);
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      wb=driver.findElement(By.id("GB_frame1"));
		  driver.switchTo().frame(wb);
		  Thread.sleep(2000);
		  WebElement wb1=driver.findElement(By.id("GB_frame"));
		  driver.switchTo().frame(wb1);
		  Thread.sleep(2000);
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	    
	    
	    //Going to username section
	    try{
	    	wb = driver.findElement(By.id("j_username"));
	    	wb.click();
	    	wb.sendKeys(UserName);
	    }catch(NoSuchElementException e){
	    	try{
	    	wb = driver.findElement(By.xpath(".//*[@id='j_username']"));
	    	wb.click();
	    	wb.sendKeys(UserName);
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	    
	    
	    //Going to password section
	    try{
	    	wb = driver.findElement(By.id("j_password"));
	    	wb.click();
	    	wb.sendKeys(Password);
	    }catch(NoSuchElementException e){
	    	try{
	    	wb = driver.findElement(By.xpath(".//*[@id='j_password']"));
	    	wb.click();
	    	wb.sendKeys(Password);
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	    
	    
	    //Clicking on login button
	    try{
	    	driver.findElement(By.xpath("//input[@value='SIGN IN']")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(NoSuchElementException e){
	    	try{
	    	driver.findElement(By.xpath(".//input[@type='button']")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	    
	    
	    //If userid/password is incorrect
	    try{
	    	wb = driver.findElement(By.xpath(".//*[@id='loginError']"));
	    	String error = wb.getAttribute("class");
	    	if(error.length() != 0){
	    	System.out.println("The email/login id or password you entered is incorrect.");
	    	OutputDisplay.dialogue("The email/login id or password you entered is incorrect.");
	    	}//if
	    }catch(NoSuchElementException e){   	
	    }//catch
	    catch(NullPointerException e){
	    }//catch
	    
	    
	    
	    //Going to edit button 
	    try{
	    	driver.findElement(By.xpath("//li[@class='editProfileTop']/a")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(NoSuchElementException e){
	    	try{
	    	Thread.sleep(4000);
	    	driver.findElement(By.xpath("//*[@class='editProfileTop']/a"));
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	   
	    
	    //Capturing the last update
	    try{
	    	wb = driver.findElement(By.xpath("//div[@class='fnt11 fl mrgn_t10']"));
	    	lastUpdate=wb.getText();
	    	System.out.println(lastUpdate);
	    }catch(NoSuchElementException e){
	    	try{
	    	driver.navigate().refresh();
	    	Thread.sleep(4000);
	    	wb = driver.findElement(By.xpath("//*[@class='fnt11 fl mrgn_t10']"));
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
	    	driver.findElement(By.xpath("//a[contains(@href,'EditProfileRecruiter.html?_q')]")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(NoSuchElementException e){
	    	try{
	    	Thread.sleep(4000);
	    	driver.findElement(By.xpath("//div[@class='pe_edt_new']/a[contains(@href,'EditProfileRecruiter.html?_q')]")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	    
	    
	  //Goto save button ....
	    try{
	    	driver.findElement(By.xpath("//input[@name='Submit']")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(NoSuchElementException e){
	    	try{
	    	Thread.sleep(4000);
	    	driver.findElement(By.xpath("//input[@type='Submit']")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	    
	    
	    
	    //Going to preview and update button
	    try{
	    	Thread.sleep(4000);
	    	driver.findElement(By.xpath(".//*[@id='previewUrl']/img")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(NoSuchElementException e){
	    	try{
	    	Thread.sleep(4000);
	    	driver.findElement(By.xpath(".//*[@src='http://static.timesjobs.com/images_cand/tj_images/reg_wid/preview_edit_btn.gif']")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(Exception ee){
	    	driver.close();
	    }//catch
	    }//catch
	      
	    /*
	  //going to 2nd edit
	    try{
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//div[2][@class='peuser_info_detail mrgn_b25']/div[1]/div[1]/a")).click(); 
	    }catch(NoSuchElementException e){
	    	driver.navigate().refresh();
	    	Thread.sleep(4000);
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("html/body/div[5]/div[1]/div[4]/div[1]/div[1]/a")).click(); 
	    }//catch
	    
	    
	  
	    //going to save .....
	    try{
	    	Thread.sleep(4000);
	    	WebDriverWait wait = new WebDriverWait(driver,20);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='submit_button']")));
	    	driver.findElement(By.xpath("//*[@id='submit_button']")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }catch(NoSuchElementException e){
	    	System.out.println("2");
	    	Thread.sleep(4000);
	    	driver.findElement(By.xpath(".//*[@id='submit_button']")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }//catch
	    
	    
	   */ 
	    //Getting the final update
	    try{
	    	wb = driver.findElement(By.xpath("//div[@class='fnt11 fl mrgn_t10']"));
	    	update=wb.getText();
	    	System.out.println(update);
	    }catch(NoSuchElementException e){
	    	try{
	    	driver.navigate().refresh();
	    	Thread.sleep(4000);
	    	wb = driver.findElement(By.xpath("//*[@class='fnt11 fl mrgn_t10']"));
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
	}//operation
	
	
	
/*	public static void main(String[] args) throws InterruptedException{
		(new Screen_1_Times()).operation();
	} */
}//Screen_1_Times
