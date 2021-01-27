import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Table implements ActionListener {

    private static final GuiElements Elements=new GuiElements();
    private static final DataChecks DC=new DataChecks();
    private static final Database Db=new Database();


    private final static Object[][] UserDatas=new Object[1][4];
    public final String[] Columns_parking={"Dátum","Parkolóhelyek száma","Rendszám"};
    public final String[] Columns_room={"Dátum","Terem száma","Idöpont"};
    private final static String[] Columns_user={"Id","Név","Kapcsolattartó neve","Telefonszáma"};

    private static int Id=0;
    private static final int Sorszam=0;


    private static void UserDataLoad(CompanyUser User){
        UserDatas[0][0]=User.UserId;
        UserDatas[0][1]=User.CompanyName;
        UserDatas[0][2]=User.ContactPerson;
        UserDatas[0][3]=User.ContactPhone;
    }


    public void Table_Gui_Room(String query,String[] columns){
        Object[][] Datas;
        Datas=Db.SqlTable(query);
        Elements.TableFrame_Room.setSize(400,400);
        Elements.TableFrame_Room.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Elements.TableFrame_Room.setTitle("<-- Parking & Reserved -->");
        Elements.TablePanel.setLayout(null);
        Elements.TableFrame_Room.add(Elements.TablePanel);

        JTable Table=new JTable(Datas,columns);

        Elements.TableFrame_Room.add(new JScrollPane(Table));

        Elements.TableFrame_Room.pack();
        Elements.TableFrame_Room.setVisible(true);

    }
    public void Table_Gui_Parking(String query,String[] columns){
        Object[][] Datas;
        Datas=Db.SqlTable(query);
        Elements.TableFrame_Parking.setSize(400,400);
        Elements.TableFrame_Parking.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Elements.TableFrame_Parking.setTitle("<-- Parking & Reserved -->");
        Elements.TablePanel_Parking.setLayout(null);
        Elements.TableFrame_Parking.add(Elements.TablePanel_Parking);

        JTable Table=new JTable(Datas,columns);

        Elements.TableFrame_Parking.add(new JScrollPane(Table));

        Elements.TableFrame_Parking.pack();
        Elements.TableFrame_Parking.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
