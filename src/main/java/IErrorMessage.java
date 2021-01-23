import javax.swing.*;

public interface IErrorMessage {

    void Error(String title,String message);

}

class ErrorMessage implements IErrorMessage
{
    @Override
    public void Error(String title, String message) {
        JOptionPane.showMessageDialog(null, message,
                title, JOptionPane.PLAIN_MESSAGE);
    }




}
