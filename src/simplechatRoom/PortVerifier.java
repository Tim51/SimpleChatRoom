package simplechatRoom;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class PortVerifier extends InputVerifier{

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField)input).getText();

        try {
            int i = Integer.parseInt(text);
            if (i<0 || i> 65535) {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
        
        return true;
    }
    
}
