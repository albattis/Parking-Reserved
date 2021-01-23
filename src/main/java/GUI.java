import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {

    Database Db=new Database();
       private static final ErrorMessage Error = new ErrorMessage();
       private static final GuiElements Elements=new GuiElements();

    public static void main(String[] args) {



        Elements.LoginFrame.setSize(600, 500);
        Elements.LoginFrame.setTitle("<-- Parking & Reserved -->");
        Elements.LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Elements.LoginPanel.setLayout(null);

        Elements.LoginFrame.add(Elements.LoginPanel);

        Elements.label.setBounds(100, 50, 400, 30);
        Elements.LoginPanel.add(Elements.label);

        Elements.Label_one.setBounds(30, 150, 120, 30);
        Elements.LoginPanel.add(Elements.Label_one);
        Elements.TextField_one.setBounds(200, 150, 200, 30);
        Elements.LoginPanel.add(Elements.TextField_one);
        Elements.Label_two.setBounds(30, 200, 80, 30);
        Elements.LoginPanel.add(Elements.Label_two);
        Elements.passwordField.setBounds(200, 200, 200, 30);
        Elements.LoginPanel.add(Elements.passwordField);
        Elements.button.setBounds(200, 400, 150, 30);
        Elements.LoginPanel.add(Elements.button);
        Elements.button.addActionListener(new GUI());


        Elements.Success.setBounds(200,450,150,30);
        Elements.LoginPanel.add(Elements.Success);
        Elements.LoginFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String pass=String.valueOf(Elements.passwordField.getPassword());
        Login_Controll control=new Login_Controll();


                    String[] user=new String[5];
                    user=control.Login_Controlls(Elements.TextField_one.getText(),pass);
        if(control.returndata) {
            User_GUI a = new User_GUI();
            a.UserBoard(user, pass);
        }
    else
        {
            Error.Error("Hibás Adat","Érvénytelen Felhasználónév,vagy jelszó");
        }
    }

}

