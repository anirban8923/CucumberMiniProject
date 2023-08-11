
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test
{

    public static void main(String[] args) throws InterruptedException {

       // ChromeOptions co=new ChromeOptions();

       // co.addArguments("--remote-allow-origins=*");
        //co.setBrowserVersion("115");
        //co.setBrowserVersion("stable");


          WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");




    }

}

