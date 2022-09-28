package Notlar;

public class AssertVsDropDown {

    /*

 ASSERTTRUE
//beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
// Parametre olarak iki değer alır.
// İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.

ASSERTFALSE
//beklenen bir sonucun false olması durumunda kullanılır.
// İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
// assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.



1. assertEquals
assertEquals , beklenen sonucu gerçek sonuç ile karşılaştırmak için kullanılır.
Beklenen sonuç ile gerçek sonuç eşit değil ise gerçekleştirilen test senaryosu sonucunda assertionError hatası fırlatır.


2. assertTrue
assertTrue, beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
Parametre olarak iki değer alır. İlk parametre de bir mesaj gönderilir ikinci parametrede ise
 gönderilen mesajın doğruluğu için koşul belirlenir.


3. assertFalse
assertFalse, beklenen bir sonucun false olması durumunda kullanılır.
İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.


4.assertNull
assertNull, beklenen bir sonucun null olup olmadığı kontrol edilmesi için kullanılır.
Bir nesneyi parametre olarak alır ve nesne null değil ise assertionError hatası fırlatır.


5.assertNotNull
assertNotNull, beklenen bir sonucun null olmadığını doğrulamak için kullanılır.
Bir nesneyi parametre olarak alır ve nesne null ise assertionError hatası fırlatır.


6.assertSame
assertSame, parametre olarak verilen iki nesnenin aynı nesneye karşılık gelip gelmediğini kontrol eder.
Eğer nesneler aynı nesneyi karşılamıyor ise assertionError hatası fırlatır.


7.assertNotSame
assertNotSame, parametre olarak verilen iki nesnenin birbirine eşit olmadığı kontrolünü eder.
 Eğer aynı nesneye karşılık geliyor ise assertionError hatası fırlatır.



8.assertArrayEquals
assertArrayEquals, parametre olarak verilen iki dizinin eşit olup olmadığını kontrol eder.
Her iki dizi içinde null değeri var ise bunlar eşit olarak kabul edilir. Eğer eşit değil ise assertionError hatası fırlatır.




Dropdowms

        Dropdown menuye ulasmak için Select classından bir obje oluştururuz
        ve locate ettiğimiz dropdown weblementini Select classına tanımlarız
        ve getOption methodunu kullanarak dropdown'u bir list'e atarak dropdawn menunun bütün elemanlarının
        sayısına ulaşabiliriz


 select.selectByVisibleText("Books"); // Eğer Dropdown menudeki option'a string olarak ulaşmak istersek bu methodu kullanırız
 select.selectByIndex(5); // Eğer dropdown menusünun index'i ile ulasmak istersek bu methodu kullanırız
 select.selectByValue("search-alias=stripbooks-intl-ship"); // Eğer dropdown menusundeki optiona value ile ulaşmak
 istersek bu methodu kullanırız


        Dropdown menude seçtiğimiz optiona ulaşmak istersek select.getFirstSelectedOption()
        methodunu kullanırız


        Adim1: Dropdown menuyu herhangi bir locator ile locate edin.
       WebElement ddm=driver.findElement(By.id(“value of id"));

➢ Adim 2: Yeni bir “Select” objesi olusturun ve daha once
locate ettigimiz WebElement’i parametre olarak yeni
objeye ekleyin
Select options=new Select(ddm);


➢ Adim 3: Select class’indan kullanabileceginiz 3
yontemden biriyle dropdown menusundeki
elemananlardan istediginizi secin
options.selectByIndex(1);

Dropdown menusundeki elementleri Select Class’indan
kullanacagimiz yontemlerle 3 sekilde secebiliriz

1. Index kullanarak selectByIndex();
2.Deger kullanarak selectByValue();
3.Gorunen degerini kullanarak selectByVisibleText()

Istenirse getOptions(); methodu kullanilarak
DropDown’daki tum elementler webelementlerden olusan
bir listeye konabilir. List<WebElement>

getFirstSelectedOption() yöntemi, açılır menüde seçilen seçeneği döndürür. Seçenek alındıktan
sonra metni getirmek için getText() yöntemini uygulayabiliriz.


     */
}
