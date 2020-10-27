import game.Logic;
import game.Map;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {
    Logic logic = new Logic();

    @org.junit.Before
    public void setUp() throws Exception {
        logic.init();
    }

    @Ignore
    public void init() {
    }

    //Logic.update正常测试
    @Test
    public void update() {
        int random_x = (int) Math.random() * (Map.x - 2) + 1;//取1-Map.x-2间的随机数
        int random_y = (int) Math.random() * (Map.y - 2) + 1;//取1-Map.y-1间的随机数
        logic.set_map(random_x, random_y, 1);
        logic.set_map(random_x - 1, random_y, 1);
        logic.set_map(random_x + 1, random_y, 1);

        Map map = new Map();
        map.set(random_x, random_y, 1);
        map.set(random_x, random_y - 1, 1);
        map.set(random_x, random_y + 1, 1);

        logic.update();
        assertEquals(map, Logic.map);
    }

    //Logic.update边界测试
    @Test
    public void update_border() {
        for (int i = 0; i < Map.x; i++) {
            for (int j = 0; j < Map.y; j++) {
                logic.set_map(i, j, 1);
            }
        }

        Map map = new Map();
        map.set(0, 0, 1);
        map.set(0, Map.y - 1, 1);
        map.set(Map.x - 1, Map.y - 1, 1);
        map.set(Map.x - 1, 0, 1);

        logic.update();
        assertEquals(map, logic.map);
    }

    //Logic.update错误测试
    @Test
    public void update_false() {
        int random_x = (int) (Math.random() * (Map.x - 2)) + 1;//取1-Map.x-2间的随机数
        int random_y = (int) (Math.random() * (Map.y - 2)) + 1;//取1-Map.y-1间的随机数
        logic.set_map(random_x, random_y, 1);
        logic.set_map(random_x - 1, random_y, 1);
        logic.set_map(random_x + 1, random_y, 1);

        Map map = new Map();
        map.set(random_x, random_y, 1);
        map.set(random_x, random_y - 1, 1);
        map.set(random_x, random_y + 1, 1);

        logic.update();
        assertFalse(!map.equals(logic.map));
    }


    //Logic.set_map测试
    @Test
    public void set_map() {
        for (int i = 0; i < Map.x; i++) {
            for (int j = 0; j < Map.y; j++) {
                //取0或1的随机数
                int ran_num = (int) (Math.random() * 2);
                logic.set_map(i, j, ran_num);
                assertEquals(ran_num, logic.get_map(i, j));
            }
        }
    }

    @Ignore
    public void get_map_value() {
    }

    @Ignore
    public void random_map() {
    }
}