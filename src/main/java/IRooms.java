import java.time.LocalDate;
import java.time.LocalTime;

public interface IRooms {

    boolean IHaveRoom();
    boolean Room_Free(int Rn);
    boolean Room_Full(int id,String day,String time);
    void Room_Reserved(int id,int roomnumber,LocalDate Day, LocalTime time);
    void Room_Status();




}
class Room implements IRooms
{
    Database Db=new Database();
    ErrorMessage Errors=new ErrorMessage();
    private boolean Error;


    public boolean IHaveRoom() {
        Error=false;
        //adatbázisbol lekérés
        if(true){Error=true;}
        return Error;
    }

    @Override
    public boolean Room_Free(int Rn) {
        Error=false;

        //adatbázisbol lekérés
        if(true){Error=true;}
        return Error;
    }

    @Override
    public boolean Room_Full(int id,String day,String time) {

        return Db.SQLRooms(id,day,time);

    }

    @Override
    public void Room_Reserved(int id,int roomnuber,LocalDate Day, LocalTime time) {
        try {

            Error = false;
            if (Room_Full(roomnuber,Day.toString(),time.toString())) {
               Db.SQLRoomsInsert(roomnuber,Day.toString(),time.toString(),id);

                Errors.Error("Terem foglalás","Sikeres terem foglalás");
            } else {
                Errors.Error("Hiba","SQL hiba");
            }
        }
        catch(NumberFormatException e) {
            System.err.println( e.getMessage());
            Errors.Error("Terem Száma Hiba", "Nem megfelelö terem számot adott meg.");
        }

    }


    @Override
    public void Room_Status() {
        // visszaadja a lekérdezés objektumát
    }
}
