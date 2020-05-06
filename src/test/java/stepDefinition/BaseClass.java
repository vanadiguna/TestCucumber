package stepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCust;
    public SearchCustomerPage searchCust;


    //generate random email
    public static String randomestring(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }
}
