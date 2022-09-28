package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {


    @Test
    public void name() throws IOException {


        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //Olusturmuş olduğumuz dosyayı sistemde işleme alır

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); //Workbook objesiyle fis oblesi ile akışa aldığımız dosyamızla bir excell dosyası create ettik

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); //Excel dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçeriz

        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa bir deki 3. satırı bu şekilde seçeriz

        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // Satır seçimi yapıldıktan sonra hücre seçimi bu şekilde yapılır
        System.out.println(cell);


        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        //bir celldekin veriyi silmek icin row objesine ihtiyac vardir
        //row objesin ile removecell methodunu kullanarak cell objesi ile belirttigimiz
        //cell degerini silebilirz

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //Silindiğini test edin
        Assert.assertNull(workbook.getSheet("Sayfa1").getRow(3).getCell(3));
        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(3));

        fos.close();
        fis.close();
        workbook.close();


    }
}
