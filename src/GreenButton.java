import javax.swing.JButton;
import java.awt.Color;

public class GreenButton extends JButton {

    public GreenButton(String text) {
        super(text);
        setBackground(new Color(0x35D86C));
        setForeground(new Color(0x302E2E));
    }

    public GreenButton() {
        super();
        setBackground(new Color(0x35D86C));
        setForeground(new Color(0x302E2E));
    }
}
