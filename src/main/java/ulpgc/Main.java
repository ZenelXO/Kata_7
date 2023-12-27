package ulpgc;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String URL = "C:/Users/angel/Desktop/fotos/";

        MainFrame display = new MainFrame(URL);
        display.setVisible(true);
    }
}