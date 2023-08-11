package stepDefinations;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.Properties;


public class BaseClass
{

    public WebDriver driver  ;
    public LoginPage lp ;

    public AddCustomerPage ac ;

    public SearchCustomerPage scp ;

    public static Logger logger ;

    public Properties configProp ;


    // Creating Random String for unique e-mail Id
    public static String randomString()
    {
        String genaratedString1= RandomStringUtils.randomAlphabetic(5);
        return (genaratedString1);
    }









}
