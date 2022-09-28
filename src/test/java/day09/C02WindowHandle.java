package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02WindowHandle {

    /*
  //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım

     */


    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown() {

        //9- Sayfaları Kapatalım
        driver.quit();

    }


    @Test
    public void test() throws InterruptedException {


        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();

       //2- Url'nin amazon içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));


        // 3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle= driver.getWindowHandle();


      //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle ="Best Buy";
        String actualTitle =driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


      //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);


      //6- Arama sonuclarının java içerdiğini test edelim
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement java=driver.findElement(By.cssSelector(".a-color-state.a-text-bold"));
        String arananKelime="Java";
        String actual=java.getText();
        Assert.assertTrue(actual.contains(arananKelime));


       //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);


       //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]")).isDisplayed());


        /*
Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
driver'ın window handle değerini string bir değişkene atarız
Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
 */


    }
}