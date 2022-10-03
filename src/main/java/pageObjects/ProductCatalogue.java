package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductCatalogue extends AbstractComponent {

     public ProductCatalogue(WebDriver driver){
            super(driver);
            PageFactory.initElements(driver,this);
     }

    @FindBy(css = ".mb-3")
    List<WebElement> productsElement;
    @FindBy(css = ".ng-animating")
    WebElement ngAnimating;
    @FindBy(css = "#toast-container")
    WebElement toastContainer;
    By productBy=By.cssSelector(".mb-3");
    By cardButtonBY=By.cssSelector(".card-body button:last-of-type");
    By cardTitleBY=By.cssSelector("b");
    By toastContainerBY=By.cssSelector("#toast-container");
    By ngAnimatingBY=By.cssSelector(".ng-animating");
    By ngAnimatingBYSpin=By.cssSelector(".ngx-spinner-overlay");


    public  void addToChart(String [] productNameList){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToAppear(productBy,10);
        Arrays.stream(productNameList).forEach(productName -> {
            WebElement searchedProduct = productsElement.stream().filter(product ->
                    product.findElement(cardTitleBY).getText().equals(productName)
            ).findFirst().orElse(null);
            searchedProduct.findElement(cardButtonBY).click();
            waitForElementToAppear(toastContainerBY,5);
            waitForElementToDisappear(toastContainerBY,5);
        });

    }
    public  void getProductList(){
        waitForElementToAppear(productBy,10);

        productsElement.stream().forEach(product ->{
            System.out.println(product.findElement(cardTitleBY).getText());
            System.out.println(product.getAttribute("outerHTML"));
                }

        );
    }

}
