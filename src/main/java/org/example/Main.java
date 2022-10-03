package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        LandingPage landingPage=new LandingPage(driver);

        String url="https://rahulshettyacademy.com/client";
        String email="test12@test.com";
        String password="Test1234";
        String[] productNameList = {"ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 13 PRO"};


        landingPage.goTo(url);
        landingPage.login(email,password);

        ProductCatalogue productCatalogue=new ProductCatalogue(driver);
        productCatalogue.getProductList();
        productCatalogue.addProductsToChart(productNameList);
    }
}