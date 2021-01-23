import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class Table implements ActionListener {

    private static final GuiElements Elements=new GuiElements();

    JTable Table = null;

    private final Object[][] Datas=new String[2][50];
    private final Object[][] UserDatas=new Object[5][1];
    private final String[] Columns_parking={"Dátum","Parkolóhelyek száma"};
    private final String[] Columns_room={"Dátum","Szoba száma"};
    private final String[] Columns_user={"Id","Név","Kapcsolattartó neve","Telefonszáma"};



    private String id="";
    private final int Sorszam=0;

    public void DatasWriteUsers(){
        //visszakapja a beolvasott értéket és elmenti a változoba
        for (int i = 0; i < UserDatas.length; i++) {
            UserDatas[i][0]="id";
        }
    }

    public void DatasWriteDatas(){
        //visszakapja mag beleir az objektumba
        for (int i = 0; i <2 ; i++) {
            Datas[i][Sorszam]="ir";
        }
    }

    public void Table_Gui()
    {

        Elements.TableFrame.setSize(600,500);
        Elements.TableFrame.setTitle("<-- Parking & Reserved -->");
        Elements.TableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Elements.TablePanel.setLayout(null);
        Elements.TableFrame.add(Elements.TablePanel);

        JScrollPane scrollPane = new JScrollPane(Table);

        Table=Table_Select();
        Table.setPreferredScrollableViewportSize(new Dimension(550,300));
        Table.setFillsViewportHeight(true);
        Elements.TableFrame.pack();
        Elements.TableFrame.setVisible(true);


    }
    public JTable Table_Select() {
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

    }


    public static void main(String[] args) {
        Table r=new Table();
        r.id="User";
        r.Table_Gui();
    }


}
