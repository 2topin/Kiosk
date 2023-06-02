package Kiosk;

import java.util.List;
import java.util.Map;

public class Menu {
    // 이름, 설명 필드
    private String name; // 메뉴 이름 ex) Burgers
    private String desc; // 메뉴 설명 ex) 앵거스 비프~
    Map<String, List<Menu>> menus; // 메인메뉴판

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
