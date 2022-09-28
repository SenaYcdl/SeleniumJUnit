package Notlar;

public class BeforeVsAfterNot {

    /*
    @Before : Önce ; @After : Sonra Demek.
     @Test kısmında yazdığımız methodlar; çalışmaya başlamadan önce
     @Before yazan method çalışır;
     sonra kendisi çalışır ve en son olarak ta @After da yazılan method çalışır...
    Bu durum her @Test methodunda aynı şekilde çalışır.
    @After ve @Before methodlarının nerde yazıldığının önemi yoktur



      bir class da;
     -->@before ile olusturulan method class icindeki her test method'undan once ve 1 kez calisir ve
     genellikle public  void setup() seklinde yazilir
     -->@after ile olusturlan method class icindeki her test method'undan sonra ve 1 kez calisir ve
     genellikle public void tearDown() seklinde yazilir


BeforeClass & AfterClass

BeforeClass ve AfterClass notasyonlari kullaniyorsak
olusturacagimiz method'u static yapmammiz gerekiyor


after ve before her method icin ayri ayri calisir
class olanlar ise 1 kez calisir tum methodlari calistirir



 */

}
