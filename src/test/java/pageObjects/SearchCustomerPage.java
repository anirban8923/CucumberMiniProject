package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.time.Duration;
import java.util.List;

public class SearchCustomerPage
{
    public WebDriver ldriver ;
    WaitHelper waithelper ;

    public SearchCustomerPage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
        waithelper=new WaitHelper(ldriver);
    }


    @FindBy(how= How.ID , using ="SearchEmail")
    @CacheLookup
    WebElement email;

    @FindBy(xpath="//*[@id=\"SearchFirstName\"]")
    @CacheLookup
    WebElement firstName;


    @FindBy(xpath ="//*[@id=\"SearchLastName\"]")
    @CacheLookup
    WebElement lastName;

    @FindBy(how=How.ID , using ="search-customers")
    @CacheLookup
    WebElement btnSearch;




    @FindBy(how= How.XPATH , using ="//table[@id=\"customers-grid\"]")
    @CacheLookup
    WebElement table;


    @FindBy(how= How.XPATH , using ="//table[@id=\"customers-grid\"]//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(how= How.XPATH , using ="//table[@id=\"customers-grid\"]//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;







    public void setEmail(String email1) throws InterruptedException {

        waithelper.WaitForElement(email, Duration.ofSeconds(30));
        email.clear();
        System.out.println("--------------------"+email1);
         email.sendKeys(email1);
         Thread.sleep(5000);
    }

    public void setFirstName(String fname)
    {
        waithelper.WaitForElement(firstName, Duration.ofSeconds(30));
        firstName.clear();
        firstName.sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        waithelper.WaitForElement(lastName, Duration.ofSeconds(30));
        lastName.clear();
        lastName.sendKeys(lname);
    }

public void clickSearch()
{
    btnSearch.click();
    waithelper.WaitForElement(btnSearch, Duration.ofSeconds(30));

}

public int getNoOfRows()
{
    return (tableRows.size());
}

    public int getNoOfColumns()
    {
        return (tableColumns.size());
    }



   //[//table[@id="customers-grid"]//tbody/tr[1]/td[2]]
    public boolean searchCustomerByEmail(String eMail)
    {
        boolean flag=false;

        for(int i=1;i<=getNoOfRows();i++)
        {
            String emailid=table.findElement(By.xpath("//table[@id=\"customers-grid\"]//tbody/tr["+i+"]/td[2]")).getText();

            if(emailid.equals(eMail))
            {
                System.out.println(emailid);
                flag=true;
            }

        }

              return  flag ;
    }

       public boolean searchCustomerByName(String name)
       {

           boolean flag=false;

           for(int i=1;i<=getNoOfRows();i++)
           {
               String name1=table.findElement(By.xpath("//table[@id=\"customers-grid\"]//tbody/tr["+i+"]/td[3]")).getText();

               String [] names=name1.split(" ");// separate first and last name

               if(names[0].equals("Victoria")&& names[1].equals("Terces"))
               {
                   flag=true;
                   System.out.println("First name " +names[0]);
                   System.out.println("Second name " +names[1]);
               }


           }

                 return flag;

       }


}
