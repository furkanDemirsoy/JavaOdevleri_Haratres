import java.util.ArrayList;
import java.util.Arrays;
//3. Alisveris Sepeti Odevi
public class ShoppingCart {

    private ArrayList<Integer> itemsWithoutDiscount = new ArrayList<Integer>(); // İndirim uygulanmayan elemanları tutacak liste
    private int[] itemsWithoutDiscountArray; // İndirim uygulanmayan elemanları tutacak dizi
    
    private int[] cartItems; // Alışveriş sepeti elemanlarını tutacak dizi
    private int totalCost; // Alışverişin toplam tutarı

    // Testler için öncelikle bu method çağrılmalıdır
    public void calculateTotalCost(int[] cartItems) {

        // Girdi dizisi null ise veya uzunluğu 1'den küçük veya 100'den büyükse bir istisna fırlat
        if (cartItems == null || cartItems.length <= 1 || cartItems.length >= 100) {
            
            throw new IllegalArgumentException("Alışveriş sepetinin boyutu 1 < n < 100 olmalıdır.");
        }

        // Dizi elemanları 0 ile 2,000 arasında olmalıdır, aksi takdirde bir istisna fırlat
        for (int item : cartItems) {
            if (item <= 0 || item >= 2000) {
               
                throw new IllegalArgumentException("Sepet kalemleri 0 ile 2.000 arasında olmalıdır.");
            }
        }

        
        

            ArrayList<Integer> itemsWithoutDiscount = new ArrayList<Integer>();
            totalCost = 0;

            itemsWithoutDiscount.add(cartItems[cartItems.length - 1]); // Son eleman indirime tabi tutulmaz.

            for (int i = 0; i < cartItems.length - 1; i++) {
                if (cartItems[i] > cartItems[i+1]) {
                    cartItems[i] = cartItems[i] - cartItems[i+1]; // İndirim uygulanıyor
                } else {
                    itemsWithoutDiscount.add(cartItems[i]);
                }
            }

            for (int item : cartItems) {
                totalCost += item;
            }
            System.out.print("Toplam Tutar: " + totalCost + ", ");

            // İndirim yapılmayan elemanları küçükten büyüğe sırala
            for (int i = 0; i < itemsWithoutDiscount.size(); i++) {
                for (int j = i + 1; j < itemsWithoutDiscount.size(); j++) {
                    if (itemsWithoutDiscount.get(i) > itemsWithoutDiscount.get(j)) {
                        // Swap işlemi
                        int temp = itemsWithoutDiscount.get(i);
                        itemsWithoutDiscount.set(i, itemsWithoutDiscount.get(j));
                        itemsWithoutDiscount.set(j, temp);
                    }
                }
            }

            
            
            
            
            // İndirim yapılmayan elemanları diziye çevir
            this.itemsWithoutDiscountArray = convertToIntegers(itemsWithoutDiscount);

            // Alışveriş sepetini kaydet
            this.cartItems = cartItems;
            
            System.out.print("İndirim Yapılmayan Kalemler, C = {");
            for (int k = 0; k < itemsWithoutDiscount.size(); k++) {
             
                System.out.print(itemsWithoutDiscount.get(k));
                if ((k+1) != itemsWithoutDiscount.size()) {
                    System.out.print(",");
                }
            }
            System.out.print("}");
            System.out.println();
        
    }

    // ArrayList'i diziye çeviren yardımcı metot
    private  int[] convertToIntegers(ArrayList<Integer> integers) {
        int[] result = new int[integers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = integers.get(i).intValue();
        }
        return result;
    }

    // İndirim yapılmayan elemanları döndüren metot
    public int[] getItemsWithoutDiscount() {
        return itemsWithoutDiscountArray;
    }

    // Alışveriş sepetinin içideki tüm elemanları döndüren metot
    public int[] getCartItems() {
        return cartItems;
    }

    // Toplam tutarı döndüren metot
    public int getTotalCost() {
        return totalCost;
    }
}
