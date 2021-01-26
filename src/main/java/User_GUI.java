import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class User_GUI implements ActionListener {

    private boolean data=false;
    private LocalTime time;
    private LocalDate date;
    private static final CompanyUser CompUs=new CompanyUser();
    private static final ErrorMessage Error=new ErrorMessage();
    private static final Parkings Rp=new Parkings();
    private static final DateTime DT=new DateTime();
    private static final GuiElements Elements=new GuiElements();
    private static final Room Rooms=new Room();
    private static final Database DB=new Database();
    private static final DatabaseQuerys q=new DatabaseQuerys();
    int roomnumber;




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

        Elements.passwordField.setBounds(200, 350, 200, 30);
        Elements.passwordField.setText("");
        Elements.RoomReservedPanel.add(Elements.passwordField);

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

    public void UserBoard(String[] login,String pass)
    {//Bejelentkezés utáni képernyő
        CompUs.UserId=Integer.parseInt(login[0]);
        CompUs.CompanyName=login[1];
        CompUs.Password=pass;
        CompUs.ContactPerson=login[3];
        CompUs.ContactPhone=login[4];
        Rp.Parking= DB.SQLConnectionParking(q.ParkingQuery);
        Rp.Parking_to_Guest=DB.SQLConnectionParking(q.ParkingQuery);
        UserScreen();

    }

    public void UserScreen()
    {
        Elements.ChoiceFrame.setSize(600, 500);
        Elements.ChoiceFrame.setTitle("<-- Parking & Reserved -->");
        Elements.ChoiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Elements.ChoicePanel.setLayout(null);
        Elements.ChoiceFrame.add(Elements.ChoicePanel);

        Elements.Title.setBounds(150,20,400,30);
        Elements.ChoicePanel.add(Elements.Title);

        Elements.Room_View.setBounds(25,80,250,30);
        Elements.ChoicePanel.add(Elements.Room_View);
        Elements.Room_View.addActionListener(new User_GUI());

        Elements.Parking_view.setBounds(300,80,275,30);
        Elements.ChoicePanel.add(Elements.Parking_view);
        Elements.Parking_view.addActionListener(new User_GUI());

        Elements.Reserved.setBounds(25,125,250,200);
        Elements.ChoicePanel.add(Elements.Reserved);
        Elements.Reserved.addActionListener(new User_GUI());

        Elements.Parking.setBounds(300,125,275,200);
        Elements.ChoicePanel.add(Elements.Parking);
        Elements.Parking.addActionListener(new User_GUI());

        Elements.passwordField.setBounds(200, 350, 200, 30);
        Elements.ChoicePanel.add(Elements.passwordField);

        Elements.PasswordText.setBounds(50,350,200,30);
        Elements.ChoicePanel.add(Elements.PasswordText);

        Elements.ChoiceFrame.setVisible(true);
    }

    public int RoomNumberFormat(){
    try {

        roomnumber = Integer.parseInt(Elements.Number_Text.getText());
    } catch (NumberFormatException e) {Error.Error("Számhiba","Nem jó számot adott meg.");}
    return roomnumber;
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
        Elements.PasswordText.setBounds(50,350,200,30);
        Elements.LoginPanel.add(Elements.PasswordText);

        Elements.passwordField.setBounds(200, 350, 200, 30);
        Elements.LoginPanel.add(Elements.passwordField);


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

    public boolean DataChecksDate(){
        date = DT.ReturnDate(Elements.Date_Text.getText());
        data= date != null;
        return data;
    }

    public boolean DataChecksTime(){
        data=false;

        time = DT.ReturnTime(Elements.Time_Text.getText());
        if(time !=null)
        {
            data=true;
        }
        System.out.println(data);
        return data;

    }

    public boolean DataChecksRoom(){
        data=false;
        roomnumber=RoomNumberFormat();
        if (roomnumber > 0)
        {    data = true;
    }
        return data;
    }


    public boolean DataCheck(int id){
        data=false;
            if(id==1) {
                if (DataChecksDate() && DataChecksTime()&& DataChecksRoom()) {
                    data = true;
                }
            }
            if(id==2)
           {
               if (DataChecksDate()&&DataChecksTime()&&(Rp.Parking_Status(Elements.Date_Text.getText(),Elements.Time_Text.getText()))< Rp.Parking_to_Guest&&Elements.RegistrationNumber_Text!=null){
               data=true;}else{Error.Error("Rendszámhiba","Adja meg a rendszámot");}
           }
           if(id==3)
           {
               if(DataChecksDate()&&DataChecksTime()){data=true;}
           }
       return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    /*    if (!Objects.equals(CompUs.Password, Elements.passwordField.getText())) {
            Error.Error("Jelszó hiba","Adja meg a jelszavát");

        } else {
*/
            if(e.getSource()==Elements.Reserved){
            //    Elements.ChoiceFrame.setVisible(false);
                UserBoard_Rooms();
            }

            if(e.getSource()==Elements.Parking_view)
            {

            }

            if(e.getSource()==Elements.Room_View)
            {

            }

            if(e.getSource()==Elements.Back)
            {
                UserScreen();
            }


            if (e.getSource() == Elements.Room_Reserved) {
                if(DataCheck(1))
                {

                    Rooms.Room_Reserved(CompUs.UserId,roomnumber,date,time);
                  //  Elements.RoomReservedPanel.setVisible(false);
                    UserScreen();
                }else
                {
                    Error.Error("Terem foglalás","Hiba történt.");
                }
            }

            if (e.getSource() == Elements.reserved_button){
                     if(DataCheck(2))
                        {
                            Rp.Reserved_Parkings(date,time,CompUs.UserId, Elements.RegistrationNumber_Text.getText());

                    //    Elements.LoginPanel.setVisible(false);
                        UserScreen();

                        }else
                     {
                         Error.Error("Parkoló foglalás","Hiba történt");
                     }
                    }

            if (e.getSource() == Elements.Parking_Check) {
                    if(DataCheck(3)) {

                        int Pcheck = Rp.Parking_Status(Elements.Date_Text.getText(),Elements.Time_Text.getText());
                        Elements.Parking_Return.setText("Szabad Parkolóhelyek száma: " + (Rp.Parking_to_Guest-Pcheck));
                        Elements.passwordField.setText("");
                    }else {
                        System.out.println("nem nem");
                    }
                     }

            if(e.getSource()==Elements.Parking){
              //  Elements.ChoiceFrame.setVisible(false);
                Elements.passwordField.setText("");
                Parking();}

        }

    }

