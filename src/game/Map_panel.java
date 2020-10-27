package game;

import javax.swing.JPanel;
import java.awt.*;

public class Map_panel extends JPanel {
    /**
     *
     */
    private Image iBuffer;
    private Graphics gBuffer;
    private static final long serialVersionUID = 1L;
    int width, height, x, y,rowHt,rowWid;

    Map_panel(int w, int h) {
        setVisible(true);
        setSize(width = w, height = h);
        x = Map.x;
        y = Map.y;
        width = this.getSize().width;
        height = this.getSize().height;
        rowHt = height / y;
        rowWid = width / x;


    }

    public void update(Graphics g){ paint(g); }

    public void paint(Graphics g) {
        if(iBuffer==null)
        {
            iBuffer=createImage(width,height);
            gBuffer=iBuffer.getGraphics();
            //»­Ïß
            gBuffer.setColor(Color.gray);
            for (int i = 0; i <= y; i++) {
                gBuffer.drawLine(0, i * rowHt, width, i * rowHt);
                if (i == y) {
                    gBuffer.drawLine(0, i * rowHt - 1, width, i * rowHt - 1);
                }
            }
            for (int i = 0; i <= x; i++) {
                gBuffer.drawLine(i * rowWid, 0, i * rowWid, height);
                if (i == x) {
                    gBuffer.drawLine(i * rowWid - 1, 0, i * rowWid - 1, height);
                }
            }
        }
        g.drawImage(iBuffer,0,0,this);
        //»­map
        g.setColor(Color.black);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (Logic.map.get_map_value()[i][j] == 1) {
                    g.fillRect(rowWid * i, rowHt * j, rowWid, rowHt);
                }
            }
        }

    }
}
