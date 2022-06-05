import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankingProjectTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private BankManagerLoginPage bankManagerLoginPage;
    private AddCustomerPage addCustomerPage;
    private OpenAccountPage openAccountPage;
    private CustomerLoginPage customerLoginPage;
    private DepositPage depositPage;
    private WithdrawlPage withdrawlPage;

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(40));

        bankManagerLoginPage = new BankManagerLoginPage(driver, driverWait);
        addCustomerPage = new AddCustomerPage(driver, driverWait);
        openAccountPage = new OpenAccountPage(driver, driverWait);
        customerLoginPage = new CustomerLoginPage(driver, driverWait);
        depositPage = new DepositPage(driver, driverWait);
        withdrawlPage = new WithdrawlPage(driver, driverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }
    @Test(priority = 1)
    public void bankManagerloginTest() {
        bankManagerLoginPage.clickBankManagerLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }

    @Test(priority = 2)
    public void creatingCustomerTest(){
        addCustomerPage.clickAddCustomerButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust");
        addCustomerPage.enterFirstName("Dee");
        addCustomerPage.enterLastName("Alan");
        addCustomerPage.enterPostCode("E859AB");
        addCustomerPage.clickAddCustomerButtonTwo();
        Assert.assertTrue(addCustomerPage.isAlertMessageDisplayed());
        addCustomerPage.alertMessage();
        Assert.assertTrue(openAccountPage.isOpenAccountButtonEnabled());
    }

    @Test(priority = 3)
    public void creatingCustomerAccountTest(){
        openAccountPage.clickOpenAccountButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/openAccount");
        openAccountPage.createAccount();
        Assert.assertTrue(openAccountPage.isAlertMessageDisplayed());
        openAccountPage.alertMessage();
        Assert.assertTrue(openAccountPage.isCustomersButtonEnabled());
    }

    @Test(priority = 4)
    public void customerLoginTest() {
        customerLoginPage.clickHomeButton();
        customerLoginPage.clickCustomerLoginButton();
        customerLoginPage.loginCustomer();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
    }

    @Test(priority = 5)
    public void customerDepositTest() {
        depositPage.clickDepositButton();
        depositPage.enterAmountToBeDeposited("1000");
        depositPage.clickDepositButtonTwo();
        Assert.assertEquals(depositPage.depositSuccessfulMessage(), "Deposit Successful");
    }

    @Test(priority = 6)
    public void customerWithdrawlTest() throws InterruptedException {
        withdrawlPage.clickWithdrawlButton();
        Thread.sleep(1000);
        withdrawlPage.enterAmountToBeWithdrawd("500");
        Thread.sleep(1000);
        withdrawlPage.clickWithdrawlButtonTwo();
        Thread.sleep(1000);
        Assert.assertEquals(withdrawlPage.withdrawlSuccessfulMessage(), "Transaction successful");
    }
    @Test(priority = 7)
    public void logoutCustomerTest(){
        withdrawlPage.clickLogoutCustomerButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }
    @Test(priority = 8)
    public void logoutBankManager(){
        withdrawlPage.clickHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

}
