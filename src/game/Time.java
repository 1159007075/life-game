package game;

import java.util.Timer;
import java.util.TimerTask;

public class Time {
    Logic logic = new Logic();
    static boolean pause;
    Timer timer;

    public void init() {
        timer = new Timer();
        logic.init();
        Time.pause = false;
    }

    public void timer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (!Time.pause) {
                    logic.update();
                    UI.main_panel.repaint();
                }
            }
        }, 100, 600);
    }

    public void stop(UI mainUI) {
        timer.cancel();
        logic.init();
        UI.main_panel.repaint();
        timer = new Timer();
    }


//    public int[][] get_map_value() {
//        return logic.get_map_value();
//    }
//
//    public void random_map() {
//        logic.random_map();
//    }
}