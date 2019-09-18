package Group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static Group.BasePage.driver;

public class Registration extends Utils {
    LoadProps loadProps =new LoadProps();
    @BeforeMethod
    public void openbrowser() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");
        //open the Browser
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        //maximise the browser window screen
        //driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        //set implicit wait fro driver object
        implicitWaitTime(10);
        //open the website // "url" is called from testdataConfig.properties
        getUrl("url");

    }
    @AfterMethod                //will execute at the end of every method
    public void closeBrowser()
    {
        //driver.quit();      //will quit the open browser
    }
    @Test
    public void registerAccount(){
        //click on register button
        clickOnElements(By.xpath("//a[@class='ico-register']"));
        //enter firstname, loadprops will obtain name from it.
        enterText(By.id("FirstName"), loadProps.getProperty("FirstName"));
        //enter lastname
        enterText(By.xpath("//input[@name='LastName']"), loadProps.getProperty("LastName"));
        //enter date of birth
        //date
        selectByVisibleText(By.xpath("//select[@name = 'DateOfBirthDay']"),(loadProps.getProperty("Date")));
        //month
        selectByVisibleText(By.xpath("//select[@name = 'DateOfBirthMonth']"),(loadProps.getProperty("Month")));
        //year
        selectByVisibleText(By.xpath("//select[@name = 'DateOfBirthYear']"),(loadProps.getProperty("Year")));
        //enter email
        enterText(By.name("Email"),"test"+randomDate()+"@test.com");
        //enter the password
        enterText(By.id("Password"),loadProps.getProperty("Password"));
        //confirm password
        enterText(By.id("ConfirmPassword"), loadProps.getProperty("ConfirmPassword"));
        //click on register to register the account
        clickOnElements(By.name("register-button"));
        //assert method to check
        assertMethod((By.xpath("//div[@class='result']")), "Your registration completed");
    }
    @Test
    public void emailAFriend()
    {
        //click on register button
        clickOnElements(By.xpath("//a[@class='ico-register']"));
        //enter firstname
        enterText(By.id("FirstName"),"Venus");
        //enter lastname
        enterText(By.xpath("//input[@name='LastName']"),"Patel");
        //enter email
        enterText(By.name("Email"), "test"+randomDate()+"@test.com");
        //enter the password
        enterText(By.id("Password"),"test123");
        //confirm password
        enterText(By.id("ConfirmPassword"),"test123");
        //click on register to register the account
        clickOnElements(By.name("register-button"));
        //click on continue and it will lead to the homepage
        clickOnElements(By.xpath("//input[@name='register-continue']"));
        clickOnElements(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-grid']//div[2]//div[1]//div[1]//a[1]//img[1]"));
        //click on email a friend
        clickOnElements(By.xpath("//input[@value='Email a friend']"));
        //fill friend's email address
        enterText(By.id("FriendEmail"),"testtest123456@test.com");
        //fill personal message
        enterText(By.name("PersonalMessage"),"This very good deal mate, don't need to miss it. go ahead and buy it");
        //click on send email
        clickOnElements(By.name("send-email"));
        //message end of the process will be compare to actual result
        assertMethod((By.xpath("//h1")), "Email a friend");
    }
    @Test
    public void selectCameraAndPhoto()
    {
        //click on register button
        clickOnElements(By.xpath("//a[@class='ico-register']"));
        //enter firstname, loadprops will obtain name from it.
        enterText(By.id("FirstName"), loadProps.getProperty("FirstName"));
        //enter lastname
        enterText(By.xpath("//input[@name='LastName']"), loadProps.getProperty("LastName"));
        //enter date of birth
        //date
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthDay']"),(20));
        //month
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthMonth']"),(6));
        //year
        selectByVisibleText(By.xpath("//select[@name = 'DateOfBirthYear']"),("2000"));
        //enter email
        enterText(By.name("Email"),"test"+randomDate()+"@test.com");
        //enter the password
        enterText(By.id("Password"),loadProps.getProperty("Password"));
        //confirm password
        enterText(By.id("ConfirmPassword"), loadProps.getProperty("Password"));
        //click on register to register the account
        clickOnElements(By.name("register-button"));
        //click on continue and it will lead to the homepage
        clickOnElements(By.xpath("//input[@name='register-continue']"));
        //select on Electrics
        clickOnElements(By.xpath("//h2[@class='title']//a[contains(text(),'Electronics')]"));
        //click on Camera & photo
        clickOnElements(By.xpath("//img[@alt='Picture for category Camera & photo']"));
        //message end of the process will compare the result with expected result
        assertMethod(By.xpath("//h1[contains(text(),'Camera & photo')]"), "Camera & photo") ;
    }
    @Test
    public void userShouldBeFilterJewellery()
    {
        //click on register button
        clickOnElements(By.xpath("//a[@class='ico-register']"));
        //enter firstname, loadprops will obtain name from it.
        enterText(By.id("FirstName"), loadProps.getProperty("FirstName"));
        //enter lastname
        enterText(By.xpath("//input[@name='LastName']"), loadProps.getProperty("LastName"));
        //enter date of birth
        //date
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthDay']"),(20));
        //month
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthMonth']"),(6));
        //year
        selectByVisibleText(By.xpath("//select[@name = 'DateOfBirthYear']"),("2000"));
        //enter email
        enterText(By.name("Email"),"test"+randomDate()+"@test.com");
        //enter the password
        enterText(By.id("Password"),loadProps.getProperty("Password"));
        //confirm password
        enterText(By.id("ConfirmPassword"), loadProps.getProperty("Password"));
        //click on register to register the account
        clickOnElements(By.name("register-button"));
        //click on continue and it will lead to the homepage
        clickOnElements(By.xpath("//input[@name='register-continue']"));
        //select jewllery option
        clickOnElements(By.linkText("Jewelry"));
        //click on Filter by price $700-$3000
        clickOnElements(By.xpath("//a[contains(@href, '700-3000')]"));

        //here $ sign and space will be removed and string price will be converted to int
        String ProductPrice=getText(By.xpath("//span[@class='price actual-price']"));
        String price1=String.valueOf(ProductPrice.replace("$",""));
        String price2=String.valueOf(price1.replace(",",""));
        double price=Double.valueOf(price2);
        Assert.assertTrue(price>=700 && price<=3000);

        //comparing actual and expected result
        assertMethod((By.xpath("//span[@class='item']")),"$700.00 - $3,000.00");
    }
    @Test
    public void AddBooksToShoppingBasket()
    {
        //click on register button
        clickOnElements(By.xpath("//a[@class='ico-register']"));
        //enter firstname, loadprops will obtain name from it.
        enterText(By.id("FirstName"), loadProps.getProperty("FirstName"));
        //enter lastname
        enterText(By.xpath("//input[@name='LastName']"), loadProps.getProperty("LastName"));
        //enter date of birth
        //date
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthDay']"),(10));
        //month
        selectByVisibleNumber(By.xpath("//select[@name = 'DateOfBirthMonth']"),(1));
        //year
        selectByVisibleText(By.xpath("//select[@name = 'DateOfBirthYear']"),("1984"));
        //enter email
        enterText(By.name("Email"),"test"+randomDate()+"@test.com");
        //enter the password
        enterText(By.id("Password"),loadProps.getProperty("Password"));
        //confirm password
        enterText(By.id("ConfirmPassword"), loadProps.getProperty("Password"));
        //click on register to register the account
        clickOnElements(By.name("register-button"));
        //click on continue and it will lead to the homepage
        clickOnElements(By.xpath("//input[@name='register-continue']"));
        //click(select) Books category
        clickOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']"));
        //add first book to cart
        clickOnElements(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]"));
        //click on Shopping cart
        clickOnElements(By.xpath("//span[@class='cart-label']"));
        //click on continue shopping
        clickOnElements(By.xpath("//input[@class = 'button-2 continue-shopping-button']"));
        //add second book to cart
        clickOnElements(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]"));
        //click on Shopping cart
        clickOnElements(By.xpath("//span[@class='cart-label']"));

        //will check here if the added item is inside that particular page // will check individually if the items are added to cart
        WebElement firstItem = driver.findElement(By.xpath("//a[@class='product-name'] [contains(text(),'Fahrenheit 451 by Ray Bradbury')]"));
        Assert.assertTrue(firstItem.isDisplayed());

        WebElement secondItem = driver.findElement(By.xpath("//a[@class='product-name'] [contains(text(),'First Prize Pies')]"));
        Assert.assertTrue(secondItem.isDisplayed());
    }
    }