package pageObjects;

import io.cucumber.java.et.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

public class AddCustomerPage {
    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By btnCustomer = By.xpath("//span[contains(.,'Customers')]");
    By btnCustomerData = By.xpath("//a[contains(@href, '/Admin/Customer/List')]");
    By btnAddCustomer = By.linkText("Add new");
    By textEmail = By.id("Email");
    By textPassword = By.id("Password");
    By textFirstName = By.id("FirstName");
    By textLastName = By.id("LastName");
    By rdMale = By.id("Gender_Male");
    By rdFemale = By.id("Gender_Female");
    By textDoB = By.id("DateOfBirth");
    By textCompany = By.id("Company");
    By checkTax = By.id("IsTaxExempt");
    By checkNews = By.xpath("//div[@id='customer-info']/div[2]/div/div[9]/div[2]");
    By textCustomerRole = By.xpath("//div[@id='customer-info']/div[2]/div/div[10]/div[2]/div/div/div");

    By listitemAdmnistrator = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
    By listitemForumModerator = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
    By listitemGuests = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
    By listitemRegistered = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
    By listitemVendors = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");

    By selectVendor = By.id("VendorId");
    By checkActive = By.id("Active");
    By textAdminComment = By.id("AdminComment");
    By btnSave = By.xpath("//button[@name='save']");

    // Action Method

    public void clickOnCustomer() {
        ldriver.findElement(btnCustomer).click();
    }

    public void clickOnCustomerData(){
        ldriver.findElement(btnCustomerData).click();
    }

    public void clickOnNewCustomer(){
        ldriver.findElement(btnAddCustomer).click();
    }

    public void clickOnSave(){
        ldriver.findElement(btnSave).click();
    }

    public void setTextEmail(String email){
        ldriver.findElement(textEmail).sendKeys(email);
    }

    public void setTextPassword(String password){
        ldriver.findElement(textPassword).sendKeys(password);
    }

    public void setTextFirstName(String firstName){
        ldriver.findElement(textFirstName).sendKeys(firstName);
    }

    public void setTextLastName(String lastName){
        ldriver.findElement(textLastName).sendKeys(lastName);
    }

    public void setTextCustomerRole(String role) throws InterruptedException {
        if(!role.equals("Vendors")){
            ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
        }
        ldriver.findElement(textCustomerRole).click();

        WebElement listitem;
        Thread.sleep(3000);

        if (role.equals("Administrator")){
            listitem = ldriver.findElement(listitemAdmnistrator);
        }else if(role.equals("Guests")){
            listitem = ldriver.findElement(listitemGuests);
        }else if(role.equals("Registered")){
            listitem = ldriver.findElement(listitemRegistered);
        }else if(role.equals("Vendors")){
            listitem = ldriver.findElement(listitemVendors);
        }
        else {
            listitem = ldriver.findElement(listitemGuests);
        }

        //listitem.click();

        JavascriptExecutor js = (JavascriptExecutor)ldriver;
        js.executeScript("arguments[0].click();", listitem);
    }

    public void setSelectVendor(String value){
        Select drp = new Select(ldriver.findElement(selectVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender){
        if(gender.equals("Male")){
            ldriver.findElement(rdMale).click();
        }else if(gender.equals("Female")){
            ldriver.findElement(rdFemale).click();
        }else {
            ldriver.findElement((rdMale)).click(); //Default
        }
    }

    public void setTextDoB(String dob){
        ldriver.findElement(textDoB).sendKeys(dob);
    }

    public void setTextCompany(String company){
        ldriver.findElement(textCompany).sendKeys(company);
    }

    public void setTextAdminComment(String adminComment){
        ldriver.findElement(textAdminComment).sendKeys(adminComment);
    }

    public String getPageTitle(){
        return ldriver.getTitle();
    }








}
