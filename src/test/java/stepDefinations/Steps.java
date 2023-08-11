package stepDefinations;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Steps extends BaseClass
{


   @Before
    public void setup() throws IOException {
        //Reading config.properties
         configProp=new Properties();
         FileInputStream configPropfile=new FileInputStream("config.properties");
         configProp.load(configPropfile);



        logger=Logger.getLogger("NOP Commerce Project");// added logger
        PropertyConfigurator.configure("Log4j.properties");// added logger

       String br=configProp.getProperty("Browser");

       if(br.equals("chrome"))
       {

           driver = new ChromeDriver();
       }

      else if (br.equals("firefox"))
      {
           // System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
           System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
          driver=new FirefoxDriver();
       }
        logger.info("********Launching the chrome browser*********");

    }



    @Given("User Launch Firefox Browser")
    public void user_launch_firefox_browser()
      {
         // logger=Logger.getLogger("NOP Commerce Project");// added logger
          //PropertyConfigurator.configure("Log4j.properties");// added logger
           //driver=new ChromeDriver();
          //System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
          //driver=new FirefoxDriver();
          //logger.info("********Launching the firefox browser*********");
          lp=new LoginPage(driver);
      }


    @When("User open URL {string}")
    public  void user_Open_URL(String url)
    {
        logger.info("********Opening url http://admin-demo.nopcommerce.com/login *********");
        driver.get(url);

    }

     @And("User enters Email as {string} and Password as {string}")
    public void user_email_and_password(String email, String password)
     {
         logger.info("********Providing Login Details*********");
         logger.info("********Providing userName*********");
         lp.setUserName(email);
         logger.info("********Providing Password*********");
         lp.setPassword(password);

     }

     @And("Click on Login")
       public void logIn()
     {
         logger.info("********Clicking the login button*********");
         lp.clickLogin();

     }

     @Then("Page Title should be {string}")
        public void page_Title(String pageTitle) throws InterruptedException {
            if(driver.getPageSource().contains("Login was unsuccessful."))
            {
                driver.close();
                logger.info("********Login Failed*********");
                Assert.assertTrue(false);
            }
            else
            {
                logger.info("********Login Passed*********");
                Assert.assertEquals(pageTitle,driver.getTitle());
            }

     }

     @When("User click on Log out link")
       public void logout_Link() throws InterruptedException {
              Thread.sleep(5000);
             lp.clickLogout();
         logger.info("********LoggedOut of the Account*********");

     }

     @And("Close browser")
      public void close()
     {
            driver.quit();
         logger.info("********Close Browser*********");
     }


     /*---------------------Customers Feature Step Defination---------------------------------*/


    @Then("User can view Dasboard")
    public void user_can_view_dasboard()
    {
       //(Dashboard / nopCommerce administration)
       ac=new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",ac.getPageTitle());

    }


    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        ac.setLink_customer_menu();
    }



    @And("Click on Customers menu item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(2000);
        ac.setLink_customer_menu_item();
    }


    @And("Click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
               ac.addNew();
             Thread.sleep(3000);
    }



    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page()
    {
        //(Add a new customer / nopCommerce administration)

        Assert.assertEquals("Add a new customer / nopCommerce administration",ac.getPageTitle());

    }

    // registered default
    // registered customer cannot be guest
    //customer cannot be both registered and guest
    //Add the customer to guest or registered


    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {

        logger.info("********Adding New Customer*********");
        logger.info("********Providing  Customer Details*********");
        String email=randomString()+"@gmail.com";
        ac.setEmail(email);
        ac.setPassword("qwerty123");
        ac.setFirstname("Ashok");
        ac.setLastname("Gadgil");
        ac.setGender("Male");

        ac.setDOB("12/09/1982");
        Thread.sleep(3000);

        ac.setCompanyName("Celerio");
        ac.TaxExcempt();

        /*ac.SetNewsLetter("Test store 2");
       // ac.SetNewsLetter();
        Thread.sleep(3000);*/

        ac.setCustomer_Role("Forum Moderators");
        Thread.sleep(3000);

        ac.setVendor("Vendor 2");
        Thread.sleep(3000);

        ac.SetadminComment("testing 123");



    }



    @And("Click on Save button")
    public void click_on_save_button() throws InterruptedException {
        ac.saveButton();
        logger.info("********Saving Customer Details*********");
        Thread.sleep(3000);

    }



    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg)
    {

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));



    }

    /*------------------- Search Customer by e-mail Id --------------*/

    @And("Enter customer e-mail")
    public void enter_customer_e_mail() throws InterruptedException {

        scp=new SearchCustomerPage(driver);
        scp.setEmail("victoria_victoria@nopCommerce.com");
        logger.info("********Search Customer by e-Mail*********");
        Thread.sleep(3000);

    }
    @When("click on search button")
    public void click_on_search_button() throws InterruptedException {
           scp.clickSearch();
           Thread.sleep(3000);
    }
    @Then("user should find E-mail in search table")
    public void user_should_find_e_mail_in_search_table()
    {
          boolean status=   scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");

          Assert.assertEquals(true,status);

        System.out.println("test case 2 passed : status " +status);
    }

/*-------------------Search by First and Last Name--------------------*/


    @And("Enter customer FirstName")
    public void enter_customer_first_name() {
        scp=new SearchCustomerPage(driver);
        scp.setFirstName("Victoria");
        logger.info("********Searching customer by First Name*********");
    }
    @And("Enter customer LastName")
    public void enter_customer_last_name()
    {
         scp.setLastName("Terces");
        logger.info("********Searching customer by Last Name*********");
    }


    @Then("user should find Name in search table")
    public void user_should_find_name_in_search_table()
    {
            boolean status1=  scp.searchCustomerByName("Victoria Terces");

        Assert.assertEquals(true,status1);

        System.out.println("test case 3 passed : status " +status1);
    }

}
