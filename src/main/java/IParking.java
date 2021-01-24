import javax.lang.model.util.Elements;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public interface IParking {

    boolean Parking_Full();
    int Parking_Status(String date,String time) throws SQLException;

}
class Parkings implements IParking {
    int Parking = 0;
    int Aktual_Parking_status_Guest = 0;
    int Parking_to_Guest;
    String Warning = "Csak egy órára foglalható parkolóhely az irodaházban";
    Database DB=new Database();
    ErrorMessage Error=new ErrorMessage();

    public Parkings() {

    }


    @Override
    public boolean Parking_Full() {
        boolean akt = false;
        return akt;
    }


    @Override
    public int Parking_Status(String date,String time){
        String query="SELECT count(date) from parking_reserver where date=\""+date+"\" and time=\""+time+"\"";
        return DB.SQLConnectionParking(query);
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