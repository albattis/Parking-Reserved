

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

        try{ s=DB.SQLConnection(query); }catch (Exception e){System.out.println(e.getMessage());}

        returndata=sec.equals(s[2]);
        return s;
    }


}