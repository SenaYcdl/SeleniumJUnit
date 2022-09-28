package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_File extends TestBaseBeforeAfter {

    /*
    Tests packagenin altina bir class oluşturalim : C04_FileDownload
Iki tane metod oluşturun : isExist( ) ve downloadTest( )
downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
https://the-internet.herokuapp.com/download adresine gidelim.
test.txt dosyasını indirelim
Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
     */


    @Test
    public void test(){


        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");


        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();

        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\Oğuz\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        //indirildigini konsolda gosterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));


    }
}
