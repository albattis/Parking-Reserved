import javax.swing.*;

public class GuiElements {

        JFrame LoginFrame = new JFrame();
        JFrame ChoiceFrame =new JFrame();
        JFrame RoomReservedFrame = new JFrame();
        JFrame TableFrame =new JFrame();

        JPanel LoginPanel = new JPanel();
        JPanel ChoicePanel = new JPanel();
        JPanel RoomReservedPanel = new JPanel();
        JPanel TablePanel= new JPanel();


        JButton reserved_button = new JButton("Parkoló Foglalás");
        JButton Room_Reserved=new JButton("Terem Foglalás");
        JButton Parking_Check = new JButton("Parkolóhelyek ellenőrzése:");
        JButton button = new JButton("Bejelentkezés");
        JButton Reserved=new JButton("Szoba Foglalás");
        JButton Parking=new JButton("Parkoló foglalás");
        JButton Room_Check=new JButton("Terem ellenörzése");
        JButton Room_View=new JButton("Terem foglalások megtekintése");
        JButton Parking_view=new JButton("Parkoló foglalások");
        JButton Back=new JButton("Vissza");


        JLabel Parking_Number = new JLabel("Parkólóhelyek száma: ");
        JLabel Parking_Return = new JLabel("Parkolóhelyek száma:");
        JLabel Title = new JLabel("Üdözöljük a Parking@Reserved Redszerében.");
        JLabel PasswordText=new JLabel("Adja meg a jelszavát");
        JLabel Label_one = new JLabel("Felhasználónév");
        JLabel Label_two = new JLabel("Jelszó");
        JLabel label = new JLabel("Üdözöljük a Parking@Reserved Redszerében. Kérem jelentkezzen be!");
        JLabel Success=new JLabel();
        JLabel Parking_Time_Label=new JLabel("Adja Meg az időpontot:");
        JLabel Parking_Date=new JLabel("Aja meg a Dátumot: ");
        JLabel Room_Check_Text=new JLabel("Terem Ellenörzése:");
        JLabel Room_Number = new JLabel("Terem száma:");


        JTextField Number_Text = new JTextField();
        JTextField Date_Text= new JTextField();
        JTextField TextField_one= new JTextField();
        JTextField Time_Text=new JTextField();

        JPasswordField passwordField = new JPasswordField();

    //private static JTextArea TextArea;


    public GuiElements() {
    }

}
