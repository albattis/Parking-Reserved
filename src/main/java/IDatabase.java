import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.logging.Logger;

public interface IDatabase {

    void JDBCConnect() throws ClassNotFoundException;


}

class Database implements IDatabase
{
   private final Logger logger=Logger.getLogger(Database.class.getName());




    public void JDBCConnect() {
        try{Class.forName("com.mysql.jdbc.Driver");logger.info("Sikeres SQL Drier inditás.");}
        catch(ClassNotFoundException e){logger.info("Hiba az SQL Driverrel.");}
    }

   public String[] SQLConnection(String sql) throws ClassNotFoundException, SQLException {


        JDBCConnect();
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_reserved","root","");
        PreparedStatement statemant= (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs=statemant.executeQuery();
        String[] k=new String[5];
        while(rs.next())
        {
             k[0]=rs.getString(1);
             k[1]=rs.getString(2);
             k[2]=rs.getString(3);
            k[3]=rs.getString(4);
            k[4]=rs.getString(5);
        }
        rs.close();
        return k;

        }
        public int SQLConnectionParking(String sql) {
            int result = 0;
        try {

            JDBCConnect();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_reserved", "root", "");
            PreparedStatement statemant = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet rs = statemant.executeQuery();
            while (rs.next()) {
                result = Integer.parseInt(rs.getString(1));
            }
        }catch (SQLException e){
            System.out.println("Sikertelen eredmény");
        }
            return result;
        }
}
