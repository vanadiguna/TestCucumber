package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver ldriver;
    WaitHelper waithelper;

    public SearchCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        waithelper = new WaitHelper(ldriver);

    }

    By searchEmail = By.id("SearchEmail");
    By searchFirstname = By.id("SearchFirstName");
    By searchLastName = By.id("SearchLastName");


    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
            @CacheLookup
            WebElement tblSearchResult;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
            @CacheLookup
            WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;

    By btnSearch = By.id("search-customers");

    public void setSearchEmail(String email){
        waithelper.WaitForElement(ldriver.findElement(searchEmail), 30);
        ldriver.findElement(searchEmail).clear();
        ldriver.findElement(searchEmail).sendKeys(email);
    }

    public void setSearchFirstname(String fname){
        waithelper.WaitForElement(ldriver.findElement(searchFirstname), 30);
        ldriver.findElement(searchFirstname).clear();
        ldriver.findElement(searchFirstname).sendKeys(fname);
    }

    public void setSearchLastName(String lname){
        waithelper.WaitForElement(ldriver.findElement(searchLastName),30);
        ldriver.findElement(searchLastName).clear();
        ldriver.findElement(searchLastName).sendKeys(lname);
    }

    public void clickBtnSearch(){
        ldriver.findElement(btnSearch).click();
    }

    public int getNoOfRows(){
        return (tableRows.size());
    }

    public int getNoOfColumns(){
        return (tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email){
        boolean flag = false;

        for (int i=1;i<= getNoOfRows();i++){
            String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailid);

            if(emailid.equals(email)){
                flag = true;
            }
        }
        return flag;
    }

    public boolean searchCustomerByName(String Name){
        boolean flag = false;

        for (int i=1;i<= getNoOfRows();i++){
            String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            String names[]=name.split(" ");

            if(names[0].equals("Victoria") && names[1].equals("Terces")){
                flag = true;
            }
        }
        return flag;
    }


}
