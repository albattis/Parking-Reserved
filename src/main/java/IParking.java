import java.sql.SQLException;


public interface IParking {


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
    public int Parking_Status(String date,String time){
        String query="SELECT count(date) from parking_reserved where date=\""+date+"\" and time=\""+time+"\"";
        return DB.SQLConnectionParking(query);
    }


    public void Reserved_Parkings(String Day, String time, int identy,String registr) {

        if (Parking_Status(Day.toString(),time.toString())<Parking_to_Guest) {
            String query="insert into parking_reserved(`userid`,`date`,`time`,`Registration_number`)values("+identy+",\""+Day+"\",\""+time+"\",\""+registr+"\");";
            DB.SQLInsertParking(query);
            Error.Error("Sikeres Parkolóhelyfoglalás","A Parkolót sikeresen lefoglalta");
        } else {
            Error.Error("ParkolóHely foglalás","Nincs elegendö parkolóhely");
        }

    }
}