import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class OpenAccountPage extends BasePage{

    private By openAccountButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By customerName = By.xpath("//*[@id=\"userSelect\"]");
    private By currency = By.xpath("//*[@id=\"currency\"]");
    private By processButton = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    private By customersButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");

    public OpenAccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOpenAccountButton(){
        getDriver().findElement(openAccountButton).click();
        driverWait.until(ExpectedConditions.urlContains("openAccount"));
    }

    public boolean isCustomersButtonEnabled(){
        return  getDriver().findElement(customersButton).isEnabled();
    }

    public boolean isOpenAccountButtonEnabled(){
        return  getDriver().findElement(openAccountButton).isEnabled();
    }

    public void createAccount(){
        Select selectCustomerName = new Select(driver.findElement(customerName));
        selectCustomerName.selectByVisibleText("Dee Alan");
        Select currency = new Select(driver.findElement(this.currency));
        currency.selectByVisibleText("Pound");
        getDriver().findElement(processButton).click();
    }

    public void alertMessage(){
        Alert al = driver.switchTo().alert();
        al.accept();
    }

    public boolean isAlertMessageDisplayed(){
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

}
