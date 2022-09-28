package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04YoutubeAssertions {
    /*
      1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test1(){

        // titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals(driver.getTitle(), "YouTube");
    }

    @Test
    public void test2(){

        //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.cssSelector("yt-icon[id='logo-icon']")).isDisplayed());

    }

    @Test
    public void test3(){

        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.cssSelector("input[type='text']")).isEnabled());

    }

    @Test
    public void test4(){


        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertNotEquals(driver.getTitle(),"youtube");

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }
}
