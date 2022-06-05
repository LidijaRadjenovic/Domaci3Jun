import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositPage extends BasePage{

    private By depositButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By amountToBeDeposited = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By depositButtonTwo = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By depositSuccessfulMessage = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");


    public DepositPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickDepositButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(depositButton));
        getDriver().findElement(depositButton).click();
    }

    public void enterAmountToBeDeposited(String amount){
        driverWait.until(ExpectedConditions.elementToBeClickable(amountToBeDeposited));
        getDriver().findElement(amountToBeDeposited).sendKeys(amount);
    }

    public void clickDepositButtonTwo(){
        getDriver().findElement(depositButtonTwo).click();
    }

    public String depositSuccessfulMessage(){
       return getDriver().findElement(depositSuccessfulMessage).getText();
    }
}
