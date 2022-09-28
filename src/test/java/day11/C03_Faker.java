package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {

    /*

"https://facebook.com"  Adresine gidin
“create new account”  butonuna basin
“firstName” giris kutusuna bir isim yazin
“surname” giris kutusuna bir soyisim yazin
“email” giris kutusuna bir email yazin
“email” onay kutusuna emaili tekrar yazin
Bir sifre girin
Tarih icin gun secin
Tarih icin ay secin
Tarih icin yil secin
Cinsiyeti secin
Kaydol butonuna basın
Sayfayi kapatin

     */


    @Test
    public void test() {


        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");


        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        String email=faker.internet().emailAddress(); // Aynı mail adresini girmesi için String bir değişkene atama yaptık
        actions.click(isim).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde defalarca kendi üreteceğimiz veriler yerine
        bizim için rondom veriler üretir ve işimizi kolaylaştırır
        Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır ve ençok kullanılanı
        pom.xml dosyamıza ekleriz. Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        password içinde aynı internet methodunu kullanırız.
        İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */

    }
}
