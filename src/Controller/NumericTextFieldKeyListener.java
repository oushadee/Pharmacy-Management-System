
package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class NumericTextFieldKeyListener extends KeyAdapter{
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        // Allow digits and a single dot
        if (!Character.isDigit(c) && c != '.') {
            e.consume(); // Ignore the key event
        }

        // Allow the dot character only once and not at the beginning
        JTextField textField = (JTextField) e.getSource();
        if (c == '.' && textField.getText().contains(".")) {
            e.consume(); // Ignore the key event
        }
    }
}
