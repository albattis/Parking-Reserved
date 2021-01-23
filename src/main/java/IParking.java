import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface IParking {



    boolean Parking_Full();
    int Parking_Status();

}
class Parkings implements IParking {
    int Parking = 70;
    int Aktual_Parking_status_Guest = 0;
    int Parking_to_Guest = 50;
    String Warning = "Csak egy órára foglalható parkolóhely az irodaházban";
    ErrorMessage Error=new ErrorMessage();

    public Parkings() {

    }


    @Override
    public boolean Parking_Full() {
        boolean akt = false;
        akt = Aktual_Parking_status_Guest < Parking_to_Guest;
        System.out.println(akt);
        return akt;
    }


    @Override
    public int Parking_Status() {
        return (Parking_to_Guest - Aktual_Parking_status_Guest);
    }


    public void Reserved_Parkings(LocalDate Day, LocalTime time, int identy, String company, String contact, String contact_phone) {

        if (Parking_Full()) {
            //adatbázisba beszurás
            Error.Error("Sikeres Parkolóhelyfoglalás","A Parkolót sikeresen lefoglalta");
        } else {
            Error.Error("ParkolóHely foglalás","Nincs elegendö parkolóhely");
        }

    }
}