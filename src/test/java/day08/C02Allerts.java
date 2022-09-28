package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02Allerts {
    /*
    Bir websitesine giridigimizde karsimiza bir uyari mesaji ya da bir butona tikladiginizda bir uyari(alert)
    cikabilir. Eger bu uyariya incele(inspect) yapabiliyorsak bu tur alert lere HTML alert denir
    ve istedigimiz locate i alabiliriz. Ama gelen kutusuna mudahale (inspect) edemiyorsak nu tur alert lere js(javascript)
    alert denir. js alert lere mudahale edebilmek icin
    --tamam ya da ok icin driver.swicthTo().alert().accept(); kullanillir
    --iptal icin driver.swicthTo().alert().dismiss(); methodu kullanilir
    --alert icindeki mesaji almak icin driver.swicthTo().alert().getText();
    --Alert bizde bir metin istiyorsa --> driver.switchTo().alert().sendKeys() kullanilir
     */


    /*
    ● Bir class olusturun: Alerts
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
“You successfully clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
       driver.quit();

    }

    @Test
    public void acceptAlert() throws InterruptedException {

        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

       //1.butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // "You successfully clicked an alert" oldugunu test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());
       //Assert.assertTrue(driver.getPageSource().contains("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert() throws InterruptedException {

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();


        //Alert uzerindeki mesaji yazdirin
        System.out.println("2.Butonun Alert Mesaji:" + driver.switchTo().alert().getText());
        Thread.sleep(20000);
        driver.switchTo().alert().dismiss();
        String actualMessage =driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMessage ="successfuly";
        Assert.assertFalse(actualMessage.contains(expectedMessage));

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {

        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın


        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Sena");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebElement visible=driver.findElement(By.xpath("//*[text()='You entered: Sena']"));
        Assert.assertTrue(visible.isDisplayed());

        //Alert üzerindeki mesajı yazdırınız
        Thread.sleep(2000);
        System.out.println("3. Butonun alert mesaji : "+driver.switchTo().alert().getText());



    }
}
