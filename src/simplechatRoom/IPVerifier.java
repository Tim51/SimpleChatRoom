package simplechatRoom;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class IPVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField)input).getText();
        String[] split = text.split("\\.");
        
        if (split.length!=4) {
            return false;
        }
        try {
            for (int i=0; i<3; i++) {
                if (Integer.parseInt(split[i]) < 0 || Integer.parseInt(split[i]) > 255) {
                    return false;
                }
            }
        } catch (NumberFormatException ex){
            return false;
        }
        
        return true;
    }
    
}
