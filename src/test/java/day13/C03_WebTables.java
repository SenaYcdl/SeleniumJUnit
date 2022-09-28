package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {


    //Bir önceki class'daki adrese gidelim
    //Login() methodunu kullanarak sayfaya giriş yapalım
    //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
    //Price basligindaki tum numaralari yazdiriniz




    @Test
    public void test1() {

        login();
        int satir = 3;
        int sutun = 4;

        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        WebElement cell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Sutun ve satirdaki text : " + cell.getText());


        //Price basligindaki tum numaralari yazdiriniz
        List<WebElement> priceBasligi= driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w: priceBasligi){
            System.out.println(w.getText());
        }




    }


    private void login() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");


        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}