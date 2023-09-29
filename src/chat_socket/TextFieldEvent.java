package chat_socket;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/*	
  *
   *
    *
     *
      *
       *
        *
         *
          *
           *
      * * * *
       *
        *
      noripan
          *
           *
      * * * *
       *
        *
         *
          *
           *
            *
             *
              *
               *
                */
                
public class TextFieldEvent {

    public void textKeyPress(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z')
                && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE)
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    public void numberKeyPress(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
        /*else if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)){
           evt.consume();
        }*/
    }

    public void numberDecilmalKeyPress(KeyEvent evt, JTextField TextField) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && TextField.getText().contains(".")
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.')
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public void text_numberKeyPress(KeyEvent evt, JTextField TextField) {
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z')                
                
                && (car < 'A' || car > 'Z')
                && (car < '0' || car > '9')
                && (car != (char) KeyEvent.VK_BACK_SPACE)
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }
}
