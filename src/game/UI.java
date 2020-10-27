package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("checkstyle:LineLength")
public class UI extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //���峣��
    final static int height = 600;
    final static int width = UI.height + 150;
    final static int game_panel_width = UI.height;

    //�½�ʱ����
    static Time time = new Time();
    static Map_panel main_panel=new Map_panel(game_panel_width, height);

    public void init() {
        time.init();

        //����mainUI
        UI mainUI = new UI();
        Container container = mainUI.getContentPane();
        mainUI.setTitle("������Ϸ");
        mainUI.setSize(width, height + 39);
        mainUI.setLocationRelativeTo(null);
        mainUI.setVisible(true);
        mainUI.setResizable(false);
        container.setLayout(null);

        //����JPanel
        main_panel.setBackground(Color.white);
        main_panel.setLocation(0, 0);
        mainUI.add(main_panel);

        //����pal�����button
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 20, 100);
        JPanel pnl = new JPanel();
        pnl.setSize(width - game_panel_width, height);
        pnl.setBackground(Color.white);
        pnl.setLocation(game_panel_width, 0);
        pnl.setLayout(flow);

        //���button
        JButton btn_begin = new JButton("��ʼ");
        JButton btn_stop = new JButton("ֹͣ");
        JButton btn_pause = new JButton("��ͣ");

        //��Ӽ�����
        mainUI.addMouseListener(new getMouse());
        btn_begin.addActionListener(new Listener(mainUI, btn_begin, btn_stop, btn_pause));
        btn_stop.addActionListener(new Listener(mainUI, btn_begin, btn_stop, btn_pause));
        btn_pause.addActionListener(new Listener(mainUI, btn_begin, btn_stop, btn_pause));

        pnl.add(btn_begin);
        pnl.add(btn_pause);
        pnl.add(btn_stop);
        btn_stop.setEnabled(false);
        btn_pause.setEnabled(false);
        mainUI.add(pnl);

    }


    //�����Ӧ�¼�
    static class getMouse extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int rowHt = height / Map.x;
            int rowWid = game_panel_width / Map.y;
            int row = (e.getY() - 30) / rowHt;
            int col = (e.getX() - 10) / rowWid;
            if (row < Map.x && col < Map.y) {
                Logic.map.set(col, row, 1);
                //����
                main_panel.repaint();
            }

        }
    }

    class Listener implements ActionListener {
        UI mainUI;
        JButton btn_begin;
        JButton btn_stop;
        JButton btn_pause;

        public Listener(UI mainUI, JButton btn_begin, JButton btn_stop, JButton btn_pause) {
            this.mainUI = mainUI;
            this.btn_stop = btn_stop;
            this.btn_begin = btn_begin;
            this.btn_pause = btn_pause;
        }
        
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_begin) {
                UI.time.timer();
                btn_begin.setEnabled(false);
                btn_stop.setEnabled(true);
                btn_pause.setEnabled(true);
            }
            if (e.getSource() == btn_stop) {
                UI.time.stop(mainUI);
                btn_pause.setText("��ͣ");
                btn_begin.setEnabled(true);
                btn_stop.setEnabled(false);
                btn_pause.setEnabled(false);
            }
            if (e.getSource() == btn_pause) {
                if (!Time.pause) {
                    Time.pause = true;
                    btn_pause.setText("����");
                } else {
                    Time.pause = false;
                    btn_pause.setText("��ͣ");
                }
            }
        }
    }


}