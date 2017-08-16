package z.frame;

import javax.swing.*;
import java.awt.*;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/3/7.
 */
public class MainFrame extends JFrame {
    private static final long serialVersionUID = -5943382048448028783L;

    public JPanel jPanel;

    public JFrame jFrame;
    public MainFrame(){
        jPanel=new JPanel();
        jFrame = new JFrame();

    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();


    }
}
