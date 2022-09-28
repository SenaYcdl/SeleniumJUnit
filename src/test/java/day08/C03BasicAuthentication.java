package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03BasicAuthentication {

    /*
    Bir class olusturun : BasicAuthentication
https://the-internet.herokuapp.com/basic_auth sayfasina gidin
asagidaki yontem ve test datalarini kullanarak authentication’i yapin
Html komutu : https://username:password@URL
Username    : admin
password    : admin
Basarili sekilde sayfaya girildigini dogrulayin
     */


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test(){

        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


        //asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username    : admin
        //password    : admin

        //Basarili sekilde sayfaya girildigini dogrulayin
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());

    }

}
