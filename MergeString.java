//1. Merge String Odev Cozumu
public class MergeString {

	// mergeString adında bir static metot tanımlanıyor
	public static String mergeString(String a,String b)
    {
		
		// Kısıtlamalar kontrol ediliyor ve uygun olmayan durumlar için bir exception fırlatılıyor.
        if (a.length() <= 1 || a.length() >= 2500 || b.length() <= 1 || b.length() >= 2500) {
            throw new IllegalArgumentException("a ve b'nin boyları 1 ile 2500 arasında olmalıdır.");
        }
        
        	
        
        // Girdi stringleri karakter dizilerine çevriliyor.
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        
     // Her iki girdinin uzunluğu alınıyor.
        int aLength = aChars.length;
        int bLength = bChars.length;
        
     // İki girdiyi birleştirdiğimiz karakter dizisinin uzunluğunu hesaplıyoruz.
        int mergedLength = aLength + bLength;
        
     // Birleştirilmiş karakterlerin tutulacağı bir karakter dizisi oluşturuluyor.
        char[] mergedChars = new char[mergedLength];
        
        
     // İki girdiyi birleştirme işlemi yapılıyor.
        int i = 0, j = 0, k = 0;

        while (i < aLength && j < bLength) {
            mergedChars[k++] = aChars[i++];
            mergedChars[k++] = bChars[j++];
        }

     // Eğer birinci girdi tamamlanmışsa, kalan karakterler ikinci girdiden eklenir.
        while (i < aLength) {
            mergedChars[k++] = aChars[i++];
        }

     // Eğer ikinci girdi tamamlanmışsa, kalan karakterler birinci girdiden eklenir.
        while (j < bLength) {
            mergedChars[k++] = bChars[j++];
        }
        
     // Birleştirilmiş karakter dizisi bir stringe dönüştürülüyor ve ekrana yazdırılıyor.
        String string = new String(mergedChars);
        System.out.println("Çıktı: "+string);
        
     // Birleştirilmiş string sonucu döndürülüyor.
        return string;
        
    }
}
