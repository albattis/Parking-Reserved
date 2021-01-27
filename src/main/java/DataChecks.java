import java.time.LocalDate;
import java.time.LocalTime;

public class DataChecks {

    private static final DateTime DT=new DateTime();
    private static final GuiElements Elements=new GuiElements();
    private final ErrorMessage Error=new ErrorMessage();
    private final Parkings Rp=new Parkings();

    private LocalTime time;
    private LocalDate date;
    private int roomnumber;

    private boolean data=false;

    private boolean DataChecksDate(){
        date = DT.ReturnDate(Elements.Date_Text.getText());
        data= date != null;
        return data;
    }

    public int RoomNumberFormat(){
        try {

            roomnumber = Integer.parseInt(Elements.Number_Text.getText());
        } catch (NumberFormatException e) {Error.Error("Számhiba","Nem jó számot adott meg.");}
        return roomnumber;
    }

    private boolean DataChecksTime(){
        data=false;

        time = DT.ReturnTime(Elements.Time_Text.getText());
        if(time !=null)
        {
            data=true;
        }
        System.out.println(data);
        return data;

    }

    private boolean DataChecksRoom(){
        data=false;
        roomnumber=RoomNumberFormat();
        if (roomnumber > 0)
        {    data = true;
        }
        return data;
    }

public boolean View_Room_Check()
{
    data= (DataChecksDate() && DataChecksTime());
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

}
