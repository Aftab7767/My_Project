package com.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils
{
/**
 * This method is used to maximize the Window
 * @author Aftab
 * @param driver
 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method is used to minimize the window
 * @author Aftab
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * This method is used to do fullScreen of window
 * @author Aftab
 * @param driver
 */
public void fullScreenWindow(WebDriver driver)
{
	driver.manage().window().fullscreen();
}
/**
 * This method is used to wait until page is loaded
 * @param driver
 * @param sec
 */
public void waitforpageLoad(WebDriver driver,int sec)
{
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	
}
/**
 * This method is used for implicit wait
 * @param driver
 * @param sec
 */
public void implicitWait(WebDriver driver,int sec)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
}
/**
 * This method is use to wait until AlertPopup
 * @param driver
 * @param sec
 */
public void waitforAlertisPresent(WebDriver driver,int sec)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	//WebDriverWait wait = callwebdriverobject(driver, sec);
	wait.until(ExpectedConditions.alertIsPresent());
}
/**
 * This method is used to wait until Element to be clickable
 * @param driver
 * @param sec
 * @param element
 */
public void waituntilelementToBeClickable(WebDriver driver,int sec,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method is used to wait until Element to be selected
 * @author Aftab
 * @param driver
 * @param sec
 * @param element
 */
public void waituntilelementToBeSelected(WebDriver driver,int sec,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
/**
 * This method is used to wait until title is displayed 
 * @author Aftab
 * @param driver
 * @param sec
 * @param title
 */
public void waituntiltitleContains(WebDriver driver,int sec,String title)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	wait.until(ExpectedConditions.titleContains(title));	
}
/**
 * This method is used to wait until url is displayed 
 * @author Aftab
 * @param driver
 * @param sec
 * @param url
 */
public void waituntilurlContains(WebDriver driver,int sec,String url)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	wait.until(ExpectedConditions.urlContains(url));
}
/**
 *This method is used to wait until frame to be available and switch to it
 * @param driver
 * @param sec
 * @param element
 */
public void waituntilframeToBeAvailableAndSwitchToIt(WebDriver driver,int sec,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
}
/**
 * This method will select data drom dropdown using index
 * @author Aftab
 * @param element
 * @param index
 */
public void select(WebElement element,int index)
{
	Select s = new Select(element);
	s.selectByIndex(index);
}
/**
 * This method will select data drom dropdown using value
 * @author Aftab
 * @param element
 * @param value
 */
public void select(WebElement element,String value)
{
	Select s = new Select(element);
	s.selectByValue(value);
}
/**
 * This method will select data drom dropdown using visible text
 * @author Aftab
 * @param text
 * @param element
 */
public void select(String text,WebElement element)
{
	Select s = new Select(element);
	s.selectByVisibleText(text);
}
/**
 * 	This method will return all data of dropdown
 * @author Aftab
 * @param element
 * @return List<WebElement>
 */
public 	List<WebElement> getalldataofDropdown(WebElement element)
{
	Select s = new Select(element);
	List<WebElement> all = s.getOptions();
	return all;
}
/**
 * This method will perform mouse hover action
 * @author Aftab
 * @param driver
 * @param element
 */
public void mousehover(WebDriver driver,WebElement element)
{
	Actions a = new Actions(driver);
	a.moveToElement(element).perform();
}
/**
 * This method will use to do double click on webpage
 * @author Aftab
 * @param driver
 */
public void doubleclick(WebDriver driver)
{
	Actions a = new Actions(driver);
	a.doubleClick().perform();
}
/**
 * This method will do drag and drop action
 * @author Aftab
 * @param driver
 * @param src
 * @param dest
 */
public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
{
	Actions a = new Actions(driver);
	a.dragAndDrop(src, dest).perform();
}
/**
 * This method will use to do double click on element
 * @author Aftab
 * @param driver
 * @param element
 */
