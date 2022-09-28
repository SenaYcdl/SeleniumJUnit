package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01DropDownHandle {

    /*
●Bir class oluşturun:C3_DropDownAmazon
●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }


    @Test
    public void test01(){

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin

        List<WebElement> drops= driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for(WebElement  w: drops){
            System.out.println(w.getText());

        }
        int dropDownList= drops.size();
        int expectedSayi=45;
        Assert.assertNotEquals(expectedSayi,dropDownList);


    }

    @Test
    public void test02(){

       // .Kategori menusunden Books seceneginisecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");


       // 2.Arama kutusuna Java yazin vearatin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);


        // 3.Bulunan sonuc sayisiniyazdirin
       WebElement sonucsayisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucsayisi.getText());


       // 4.Sonucun Java kelimesini icerdigini testedin
       String expectedTitle="Java";
       String actualTitle=sonucsayisi.getText();
       Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
