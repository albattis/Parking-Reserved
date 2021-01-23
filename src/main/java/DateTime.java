import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class DateTime {

    ErrorMessage Error=new ErrorMessage();

    public LocalDate ReturnDate(String date){

        LocalDate d = null;
        try{d= LocalDate.parse(date);}
        catch (DateTimeParseException e)
        {
            Error.Error("Dátum Hiba","Nem megfelelö dátumot adott meg. \nPl:2020-01-01");
        }
        return d;
}

public LocalTime ReturnTime(String time) {
    LocalTime Time=null;

    try {
        Time = LocalTime.parse(time);
    } catch (DateTimeParseException e) {
        Error.Error("Idöpont hiba", "Nem jó idö formátumot adott meg.\n Pl: 12:00");
    }
    return Time;
}
}