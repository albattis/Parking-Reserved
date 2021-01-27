import java.time.LocalDate;
import java.time.LocalTime;

public class DataChecks {

    private static final DateTime DT=new DateTime();
    private static final GuiElements Elements=new GuiElements();
    private final ErrorMessage Error=new ErrorMessage();
    private final Parkings Rp=new Parkings();
    private final Room room=new Room();

    private String time;
    private String date;
    private int roomnumber;

    private boolean data=false;

    private boolean DataChecksDate(){

        data= date != null;
        System.out.println(data);
        return data;
    }

    public int RoomNumberFormat(String numb){
        try {
            roomnumber=Integer.parseInt(numb);

        } catch (NumberFormatException e) {Error.Error("Számhiba","Nem jó számot adott meg.");}
        return roomnumber;
    }

    private boolean DataChecksTime(){

        data= time != null;
        System.out.println(data);
        return data;

    }

    private boolean DataChecksRoom(String num){
        data=false;
        roomnumber=RoomNumberFormat(num);

        if (roomnumber > 0&&room.Room_Full(roomnumber,date,time))
        {    data = true;
            System.out.println("nincs tele");
        }
        return data;
    }

    public boolean DataCheck(int id,String times,String dates,String number){
        data=false;
        time=times;
        date=dates;
        if(id==1) {

            if (DataChecksDate() && DataChecksTime()&& DataChecksRoom(number)) {
                data = true;
            }
        }
        if(id==2) {

            if (DataChecksDate()&&DataChecksTime()){
                data=true;}else{Error.Error("Rendszámhiba","Adja meg a rendszámot");}
        }
        if(id==3) {

            if(DataChecksDate()&&DataChecksTime()){data=true;}
        }
        return data;
    }

}
