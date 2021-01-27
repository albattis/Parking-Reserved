import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Table implements ActionListener {

    private static final GuiElements Elements=new GuiElements();
    private static final DataChecks DC=new DataChecks();

    private static JTable Table = null;

    private final static Object[][] Datas=new String[50][2];
    private final static Object[][] UserDatas=new Object[1][4];
    private final static String[] Columns_parking={"Dátum","Parkolóhelyek száma","Idöpont"};
    private final static String[] Columns_room={"Dátum","Terem száma","Idöpont"};
    private final static String[] Columns_user={"Id","Név","Kapcsolattartó neve","Telefonszáma"};
    private static final Database Db=new Database();
    private static final DatabaseQuerys q=new DatabaseQuerys();
    private static int Id=0;



    private static int Sorszam=0;


    public void DatasWriteDatas(){
        //visszakapja mag beleir az objektumba
        for (int i = 0; i <2 ; i++) {
            Datas[i][Sorszam]="ir";
        }
    }

    private static void UserDataLoad(CompanyUser User)
    {
        UserDatas[0][0]=User.UserId;
        UserDatas[0][1]=User.CompanyName;
        UserDatas[0][2]=User.ContactPerson;
        UserDatas[0][3]=User.ContactPhone;
    }


    public static void Table_Gui(CompanyUser User)
    {
        UserDataLoad(User);
        Id=User.UserId;
        Elements.TableFrame.setSize(600,500);
        Elements.TableFrame.setTitle("<-- Parking & Reserved -->");
        Elements.TableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Elements.TablePanel.setLayout(null);

        Elements.TableFrame.add(Elements.TablePanel);



        //Elements.TableFrame.pack();


        Elements.Parking_Time_Label.setBounds(50,350,150,20);
        Elements.TablePanel.add(Elements.Parking_Time_Label);

        Elements.Time_Text.setBounds(202,350,150,20);
        Elements.TablePanel.add(Elements.Time_Text);

        Elements.Parking_Date.setBounds(50,300,150,20);
        Elements.TablePanel.add(Elements.Parking_Date);

        Elements.Date_Text.setBounds(202,300,150,20);
        Elements.TablePanel.add(Elements.Date_Text);

        Elements.Parking_Table.setBounds(50,400,200,20);
        Elements.TablePanel.add(Elements.Parking_Table);
        Elements.Parking_Table.addActionListener(new Table());

        Elements.Room_Table.setBounds(300,400,200,20);
        Elements.TablePanel.add(Elements.Room_Table);
        Elements.Room_Table.addActionListener(new Table());

        Elements.TableFrame.setVisible(true);

    }
    private static JTable Table_Select(String id) {

        JTable Table = null;
        if (id == "Parking") {
            Table = new JTable(Datas, Columns_parking);
        }
        if (id == "Room") {
            Table = new JTable(Datas, Columns_room);
        }
        if(id=="User")
        {
            Table = new JTable(UserDatas,Columns_user);

        }
        return Table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Elements.Room_Table)
        {
            if(DC.View_Room_Check())
            {Table=Table_Select("Room");
            Elements.TableFrame.add(new JScrollPane(Table));}
            Elements.TableFrame.setVisible(true);
        }

    }


    public static void main(String[] args) {


    }


}
