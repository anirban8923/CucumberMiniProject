package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage
{
    public WebDriver ldriver ;
    public AddCustomerPage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver,this);

    }

    By link_customer_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
    By link_customer_menu_item=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
    By addNew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
    By email=By.xpath("//*[@id=\"Email\"]");
    By password=By.xpath("//*[@id=\"Password\"]");
    By firstname=By.xpath("//*[@id=\"FirstName\"]");
    By lastname=By.xpath("//*[@id=\"LastName\"]");

    By genderM=By.xpath("//*[@id=\"Gender_Male\"]");
    By genderF=By.xpath("//*[@id=\"Gender_Female\"]");



    By dob=By.xpath("//*[@id=\"DateOfBirth\"]");
    By companyName=By.xpath("//*[@id=\"Company\"]");
    By taxexcempt=By.xpath("//*[@id=\"IsTaxExempt\"]");
  //  By newsletter =By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div");


    By role=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
    By customerRolesAdmin=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
    By customerRolesFmod=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
    By customerRolesGuest=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
    By customerRolesReg=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
    By customerRolesVendor=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");





    By vendor=By.xpath("//*[@id=\"VendorId\"]");
    By adminComment=By.xpath("//*[@id=\"AdminComment\"]");
    By savebtn=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");

   /*GetTitle Methods*/
    public String getPageTitle()
    {
        return ldriver.getTitle();
    }









    // Actions Methods




    public void setLink_customer_menu() {
       ldriver.findElement(link_customer_menu).click();
    }



    public void setLink_customer_menu_item() {
        ldriver.findElement(link_customer_menu_item).click();
    }



    public void  addNew() {
       ldriver.findElement(addNew).click();
    }



    public void setEmail(String emailId)
    {
        ldriver.findElement(email).sendKeys(emailId);
    }



    public void setPassword(String pass)
    {
        ldriver.findElement(password).sendKeys(pass);
    }




    public void setFirstname(String Fname)
    {
        ldriver.findElement(firstname).sendKeys(Fname);
    }



    public  void setLastname(String Lname)
      {
          ldriver.findElement(lastname).sendKeys(Lname);
      }




      public void setCustomer_Role(String roles) throws InterruptedException {

              /*if(!roles.equals("Vendors"))
              {
                  ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds\"]"));

              }
            ldriver.findElement(role).click();*/

          WebElement listitems ;

          Thread.sleep(3000);

          if(roles.equals("Administrators"))
          {
             listitems= ldriver.findElement(customerRolesAdmin);
          }

          else if(roles.equals("Forum Moderators"))
          {
              listitems=ldriver.findElement(customerRolesFmod);
          }

          else if(roles.equals("Guests"))
          {
              listitems=ldriver.findElement(customerRolesGuest);
          }

          else if(roles.equals("Registered"))
          {
              listitems=ldriver.findElement(customerRolesReg);
          }

          else
          {
              listitems=ldriver.findElement(customerRolesVendor);
          }

         // listitems.click();
          Thread.sleep(3000);

          JavascriptExecutor js=(JavascriptExecutor)ldriver ;
          js.executeScript("arguments[0].click()",listitems);

      }




       public  void setVendor(String Ven)
       {
           Select drp= new Select(ldriver.findElement(vendor));
           drp.selectByVisibleText(Ven);

       }




       public  void setGender(String gen)
       {

           if(gen.equals("Male"))
           {
               ldriver.findElement(genderM).click();
           }
           else {
               ldriver.findElement(genderF).click();
           }

       }



       public void setDOB(String dofb)
       {
           ldriver.findElement(dob).sendKeys(dofb);
       }




       public  void setCompanyName(String Na )
       {
           ldriver.findElement(companyName).sendKeys(Na);
       }



        public void TaxExcempt()
        {
            ldriver.findElement(taxexcempt).click();
        }



       /* public void SetNewsLetter(String cr)
        {
           // ldriver.findElement(newsletter);

            Select drp= new Select(ldriver.findElement(newsletter));
            drp.selectByValue("2");

        }*/


        public void SetadminComment(String Com )
    {
        ldriver.findElement(adminComment).sendKeys(Com);
    }




    public  void saveButton()
    {
        ldriver.findElement(savebtn).click();
    }



}
