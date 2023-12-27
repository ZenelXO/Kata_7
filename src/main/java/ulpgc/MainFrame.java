package ulpgc;

import ulpgc.mid_bottom.MidPanel;
import ulpgc.top.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    private static String URL;
    private MidPanel midPanel;
    public MainFrame(String URL) throws IOException {
        this.URL = URL;
        this.midPanel = new MidPanel(URL);

        this.setTitle("Image Viewer");
        this.setSize(1200,912);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
            //Top Panel
            mainContainer.add(new TopPanel().load(), BorderLayout.NORTH);
            //Mid Panel
            mainContainer.add(midPanel.loadMid(), BorderLayout.CENTER);
            //Bottom Panel
            mainContainer.add(midPanel.loadBottom(), BorderLayout.SOUTH);
    }
}