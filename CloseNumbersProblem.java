import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2.Yakın Numaralar Problemi Odev Cozumu
public class CloseNumbersProblem {
	
	// İki ardışık en yakın sayıları bulan metot
	public static String[] findClosestNumbers(int[] arr) {
		
	
	String[] arrException= {"exception"};
	
	// Girdi dizisi null ise veya uzunluğu 2'den küçük veya 1000'den büyükse bir istisna fırlat
	if (arr == null || arr.length < 2 || arr.length >= 1000) {
	
        throw new IllegalArgumentException("Arrayimizin boyu 1 < n < 1000 olmalıdır");
    }
	
	// Dizi elemanları -20,000 ile 20,000 arasında olmalıdır, aksi takdirde bir istisna fırlat
	for (int element : arr) {
        if (element <= -20000 || element >= 20000) {
        	
            throw new IllegalArgumentException("Dizi elemanları -20.000 ile 20.000 arasında olmalıdır.");
        }
    }
	
	
	
    
    	
    // Diziyi sırala
    Arrays.sort(arr); 

    List<String> result = new ArrayList<>();

    int minDiff = Integer.MAX_VALUE;

 // Ardışık elemanlar arasındaki farkı hesapla ve en küçük farkı bul
    for (int i = 1; i < arr.length; i++) {
        int diff = arr[i] - arr[i-1];
        if (diff < minDiff&&diff!=0) {
            minDiff = diff;
            result.clear();
            result.add(arr[i-1] + " " + arr[i]);
        } else if (diff == minDiff) {
            result.add(arr[i-1] + " " + arr[i]);
        }
    }

 

 // Sonuçları bir diziyi dönüştür 
    String[] resultArray = new String[result.size()];
    result.toArray(resultArray);
    
    //Souçları yazdır
    System.out.print("D = {");
    for(int i=0;i<result.size();i++)
    {
    	System.out.print("\""+result.get(i)+"\"");
    	 if((i+1)!=result.size())
         {
              System.out.print(",");
         }
    }
    System.out.print("}");
    System.out.println();
    return resultArray;
    	
 
   
	}
}