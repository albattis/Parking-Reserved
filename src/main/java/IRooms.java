import java.time.LocalDate;
import java.time.LocalTime;

public interface IRooms {


    void Room_Reserved(int id,int roomnumber,LocalDate Day, LocalTime time);

}
class Room implements IRooms
{
    Database Db=new Database();
    ErrorMessage Errors=new ErrorMessage();


    public boolean Room_Full(int id,String day,String time) {

       return Db.SQLRooms(id,day,time);

    }

    @Override
    public void Room_Reserved(int id,int roomnuber,LocalDate Day, LocalTime time) {
        try {

            if (Room_Full(roomnuber,Day.toString(),time.toString())) {
               Db.SQLRoomsInsert(roomnuber,Day.toString(),time.toString(),id);

                Errors.Error("Terem foglalás","Sikeres terem foglalás");
            } else {
                Errors.Error("Sikertelen Teremfoglalás","Sikertelen Teremfoglalás");
            }
        }
        catch(NumberFormatException e) {
            System.err.println( e.getMessage());
            Errors.Error("Terem Száma Hiba", "Nem megfelelö terem számot adott meg.");
        }

    }

}
