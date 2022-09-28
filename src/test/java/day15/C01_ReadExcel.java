package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void name() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dostaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dostaYolu);


        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //Excel tablosundaki tum tabloyu konsola yazdirin
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        String tablo = "";
        for (int i = 0; i <= sonSatir; i++) {
            tablo = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(tablo);
        }


        /* Printf cozum

        for (int i = 0; i <= sonSatir; i++) {
            System.out.printf("%-15s %-15s %-15s %-15s\n", workbook.getSheet("Sayfa1").getRow(i).getCell(0),
                    workbook.getSheet("Sayfa1").getRow(i).getCell(1),
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2),
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3));


                    for (int i = 0; i < 4; i++) { tek satirda yazdirmak icin
                   System.out.print(workbook.getSheet("Sayfa1").getRow(8).getCell(i)+", ");

}

         */

        }
    }
