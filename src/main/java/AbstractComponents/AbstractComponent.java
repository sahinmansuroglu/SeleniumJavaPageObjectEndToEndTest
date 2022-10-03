package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
   protected WebDriver driver;
    public AbstractComponent(WebDriver driver){
        this.driver=driver;
    }

    protected void waitForElementToAppear(By byName,int second){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byName));
    }

    protected void waitForWebElementToAppear(WebElement webElement,int second){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void waitForElementToDisappear(By findBy, int second){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
    protected void waitForWebElementToDisappear(WebElement element, int second){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
