package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponent {

    public  LandingPage(WebDriver driver){
        super(driver);


    }

    @FindBy(css = "#userEmail")
    WebElement userEmailElement;
    @FindBy(css = "#userPassword")
    WebElement userPasswordElement;
    @FindBy(css = "input#login")
    WebElement submitButtonElement;

    public ProductCatalogue login(String userEmail, String password){
        this.userEmailElement.sendKeys(userEmail);
        this.userPasswordElement.sendKeys(password);
        submitButtonElement.click();
        return new ProductCatalogue(driver);
    }
    public  void goTo(String url){
        driver.get(url);

    }


}
