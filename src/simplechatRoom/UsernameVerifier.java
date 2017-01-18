package simplechatRoom;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class UsernameVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField)input).getText();
        
        if (!Character.isAlphabetic(text.charAt(0))) {
            return false;
        }
        
        for (char c: text.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
}
