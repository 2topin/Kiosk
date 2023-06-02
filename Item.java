package Kiosk;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 상세메뉴
public class Item extends Menu {
    // 가격 필드
    private double price;
    private Map<String, List<Item>> menuItems; // 상세메뉴판

    public Item(String name, double price, String desc) {
        super(name, desc);
        this.price = price;
    } // 생성자
    public double getPrice(){
        return price;
    }
    public static void ShowSubMenu(int selectedMenuNum, String selectedMenuName,Item[] items) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n [ " + selectedMenuName + " MENU ] ");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요");
        int i = 1;
        for (Item m : items) {
            if (m != null) {
                System.out.print(i++ + ". ");
                System.out.printf("%-20s | W %-4.1f | %-50s\n", m.getName(), m.price, m.getDesc());
            }
        }
    }
}
