import javax.swing.JLabel;
import java.awt.Color;

public class WhiteLabel extends JLabel {

    public WhiteLabel(String text) {
        super(text);
        setForeground(new Color(0xD9D9D9));
    }

    public WhiteLabel() {
        super();
        setBackground(new Color(0xD9D9D9));
    }
}