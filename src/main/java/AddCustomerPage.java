import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage{
    private By addCustomerButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomerButtonTwo = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    //private By okButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    public AddCustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickAddCustomerButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(addCustomerButton));
        getDriver().findElement(addCustomerButton).click();
        driverWait.until(ExpectedConditions.urlContains("addCust"));
    }

    public void enterFirstName(String firstName){
        driverWait.until(ExpectedConditions.elementToBeClickable(this.firstName));
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driverWait.until(ExpectedConditions.elementToBeClickable(this.lastName));
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public boolean isAlertMessageDisplayed(){
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void enterPostCode(String postCode){
        driverWait.until(ExpectedConditions.elementToBeClickable(this.postCode));
        getDriver().findElement(this.postCode).sendKeys(postCode);
    }

    public void clickAddCustomerButtonTwo(){
        driverWait.until(ExpectedConditions.elementToBeClickable(addCustomerButtonTwo));
        getDriver().findElement(addCustomerButtonTwo).click();
    }

    public void alertMessage(){
        Alert al = driver.switchTo().alert();
        al.accept();
    }

}
