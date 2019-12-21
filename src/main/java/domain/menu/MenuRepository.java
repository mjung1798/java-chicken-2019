package domain.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.ErrorMessage.INVALID_MENU_NUMBER;

/**
 * 데이터를 조회하는 DB역할
 * 기존 코드 수정 불가능
 * 기존 코드에서 추가는 가능
 */

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        menus.add(new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(3, "반반치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(4, "통구이", Category.CHICKEN, 16_000));
        menus.add(new Menu(5, "간장치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(6, "순살치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(21, "콜라", Category.BEVERAGE, 1_000));
        menus.add(new Menu(22, "사이다", Category.BEVERAGE, 1_000));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static Menu findByMenuNumber(final Integer menuNumber) {
        return menus().stream()
                .filter(c -> c.getNumber().equals(menuNumber))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(INVALID_MENU_NUMBER);
                });
    }
}