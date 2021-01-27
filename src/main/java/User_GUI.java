import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_GUI implements ActionListener {



    private static final CompanyUser CompUs=new CompanyUser();
    private static final ErrorMessage Error=new ErrorMessage();
    private static final Parkings Rp=new Parkings();
    private static final GuiElements Elements=new GuiElements();
    private static final Room Rooms=new Room();
    private static final Database DB=new Database();
    private static final DatabaseQuerys q=new DatabaseQuerys();

    private static final DataChecks DC=new DataChecks();

    public void UserBoard_Rooms()
    {
        Elements.RoomReservedFrame.setSize(600,500);
        Elements.RoomReservedFrame.setTitle("<-- Parking & Reserved -->");
        Elements.RoomReservedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Elements.RoomReservedPanel.setLayout(null);
        Elements.RoomReservedFrame.add(Elements.RoomReservedPanel);

        Elements.Title.setBounds(150 , 20, 400, 30);
        Elements.Title.setText("Üdözöljük a Parking@Reserved Redszerében.\n"+CompUs.CompanyName);
        Elements.RoomReservedPanel.add(Elements.Title);

        Elements.Room_Number.setBounds(200,150,150,30);
        Elements.RoomReservedPanel.add(Elements.Room_Number);

        Elements.Number_Text.setBounds(400,150,100,25);
        Elements.RoomReservedPanel.add(Elements.Number_Text);

        Elements.Parking_Date.setBounds(250,200,150,30);
        Elements.RoomReservedPanel.add(Elements.Parking_Date);

        Elements.Parking_Time_Label.setBounds(250,250,150,30);
        Elements.RoomReservedPanel.add(Elements.Parking_Time_Label);

        Elements.Time_Text.setBounds(400,250,100,25);
        Elements.RoomReservedPanel.add(Elements.Time_Text);

        Elements.Date_Text.setBounds(400,202,100,25);
        Elements.RoomReservedPanel.add(Elements.Date_Text);

        Elements.Room_Check.setBounds(382,102,150,25);
        Elements.RoomReservedPanel.add(Elements.Room_Check);
        Elements.Room_Check.addActionListener(new User_GUI());

        Elements.Room_Check_Text.setBounds(250,102,180,25);
        Elements.RoomReservedPanel.add(Elements.Room_Check_Text);

        Elements.Room_Reserved.setBounds(350,400,150,30);
        Elements.RoomReservedPanel.add(Elements.Room_Reserved);
        Elements.Room_Reserved.addActionListener(new User_GUI());

        Elements.Back.setBounds(150,400,150,30);
        Elements.RoomReservedPanel.add(Elements.Back);
        Elements.Back.addActionListener(new User_GUI());

        Elements.RoomReservedFrame.setVisible(true);
    }

    public void UserBoard(String[] login,String pass){//Bejelentkezés utáni képernyő
        CompUs.UserId=Integer.parseInt(login[0]);
        CompUs.CompanyName=login[1];
        CompUs.Password=pass;
        CompUs.ContactPerson=login[3];
        CompUs.ContactPhone=login[4];
        Rp.Parking= DB.SQLConnectionParking(q.ParkingQuery);
        Rp.Parking_to_Guest=DB.SQLConnectionParking(q.ParkingQuery);

        UserScreen();

    }

    public void UserScreen(){
        Elements.ChoiceFrame.setSize(600, 500);
        Elements.ChoiceFrame.setTitle("<-- Parking & Reserved -->");
        Elements.ChoiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Elements.ChoicePanel.setLayout(null);
        Elements.ChoiceFrame.add(Elements.ChoicePanel);

        Elements.Title.setBounds(150,20,400,30);
        Elements.ChoicePanel.add(Elements.Title);

        Elements.Reserved_View_Room.setBounds(25,80,250,30);
        Elements.ChoicePanel.add(Elements.Reserved_View_Room);
        Elements.Reserved_View_Room.addActionListener(new User_GUI());

        Elements.Reserved_View_Parking.setBounds(300,80,250,30);
        Elements.ChoicePanel.add(Elements.Reserved_View_Parking);
        Elements.Reserved_View_Parking.addActionListener(new User_GUI());

        Elements.Reserved.setBounds(25,125,250,200);
        Elements.ChoicePanel.add(Elements.Reserved);
        Elements.Reserved.addActionListener(new User_GUI());

        Elements.Parking.setBounds(300,125,275,200);
        Elements.ChoicePanel.add(Elements.Parking);
        Elements.Parking.addActionListener(new User_GUI());

        Elements.ChoiceFrame.setVisible(true);
    }

    public void Parking(){

        Elements.LoginFrame.setSize(600, 500);
        Elements.LoginFrame.setTitle("<-- Parking & Reserved -->");
        Elements.LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Elements.LoginPanel.setLayout(null);
        Elements.LoginFrame.add(Elements.LoginPanel);
        //**********************************************

        Elements.Title.setBounds(150 , 20, 400, 30);
        Elements.Title.setText("Üdözöljük a Parking@Reserved Redszerében.\n"+CompUs.CompanyName);
        Elements.LoginPanel.add(Elements.Title);

        Elements.Parking_Number.setBounds(50,100,180,30);
        Elements.LoginPanel.add(Elements.Parking_Number);


        Elements.Number_Text.setBounds(182,102,30,25);
        Elements.LoginPanel.add(Elements.Number_Text);


        Elements.Parking_Check.setBounds(50,150,200,25);
        Elements.LoginPanel.add(Elements.Parking_Check);
        Elements.Parking_Check.addActionListener(new User_GUI());


        Elements.Parking_Date.setBounds(50,200,180,30);
        Elements.LoginPanel.add(Elements.Parking_Date);
        Elements.Parking_Time_Label.setBounds(50,250,180,30);
        Elements.LoginPanel.add(Elements.Parking_Time_Label);

        Elements.RegistrationNumber.setBounds(50,300,180,30);
        Elements.LoginPanel.add(Elements.RegistrationNumber);

        Elements.RegistrationNumber_Text.setBounds(232,300,100,25);
        Elements.LoginPanel.add(Elements.RegistrationNumber_Text);

        Elements.Time_Text.setBounds(182,250,100,25);
        Elements.LoginPanel.add(Elements.Time_Text);

        Elements.Date_Text.setBounds(182,202,100,25);
        Elements.LoginPanel.add(Elements.Date_Text);

        Elements.Parking_Return.setBounds(50,50,220,25);
        Elements.LoginPanel.add(Elements.Parking_Return);

        Elements.reserved_button.setBounds(100, 400, 150, 30);
        Elements.LoginPanel.add(Elements.reserved_button);
        Elements.reserved_button.addActionListener(new User_GUI());

        Elements.Back.setBounds(350,400,150,30);
        Elements.LoginPanel.add(Elements.Back);
        Elements.Back.addActionListener(new User_GUI());


        Elements.LoginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Elements.reserved_button){
            if(DC.DataCheck(2,Elements.Time_Text.getText(),Elements.Date_Text.getText(),Elements.Number_Text.getText()))
            {
                Rp.Reserved_Parkings(Elements.Date_Text.getText(),Elements.Time_Text.getText(),CompUs.UserId, Elements.RegistrationNumber_Text.getText());

                //    Elements.LoginPanel.setVisible(false);
                UserScreen();

            }else
            {
                Error.Error("Parkoló foglalás","Hiba történt");
            }
        }

        if (e.getSource() == Elements.Room_Reserved) {
            if(DC.DataCheck(1,Elements.Time_Text.getText(),Elements.Date_Text.getText(),Elements.Number_Text.getText()))
            {

                Rooms.Room_Reserved(CompUs.UserId,DC.RoomNumberFormat(Elements.Number_Text.getText()),Elements.Date_Text.getText(),Elements.Time_Text.getText());

                UserScreen();
            }else
            {
                Error.Error("Terem foglalás","Hiba történt.");
            }
        }

        if (e.getSource() == Elements.Parking_Check) {
            if(DC.DataCheck(3,Elements.Time_Text.getText(),Elements.Date_Text.getText(),Elements.Number_Text.getText())) {

                int Pcheck = Rp.Parking_Status(Elements.Date_Text.getText(),Elements.Time_Text.getText());
                Elements.Parking_Return.setText("Szabad Parkolóhelyek száma: " + (Rp.Parking_to_Guest-Pcheck));
                Elements.passwordField.setText("");
            }else {

            }
        }

        if(e.getSource()==Elements.Back){
            UserScreen();
        }

        if(e.getSource()==Elements.Reserved){
                UserBoard_Rooms();
            }

        if(e.getSource()==Elements.Reserved_View_Room) {
                Table table=new Table();
                String query="SELECT * from rooms_reserved where user_id="+CompUs.UserId+" order by rooms_reserved.date desc limit 20;";
                table.Table_Gui_Room(query,table.Columns_room);
            }

        if(e.getSource()==Elements.Reserved_View_Parking){
                Table table=new Table();
                String query="SELECT * from parking_reserved where userid="+CompUs.UserId+" order by parking_reserved.date desc limit 20;";
                table.Table_Gui_Parking(query,table.Columns_parking);
            }

        if(e.getSource()==Elements.Parking){
              //  Elements.ChoiceFrame.setVisible(false);
                Elements.passwordField.setText("");
                Parking();}


    }

    }

