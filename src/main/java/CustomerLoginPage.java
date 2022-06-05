import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLoginPage extends BasePage{
    private By homeButton = By.xpath("/html/body/div/div/div[1]/button[1]");

    private By customerLoginButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");

    private By yourName = By.xpath("//*[@id=\"userSelect\"]");

    private By loginButton = By.xpath("/html/body/div/div/div[2]/div/form/button");

    public CustomerLoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void clickHomeButton(){
        getDriver().findElement(homeButton).click();
    }
    public void clickCustomerLoginButton(){
        getDriver().findElement(customerLoginButton).click();
    }

    public void loginCustomer(){
        driverWait.until(ExpectedConditions.elementToBeClickable(yourName));
        Select selectYourName = new Select(driver.findElement(yourName));
        selectYourName.selectByVisibleText("Dee Alan");
        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        getDriver().findElement(loginButton).click();
        driverWait.until(ExpectedConditions.urlContains("account"));

    }

//    public void createAccount(){
//        Select selectCustomerName = new Select(driver.findElement(customerName));
//        selectCustomerName.selectByVisibleText("Dee Alan");
//        Select currency = new Select(driver.findElement(this.currency));
//        currency.selectByVisibleText("Pound");
//        getDriver().findElement(processButton).click();
//    }
}
