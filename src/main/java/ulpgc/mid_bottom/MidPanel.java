package ulpgc.mid_bottom;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MidPanel extends JFrame implements BottomAndMidLoader {
    private final String URL;
    private int index = 0;
    private JPanel midPanel = new JPanel();
    private JLabel imagePanel = new JLabel();
    private JLabel info = new JLabel();

    public MidPanel(String URL) {
        this.URL = URL;
        this.index = index;
    }

    //-----------------------------Middle----------------------------------

    public Component loadMid() throws IOException {
        midPanel.setBorder(new LineBorder(Color.BLACK,2));
        midPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        midPanel.setBackground(Color.WHITE);
            //Componentes
            midPanel.add(loadImages());

        return midPanel;
    }

    private Component loadImages() throws IOException {
        BufferedImage image = ImageIO.read(new File(URL + getImages()));
        ImageIcon finalImage = new ImageIcon(image);
        imagePanel.setIcon(finalImage);
        info.setText(getImages());
        midPanel.repaint();

        return imagePanel;
    }

    private String getImages() {
        File[] file = new File(URL).listFiles();

        return file[index].getName();
    }

    private File[] getImagesSize() {
        File[] file = new File(URL).listFiles();

        return file;
    }

    //-----------------------------Bottom----------------------------------

    public Component loadBottom() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new LineBorder(Color.BLACK,3));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.GRAY);
            //Componentes
            bottomPanel.add(loadFirstButton());
            bottomPanel.add(loadPrevButton());
            bottomPanel.add(info);
            bottomPanel.add(loadNextButton());
            bottomPanel.add(loadLastButton());

        return bottomPanel;
    }

    private Component loadFirstButton() {
        JButton firstButton = new JButton("First Image");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index=0;
                try {loadImages();} catch (IOException ex) {throw new RuntimeException(ex);}
            }
        });

        return firstButton;
    }

    private Component loadLastButton() {
        JButton lastButton = new JButton("Last Image");
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = getImagesSize().length - 1;
                try {loadImages();} catch (IOException ex) {throw new RuntimeException(ex);}
            }
        });

        return lastButton;
    }

    private Component loadNextButton() {
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int imageIndex = index + 1;
                if(imageIndex + 1 >= getImagesSize().length){
                    imageIndex = getImagesSize().length - 1;
                }
                index = imageIndex;
                try {loadImages();} catch (IOException ex) {throw new RuntimeException(ex);}
            }
        });

        return nextButton;
    }

    private Component loadPrevButton() {
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int imageIndex=index-1;
                if(imageIndex < 0){
                    imageIndex = 0;
                }
                index=imageIndex;
                try {loadImages();} catch (IOException ex) {throw new RuntimeException(ex);}
            }
        });

        return prevButton;
    }
}
