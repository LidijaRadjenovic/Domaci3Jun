import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;

public class WithdrawlPage extends BasePage{

    private By withdrawlButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By amountToBeWithdrawd = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By withdrawlButtonTwo = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By withdrawlSuccessfulMessage = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");
    private By logoutCustomerButton = By.xpath("/html/body/div/div/div[1]/button[2]");

    private By homeButton = By.xpath("/html/body/div/div/div[1]/button[1]");
    public WithdrawlPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickWithdrawlButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(withdrawlButton));
        getDriver().findElement(withdrawlButton).click();
    }

    public void enterAmountToBeWithdrawd(String amount2){
        driverWait.until(ExpectedConditions.elementToBeClickable(amountToBeWithdrawd));
        getDriver().findElement(amountToBeWithdrawd).sendKeys(amount2);
    }

    public void clickWithdrawlButtonTwo(){
        driverWait.until(ExpectedConditions.elementToBeClickable(withdrawlButtonTwo));
        getDriver().findElement(withdrawlButtonTwo).click();
    }
    public String withdrawlSuccessfulMessage(){
        return getDriver().findElement(withdrawlSuccessfulMessage).getText();
    }

    public void clickLogoutCustomerButton(){
        getDriver().findElement(logoutCustomerButton).click();
    }

    public void clickHomeButton(){
        getDriver().findElement(homeButton).click();
    }


}
