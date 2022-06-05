import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManagerLoginPage extends BasePage{
    private By bankManagerLoginButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");

    public BankManagerLoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getBankManagerLoginButton() {
        return bankManagerLoginButton;
    }

    public void clickBankManagerLoginButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(bankManagerLoginButton));
        getDriver().findElement(bankManagerLoginButton).click();
        driverWait.until(ExpectedConditions.urlContains("manager"));
    }


}
