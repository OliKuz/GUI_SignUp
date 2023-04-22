import javax.swing.JTextField;
import java.awt.Color;

public class WhiteTextField extends JTextField {

    public WhiteTextField(int columns) {
        super(columns);
        setBackground(new Color(0xD9D9D9));
    }

    public WhiteTextField(String text, int columns) {
        super(text, columns);
        setBackground(new Color(0xD9D9D9));
    }

    public WhiteTextField(String text) {
        super(text);
        setBackground(new Color(0xD9D9D9));
    }

    public WhiteTextField() {
        super();
        setBackground(new Color(0xD9D9D9));
    }
}
