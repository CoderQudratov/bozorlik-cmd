import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ArrayList<Product> shoppingList=new ArrayList<>();
        while (true){
            System.out.println("\n--- Bozorlik Dasturi ---");
            System.out.println("1. Mahsulot qo'shish");
            System.out.println("2. Mahsulotni o'chirish");
            System.out.println("3. Olingan mahsulotni belgilash");
            System.out.println("4. Mahsulotlar ro'yxatini ko'rish");
            System.out.println("5. Chiqish");
            System.out.print("Tanlovingiz: ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addProduct(scanner,shoppingList);
                    break;
                case 2:
                    deleteProduc(scanner,shoppingList);
                    break;
                case 3:
                    markAsPurchased(scanner,shoppingList);
                    break;
                case 4:
                    viewShopingList(shoppingList);
                    break;
                case 5:
                    System.out.println("Dastur tugadi");
                    return;
                default:
                    System.out.println("Notugri tanlov, qaytadan urinib koring");
            }
        }
    }
    private static void addProduct(Scanner scanner,ArrayList<Product> shoppingList){
        System.out.println("Mahsulot nomi: ");
        String name=scanner.nextLine();
        System.out.println("Mahsulot narxi");
        double price=scanner.nextDouble();
        scanner.nextLine();
        shoppingList.add(new Product(name,price));
        System.out.println("Mahsulot qo'shildi");
    }
    private static void deleteProduc(Scanner scanner,ArrayList<Product> shoppingList){
        if (shoppingList.isEmpty()){
            System.out.println("Ro'yxat bo'sh");
            return;
        }
        viewShopingList(shoppingList);
        System.out.println("O'chirish uchun mahsulot raqamini kiriting");
        int index =scanner.nextInt() -1;
        scanner.nextLine();
        if (index>=0&& index<shoppingList.size()){
            shoppingList.remove(index);
            System.out.println("Mahsulot o'chirildi");
        }else{
            System.out.println("No'tugri raqam kiritildi");
        }
    }
    private static void markAsPurchased(Scanner scanner,ArrayList<Product> shopinggList){
        if (shopinggList.isEmpty()){
            System.out.println("Ro'yxat bo'sh!");
            return;
        }
        viewShopingList(shopinggList);
        System.out.println("Olingan mahsulot raqamini kiriting");
        int index =scanner.nextInt()-1;
        scanner.nextLine();
        if (index>=0&&index<shopinggList.size()){
            shopinggList.get(index).isPurchased=true;
            System.out.println("Mahsulot olingan deb belgilanadi!");
        }else {
            System.out.println("Notugri raqam kiritildi");
        }
    }
    private static void viewShopingList(ArrayList<Product> shopingList){
        if (shopingList.isEmpty()){
            System.out.println("Ro'yxat");
            return;
        }
        System.out.println("\nMahsulotlar ro'yxati");
        for (int i = 0; i < shopingList.size(); i++) {
            System.out.println((i+1)+". "+shopingList.get(i));
        }
    }

}