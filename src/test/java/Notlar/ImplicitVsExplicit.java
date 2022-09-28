package Notlar;

public class ImplicitVsExplicit {

    /*
    ➢ Driver ile cihaz veya internet arasinda yasanan senkronizasyon sorunlarini çözmek icin
sürücümüzü(driver) belli sartlar ile bekletmemiz(wait) gerekir.

1)Java tabanli wait
Thread.sleep : Javadan gelir ve kodlari yazilan
sure kadar bekletir. Sure dolduktan sonra alt
satirdan isleme devam eder

2 ) Selenium tabanli wait’ler
Implicitly Wait: Sayfadaki tüm öğeler için global bir
zaman aşımıdır(timeout).


                implicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler


Explicitly Wait: Çoğunlukla belirli öğeler için belirli bir koşul(expected condition)
için kullanılır.

 explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız

Implicitly wait ile cozulebilecek durumlar icin expilicitly wait kullanimina ihtiyac yoktur.
Nadiren karsimiza cikan ve daha fazla bekleme süresi
gerektiren belirli öğeler(webelement) için explicitly wait
kullanılır.
İlk olarak belirli miktarda bekleme süresi ile wait object
create edilir.
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));



     */
}
