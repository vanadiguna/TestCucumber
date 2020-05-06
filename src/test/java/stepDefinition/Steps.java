package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class Steps extends BaseClass{
public ChromeOptions options;

    @Given("User open chrome browser")
    public void user_open_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        lp = new LoginPage(driver);
    }

    @When("User open url {string}")
    public void user_open_url(String url) {
        driver.get(url);
    }

    @When("User enter email as {string} and Password as {string}")
    public void user_enter_email_as_and_Password_as(String email, String password) {
        lp.setUsername(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_Login() throws InterruptedException {
        lp.clickBtnLogin();
        Thread.sleep(2000
        );
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) throws InterruptedException {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }else {
            Assert.assertEquals(title, driver.getTitle());
        }
        Thread.sleep(2000
        );

    }

    @Then("close browser")
    public void close_browser() {
        driver.close();

    }

    @When("User click on log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.clickBtnLogout();
        Thread.sleep(2000
        );

    }

    //Add Customer Step

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() {
        addCust = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
    }

    @When("User click on customers menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomer();
    }

    @When("click on customers")
    public void click_on_customers() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomerData();

    }

    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnNewCustomer();

    }

    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = randomestring()+ "@gmail.com";
        addCust.setTextEmail(email);
        addCust.setTextPassword("test123");
        addCust.setTextFirstName("test");
        addCust.setTextLastName("last");
        addCust.setTextCustomerRole("Guest");
        Thread.sleep(3000);
        addCust.setTextDoB("01/08/1996"); // MM/DD/YYYY
        addCust.setTextCompany("Testing QA");
        addCust.setTextAdminComment("using selenium java bdd");
        addCust.setSelectVendor("Vendor 1");
        addCust.setGender("Male");

    }

    @When("click on Save button")
    public void click_on_Save_button() {
        addCust.clickOnSave();

    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]")).getText()
                .contains("The new customer has been added successfully."));

    }

    // Search Customer Step

    @When("enter customer email")
    public void enter_customer_email() {
        searchCust = new SearchCustomerPage(driver);
        searchCust.setSearchEmail("victoria_victoria@nopCommerce.com");
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.clickBtnSearch();
        Thread.sleep(3000);
    }

    @Then("User should found email in the search table")
    public void user_should_found_email_in_the_search_table() {
        boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");

        Assert.assertEquals(true, status);
    }

    // Search Using Name Step

    @When("enter first name")
    public void enter_first_name() {
        searchCust = new SearchCustomerPage(driver);
        searchCust.setSearchFirstname("Victoria");
    }

    @When("enter last name")
    public void enter_last_name() {
        searchCust.setSearchLastName("Terces");
    }

    @Then("User should found name in the search table")
    public void user_should_found_name_in_the_search_table() {
        boolean status = searchCust.searchCustomerByName("Victoria Terces");
        Assert.assertEquals(true, status);
    }

}
