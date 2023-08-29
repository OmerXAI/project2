import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import util.BaseDriver;
import util.MyFunc;


public class downloadOrderHistory extends BaseDriver {

import java.util.List;
import java.util.Set;


    @Test
    public void orderhistorytest(){
        driver.get("https://demowebshop.tricentis.com/");
//login
        WebElement login= driver.findElement(By.xpath("//*[@href='/login']"));
        login.click();
        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("ali06@gmail.com");
        WebElement pass= driver.findElement(By.id("Password"));
        pass.sendKeys("Benim.45");

        WebElement loginButton=driver.findElement(By.cssSelector("input.login-button"));
        loginButton.click();
//profil sayfasi ve ardindan siparislere gecis
        WebElement profil=driver.findElement(By.xpath("//*[@href='/customer/info']"));
        profil.click();
        MyFunc.Bekle(1);
        WebElement orders=driver.findElement(By.xpath("//*[@href='/customer/orders']"));
        orders.click();
        MyFunc.Bekle(1);

        JavascriptExecutor js=(JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, 500)"  );
//siparis detayina giris ve fatura yukleme
        MyFunc.Bekle(1);
        WebElement firstOrderDetail=driver.findElement(By.cssSelector("input[value='Details']"));
        firstOrderDetail.click();

        MyFunc.Bekle(2);

        WebElement download=driver.findElement(By.linkText("PDF Invoice"));

        download.click();

        BekleVeKapat();

}}
