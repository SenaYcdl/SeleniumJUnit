package day09;

import com.beust.ah.A;
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
import java.util.ArrayList;
import java.util.List;

public class C04WindowHandle {

    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
https://the-internet.herokuapp.com/windows adresine gidin.
Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
Click Here butonuna basın.
Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
Sayfadaki textin “New Window” olduğunu doğrulayın.
Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

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

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String handle=driver.getWindowHandle();


        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        driver.findElement(By.xpath("//h3")).isDisplayed();


        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));


        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window Handle Degerleri :" + windowList);
        driver.switchTo().window(windowList.get(1));



        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */


        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertTrue(driver.getTitle().contains("New Window"));


        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());


        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(handle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));



    }
}