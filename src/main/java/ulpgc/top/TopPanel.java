package ulpgc.top;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TopPanel extends Component implements TopFrameLoader {
    @Override
    public Component load() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.ORANGE);
        topPanel.setBorder(new LineBorder(Color.BLACK,3));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(loadLabel());

        return topPanel;
    }

    private Component loadLabel() {
        JLabel info = new JLabel("Image Viewer");
        info.setFont(new Font(Font.SERIF,3,25));
        return info;
    }
}