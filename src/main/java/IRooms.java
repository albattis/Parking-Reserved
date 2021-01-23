import java.time.LocalDate;
import java.time.LocalTime;

public interface IRooms {

    boolean IHaveRoom();
    boolean Room_Free(int Rn);
    boolean Room_Full();
    boolean Room_Reserved(int roomnumber,LocalDate Day, LocalTime time, int identy, String company, String contact, String contact_phone);
    void Room_Status();



}
class Room implements IRooms
{
    ErrorMessage Errors=new ErrorMessage();
    private int roomnumber;
    private int Number_Of_Seats;
    private boolean Error;


    @Override
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
    public boolean Room_Full() {
        Error=false;
        //adatbázisbol lekérés
        if(true){Error=true;}
        return Error;
    }

    @Override
    public boolean Room_Reserved(int roomnuber,LocalDate Day, LocalTime time, int identy, String company, String contact, String contact_phone) {
        try {

            Error = false;
            if (Room_Full()) {
                //adatbázisba beszurás
                Error = true;
                Errors.Error("Terem foglalás","Sikeres terem foglalás");
            } else {
                Error = false;
            }
        }
        catch(NumberFormatException e) {
            System.err.println( e.getMessage());
            Errors.Error("Terem Száma Hiba", "Nem megfelelö terem számot adott meg.");
        }
        return Error;
    }


    @Override
    public void Room_Status() {
        // visszaadja a lekérdezés objektumát
    }
}
