package game;

public class Logic {
    public static Map map = new Map();

    public void init() {
        map.init_map();
    }

    public void update() {
        game.Map temp_map = new Map();
        temp_map.init_map();
        for (int i = 0; i < Map.x; i++) {
            for (int j = 0; j < Map.y; j++) {
                if (map.get_neighbor(i, j) > 3 || map.get_neighbor(i, j) < 2) {
                    temp_map.set(i, j, 0);
                } else if (map.get_neighbor(i, j) == 3) {
                    temp_map.set(i, j, 1);
                } else if (map.get_neighbor(i, j) == 2) {
                    temp_map.set(i, j, map.get(i, j));
                }
            }
        }
        //map.set_map_value(temp_map.get_map_value());
        map = temp_map;
    }

    public void set_map(int col, int row, int value) {
        map.set(col, row, value);
    }

    public int get_map(int col, int row) {
        return map.get(col, row);
    }

    public int[][] get_map_value() {
        return map.get_map_value();
    }

}
