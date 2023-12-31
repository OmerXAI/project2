import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import util.BaseDriver;
import util.MyFunc;

public class createUserAccount extends BaseDriver {
    @Test (priority = 1)
    public void Register(){

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        WebElement register=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        register.click();
        MyFunc.Bekle(2);
        WebElement genderm= driver.findElement(By.id("gender-male"));
                genderm.click();
                WebElement firstName= driver.findElement(By.id("FirstName"));
                firstName.sendKeys("Ali");
                WebElement lastName= driver.findElement(By.id("LastName"));
                lastName.sendKeys("Veli");
                WebElement email= driver.findElement(By.id("Email"));
                email.sendKeys("ali06@gmail.com");
                WebElement pasw= driver.findElement(By.name("Password"));
                pasw.sendKeys("ali06@gmail.com");
                WebElement paswd= driver.findElement(By.name("ConfirmPassword"));
                paswd.sendKeys("ali06@gmail.com");
                WebElement regButton=driver.findElement(By.id("register-button"));
               // regButton.click(); register edildi

    }
    @Test (priority = 2)
    public void negativeCreateUserAccount (){
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        MyFunc.Bekle(1);
        WebElement register=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        register.click();
        MyFunc.Bekle(1);
        WebElement genderm= driver.findElement(By.id("gender-male"));
        genderm.click();
        WebElement firstName= driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Ali");
        WebElement lastName= driver.findElement(By.id("LastName"));
        lastName.sendKeys("Veli");
        WebElement email= driver.findElement(By.id("Email"));
        email.clear();
        email.sendKeys("ali06@gmail.com");
        WebElement pasw= driver.findElement(By.name("Password"));
        pasw.sendKeys("Benim.45");
        WebElement paswd= driver.findElement(By.name("ConfirmPassword"));
        paswd.sendKeys("Benim.45");
        WebElement regButton=driver.findElement(By.id("register-button"));
        regButton.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li"),"The specified email already exists"));
        WebElement text= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li"));
        Assert.assertTrue("mail ayni olamaz",text.getText().equals("The specified email already exists"));

    }
}
