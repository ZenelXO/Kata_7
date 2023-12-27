package ulpgc.mid_bottom;

import java.awt.*;
import java.io.IOException;

public interface BottomAndMidLoader {
    Component loadMid() throws IOException;
    Component loadBottom();
}