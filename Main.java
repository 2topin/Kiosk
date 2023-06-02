package Kiosk;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int count = 0; // 두 줄로 어떻게 써요??
        Map<String, String> menus = new LinkedHashMap<>();
        Map<String, List<Item>> menuItems = new LinkedHashMap<>();
        List<Item> cart = new ArrayList<>();

        // 메인메뉴 입력
        menus.put("Burgers", "앵거스 비프 통살을 다져만든 버거");
        menus.put("Side", "사이드 메뉴");
        menus.put("Wine", "프랑스산 와인");
        menus.put("Drink", "음료");

        // Burgers 상세메뉴 입력
        List<Item> burgersItems = new ArrayList<>();
        burgersItems.add(new Item("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersItems.add(new Item("SmokeShack", 8.9, "베이컨, 체리 피커에 쉑소스가 토핑된 치즈버거"));
        burgersItems.add(new Item("ShroomBurger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        burgersItems.add(new Item("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgersItems.add(new Item("ShackBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.put("Burgers", burgersItems);

        // Side 상세메뉴 입력
        List<Item> sideItems = new ArrayList<>();
        sideItems.add(new Item("Fry", 4.8, "감자튀김"));
        sideItems.add(new Item("ChickenBites", 8.2, "한입 치킨 10조각"));
        menuItems.put("Side", sideItems);

        // Wine 상세메뉴 입력
        List<Item> wineItems = new ArrayList<>();
        wineItems.add(new Item("RedBottle", 31.5, "프랑스산 레드와인"));
        wineItems.add(new Item("WhiteBottle", 31.5, "프랑스산 화이트와인"));
        menuItems.put("Wine", wineItems);

        // Drink 상세메뉴 입력
        List<Item> drinkItems = new ArrayList<>();
        drinkItems.add(new Item("CokeSmall", 2.9, "콜라 작은거"));
        drinkItems.add(new Item("CokeLarge", 3.6, "콜라 큰거"));
        drinkItems.add(new Item("Lemonade", 4.9, "레몬에이드"));
        menuItems.put("Drink", drinkItems);

        Scanner scanner = new Scanner(System.in);
while (true) {
        // 메인 메뉴 출력 및 선택
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");
        //메인 메뉴 출력
        for (int mainMenuIndex = 1; mainMenuIndex <= menuItems.size(); mainMenuIndex++) {
            String menu = (String) menuItems.keySet().toArray()[mainMenuIndex - 1];
            String desc = menus.get(menu);
            System.out.printf("%d. %-15s | %s%n", mainMenuIndex, menu, desc);
        }

        System.out.println("\n[ ORDER MENU ]");
        System.out.println("5. Order  | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel | 진행중인 주문을 취소합니다.\n");
        System.out.print("메뉴를 선택하세요 : ");
        int mainMenuChoice = scanner.nextInt();

        if (mainMenuChoice == 5) {
            // 장바구니에 담긴 메뉴 확인
            System.out.println("\n아래와 같이 주문 하시겠습니까?");
            System.out.println("\n[ Orders ]");
            double totalPrice = 0;
            for (Item item : cart) {
                System.out.printf("%-15s | W %.1f%n", item.getName(), item.getPrice());
                totalPrice += item.getPrice();
            }
            System.out.println("\n[ Total ]\n" + "W " + totalPrice +"\n");
            System.out.println("1. 주문 / 2. 메뉴판");
            int orderChoice = scanner.nextInt();

            if (orderChoice == 1) {
            System.out.println("주문이 완료되었습니다!!!!!!\n");
                System.out.println("대기번호는 [ " + ++count + " ] 번 입니다."); // 여기
                cart.clear();
                System.out.println("3초후 메뉴판으로 돌아갑니다.");
                try {
                    Thread.sleep(3000);
                }
                    catch(Exception e) {
                        e.getMessage();
                    }

            }
            // 주문 취소
        } else if (mainMenuChoice == 6) {
            System.out.println("진행하던 주문을 취소하시겠습니까?");
            System.out.println("1. 확인 / 2. 취소");
            int cancelChoice = scanner.nextInt();
            if (cancelChoice == 1) {
                cart.clear();
                System.out.println("진행하던 주문이 취소되었습니다.\n");
        }
        } else {
            // 선택한 메인 메뉴의 상세 메뉴 출력 및 나머지 로직 유지
            String selectedMainMenu = "";
            int index = 1;
            for (String menu : menuItems.keySet()) {
                if (index == mainMenuChoice) {
                    selectedMainMenu = menu;
                    break;
                }
                index++;
            }
            System.out.println("선택한 메인 메뉴: " + selectedMainMenu);

            // 선택한 메인 메뉴의 상세 메뉴 출력
            List<Item> selectedMenuItems = menuItems.get(selectedMainMenu);
            System.out.println("\n[ " + selectedMainMenu + " Menu ]");
            int menuItemIndex = 1;
            for (Item item : selectedMenuItems) {
                System.out.printf("%d. %-15s | W %.1f | %s%n", menuItemIndex, item.getName(), item.getPrice(), item.getDesc());
                menuItemIndex++;
            }
            // 상세메뉴 선택
            System.out.println();
            boolean addToCart = true;
            while (addToCart) {
                System.out.print("추가할 메뉴를 선택하세요 : ");
                int itemChoice = scanner.nextInt();
                if (itemChoice >= 1 && itemChoice <= selectedMenuItems.size()) {
                    Item selectedItem = selectedMenuItems.get(itemChoice - 1);
                    System.out.printf("\n%-15s | W %.1f | %s%n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDesc());
                    System.out.println("이 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인 / 2. 취소");
                    int confirmChoice = scanner.nextInt();
                    if (confirmChoice == 1) {
                        cart.add(selectedItem);
                        System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.\n");
                        addToCart = false;
                    } else {
                        System.out.println(selectedItem.getName() + "을(를) 장바구니에 추가하지 않았습니다.\n");
                        addToCart = false;
                    }
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
                }
            }
            }
        }
    }
}