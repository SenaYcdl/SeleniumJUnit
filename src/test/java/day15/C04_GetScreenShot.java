package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot  extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        //amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://www.amazon.com");

        TakesScreenshot ts=(TakesScreenshot) driver;
        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot classindan obje olusturup
        gecici bir File classindan degiskene TakesScreenshot dan olusturdugumuz objeden getScreenshotAs
        methodunu kullanarak gecici bir file olustururuz
         */




        File tumsayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumsayfaResmi,new File("target/ekranGoruntusu/allPage.jpeg"));
        FileUtils.copyFile(tumsayfaResmi,new File("target/screenShot/"+driver.getTitle()+ tarih + "AllPage.jpeg"));

    }
}
