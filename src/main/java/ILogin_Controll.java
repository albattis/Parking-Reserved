

public interface ILogin_Controll {


    String[] Password_Controll();


}
class Login_Controll implements ILogin_Controll {



    private String Username;
    private String Password;
    public boolean returndata;
    private int id;

    Database DB=new Database();
    DatabaseQuerys q=new DatabaseQuerys();
    PassSecurity ps = new PassSecurity();
    ErrorMessage Error=new ErrorMessage();

    public Login_Controll(){}
    public String[] Login_Controlls(String name, String pass){

        Username = name;
        Password = pass;
        return Password_Controll();

    }

    public String[] Password_Controll(){
        returndata=false;

        String sec = ps.sha256(Password);
        String query=q.Namequery+Username+"\";";
        String[] s=new String[5];

        try{ s=DB.SQLConnection(query); }
        catch (Exception e){
            Error.Error("Adatbázis hiba","Nem sikerült csatlakozni az adatbázishoz.");
        }
        returndata=sec.equals(s[2]);
        return s;
    }


}