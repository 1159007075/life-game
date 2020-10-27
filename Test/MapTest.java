import game.Map;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    Map map = new Map();

    @Before
    public void setUp() throws Exception {
        map.init_map();
    }

    //正常测试
    @Test
    public void get_neighbor() {
        int random_x = (int) Math.random() * (Map.x - 2) + 1;//取1-Map.x-2间的随机数
        int random_y = (int) Math.random() * (Map.y - 2) + 1;//取1-Map.y-1间的随机数
        map.set(random_x, random_y, 1);
        map.set(random_x - 1, random_y, 1);
        map.set(random_x + 1, random_y, 1);

        assertEquals(2, map.get_neighbor(random_x, random_y));
    }

    //边界测试
    @Test
    public void get_neighbor_border() {
        for (int i = 0; i < Map.x; i++) {
            for (int j = 0; j < Map.y; j++) {
                map.set(i, j, 1);
            }
        }
        for (int i = 1; i < 29; i++) {
            assertEquals(5, map.get_neighbor(i, 0));

        }

    }

    //错误测试
    @Test
    public void get_neighbor_false() {
        int random_x = (int) Math.random() * (Map.x - 2) + 1;//取1-Map.x-2间的随机数
        int random_y = (int) Math.random() * (Map.y - 2) + 1;//取1-Map.y-1间的随机数
        map.set(random_x, random_y, 1);
        map.set(random_x - 1, random_y, 1);
        map.set(random_x + 1, random_y, 1);

        assertFalse(map.get_neighbor(random_x, random_y)!=2);
    }
}