public void doubleClick(WebDriver driver,WebElement element)
{
	Actions a = new Actions(driver);
	a.doubleClick(element).perform();
}
/**
 * This method is use to Scroll to the element
 * @author Aftab
 * @param driver
 * @param element
 */
public void scrollToElement(WebDriver driver,WebElement element)
{
	Actions a = new Actions(driver);
	a.scrollToElement(element).perform();
}
/**
 * This method will use to do right click on element
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions a = new Actions(driver);
	a.contextClick(element).perform();
}
/**
 * This method will use to right click on webpage
 * @author Aftab
 * @param driver
 */
public void rightClick(WebDriver driver)
{
	Actions a = new Actions(driver);
	a.contextClick().perform();
}
/**
 * This method is used to press the enter key
 * @author Aftab
 * @param driver
 */
public void pressEnterkey(WebDriver driver)
{
	Actions a = new Actions(driver);
	a.sendKeys(Keys.ENTER).perform();
}
/**
 * This method is to press the Enter key
 * @author Aftab
 * @throws AWTException
 */
public void enterKeyPress() throws AWTException
{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
}
/**
 * This method is to release the Enter key
 * @author Aftab
 * @throws AWTException
 */
public void enterRelease() throws AWTException
{
	Robot r = new Robot();
	r.keyRelease(KeyEvent.VK_ENTER);
}
/**
 * This method will switch the frame based on index
 * @author Aftab
 * @param driver
 * @param index
 */

public void swithToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will switch the frame based on name or ID
 * @author Aftab
 * @param driver
 * @param nameOrId
 */

public void swithToFrame(WebDriver driver,String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}
/**
 * This method will switch the frame based on address of the element
 * @author Aftab
 * @param driver
 * @param frameAddress
 */

public void switchToFrame(WebDriver driver,WebElement frameAddress)
{
	driver.switchTo().frame(frameAddress);
}
/**
 * This method will accept alert popup
 * @param driver
 */

public void accepAlertPopup(WebDriver driver)
{
	Alert a = driver.switchTo().alert();
	a.accept();
}
/**
 * This method will cancel alert popup
 * @param driver
 */

public void dismissAlertPopup(WebDriver driver)
{
	Alert a = driver.switchTo().alert();
	a.dismiss();
}
/**
 * This method will switch between windows
 * @author Aftab
 * @param driver
 * @param partialWinTitle
 */

public void switchToWindow(WebDriver driver,String partialWinTitle)
{
	//Step1: get all window handles
	Set<String> wh = driver.getWindowHandles();
	//Step2: fetch all window handles one by one
	Iterator<String> it = wh.iterator();
	//Step3: check whether there is next window
	while(it.hasNext())
	{
		//getting current window id
		String winId = it.next();
		//step5: switch to current window and capture title
		String currentWinTitle=driver.switchTo().window(winId).getTitle();
		//step6: check whether the current window is expected
		if(currentWinTitle.contains(partialWinTitle))
		{
			break;
		}
	}	
}
/*
public WebDriverWait callwebdriverobject(WebDriver driver,int sec)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
	return wait;
}*/
/**
 * This method is used to take screenshot and store it in folder called ScreenShotName
 * @author Aftab
 * @param driver
 * @param screenShotName
 * @throws IOException
 */
public static String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
{
	JavaUtils jlib = new JavaUtils();
	TakesScreenshot t = (TakesScreenshot) driver;
	File src = t.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(IpathConstant.SCREENSHOTPATH+screenShotName+jlib.getSystemDateInFormat()+".png"));
	String path = IpathConstant.SCREENSHOTPATH+screenShotName+jlib.getSystemDateInFormat()+".png";
	return path;
}
public void scrollAction(WebDriver driver,String script)
{
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	((JavascriptExecutor) driver).executeScript( script);
}

public void scrollAction(WebDriver driver,String script,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript(script, element);
}

/**
 * THis method will scroll untill the specified element is found
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver, WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
	//js.executeScript("argument[0].scrollIntoView()",element);
			
}
}
