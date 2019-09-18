package Group;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Utils extends BasePage {
    //(1) it will click on elements
    public void clickOnElements(By by)
    {
        driver.findElement(by).click();
    }
    //(2) Clear Text form inout box/area
    public void clearInputText(By by)
    {
        driver.findElement(by).clear();
    }
    //(3) to enter text of element
    public void enterText (By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //(4) Clear and enter text in input field
    public void clearAndInputText(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    //(5) to get the text for expected and actual result
    public String getText(By by)
    {
        return driver.findElement(by).getText();
    }
    //(6) Checking WebElement present/exist in DOM
    public boolean webElementPresent(By by)
    {
        return driver.findElements(by).size()!=0;
    }
    //(7) Checking WebElemnt displayed or not
    public boolean webElementDisplayedInDOM(By by)
    {
        return driver.findElement(by).isDisplayed();
    }
    //(8) implicit wait
    public void implicitWaitTime(long time)
    {
        driver.manage().timeouts().implicitlyWait(time, SECONDS);
    }
    //(9)Explicit wait
    public void explicitWaitTime(long time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
    }
    //(10) fluent wait
    public void fluentWait(long time, int frequency)
    {
        Wait wait = new FluentWait(driver)
                .withTimeout(time, TimeUnit.SECONDS)
                .pollingEvery(frequency, TimeUnit.SECONDS)
                .ignoring(Exception.class);
    }
    //(11) Try to click element multiple times if not available in first go
    public void tryClickingMultipleTime(By by, int times)
    {
        driver.findElements(by).get(times).click();
    }
    //(12) is dropdown present
    public void dropDownPresent(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.getOptions();
    }
    //(13) Wait for locator to be clickable for given time in seconds
    public static void waitForClickable(By by,long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //(14) Wait for element to be clickable for given time in seconds
    public static void waitForElementVisible(By by,long time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    //Wait for element for given time in second
    //(15) wait till certain alert message/window appears which no locator
    public static void waitForAlertPresent(By by,long time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //(16) wait for element to be invisible
    public static void waitForAlertInvisible(By by,long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    // (17) select from visible text DROPDOWN
    public void selectByVisibleText(By by, String text)
    {
        Select select = new Select (driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //(18) Select by Index number DROPDOWN
    public void selectByVisibleNumber(By by, int number)
    {
        Select select = new Select (driver.findElement(by));
        select.selectByIndex(number);
    }
    //(19) Select from the value DROPDOWN
    public void selectByValue(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    //(20) Select from first selected option
    public void selectByFirstSelectedOption(By by, String value)
    {
        Select select = new Select(driver.findElement(by));
        select.getFirstSelectedOption();
    }
    //(21) Assert method to compare results
    public void assertMethod(By actual, String expected)
    {
        Assert.assertEquals(getText(actual),expected);
    }

    //(22) Scroll to view element
    public void scrollWebPageToViewElement(By by)
    {
        Actions actions = new Actions(driver);
        driver.findElement(by);
        actions.moveToElement((WebElement) driver);
        actions.perform();
    }
    //(23) Scroll to element and click
    public void scrollWebPageToViewElementAndClick(By by)
    {
        //Actions actions = new Actions(driver);
        //driver.findElement(by).actions.moveToElement().actions.perform().Click();
        Actions actions = new Actions(driver);
        driver.findElement(by);
        actions.moveToElement((WebElement) driver);
        actions.click();
    }
    //(24) Wait for alert to display
    public void waitForAlert(int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().getText();
    }
    //(25) Get attribute of element//get attribute
    public String getAttribute(By by, String text)
    {
        return driver.findElement(by).getAttribute(text);
    }
    //(26) get css property of element //get css value
    public void getCssValue(By by, String text)
    {
        driver.findElement(by).getCssValue(text);
    }
    //(27) it will generate random numbers for email
    public static String randomDate()
    {
        DateFormat format=new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }
    //(28) take screenshot of browser
    public static void takeScreenShot(WebDriver webdriver, String fileWithPath) throws IOException
    {
        //convert web driver object to take screen shot
        TakesScreenshot scrShot = ((TakesScreenshot)webdriver);

        //call get screen shot as method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //move image file to new destination
        File DestFile = new File(fileWithPath);

        //copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
    //(29) date stamp short
    public String shortDateStamp()
    {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat();
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }
    //(30) date stamp long
    public String longDateStamp()
    {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat();
        return new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
    }
    //(31) convert date....
    public SimpleDateFormat covertDate()
    {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHMM");
        return new SimpleDateFormat("dd-MMM-yyyy HH:MM");
    }
    //(32) This method determines if an element is enabled or not
    public boolean ifWebElementIsEnabledOrNot(By by)
    {
        return driver.findElement(by).isEnabled();
    }
    //(33) get location false or true
    public boolean getLocation(By by)
    {
        Point location = driver.findElement(by).getLocation();
        return false;
    }
    //(34) get the text from locator
    public String getTextFromLocator(By by)
    {
        return driver.findElement(by).getText();
    }
    //(36) get the url
    public void getUrl(String url)
    {
        LoadProps loadProps = new LoadProps();
        driver.get(loadProps.getProperty(url));
    }

    }

