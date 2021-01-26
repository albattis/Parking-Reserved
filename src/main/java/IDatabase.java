import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.logging.Logger;

public interface IDatabase {

     void JDBCConnect();


}

class Database implements IDatabase
{
   private final Logger logger=Logger.getLogger(Database.class.getName());

    public void JDBCConnect() {
        try{Class.forName("com.mysql.jdbc.Driver");logger.info("Sikeres SQL Drier inditás.");}
        catch(ClassNotFoundException e){logger.info("Hiba az SQL Driverrel.");}
    }

   public String[] SQLConnection(String sql){

       String[] k=new String[5];
       try{ JDBCConnect();
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_reserved","root","");
        PreparedStatement statemant= (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs=statemant.executeQuery();

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

        }catch (SQLException e){logger.info("");}
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

   public void SQLInsertParking(String sql) {
        try {

            JDBCConnect();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_reserved", "root", "");
            Statement statemant = connection.createStatement();
           statemant.executeUpdate(sql);


        }catch (SQLException e){
            logger.info("");
        }

    }

   public boolean SQLRooms(int number,String date,String time){
        boolean dates=false;
       String query="SELECT * from rooms_reserved where roomnumber="+number+" and date=\""+date+"\" and time=\"" +time+"\";";
   try {

       JDBCConnect();
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Parking_reserved", "root", "");
       PreparedStatement statement= (PreparedStatement) connection.prepareStatement(query);
       ResultSet rs= statement.executeQuery();

       if (!rs.first()) dates = true;
       else dates = false;
       System.out.println(dates);

   }
   catch(Exception E){logger.info("Sikertelen SQL");}
   return dates;
   }

   public void SQLRoomsInsert(int number,String date,String time,int id){
       String sql="insert into rooms_reserved(`roomnumber`,`date`,`user_id`,`time`)VALUES("+number+",\""+date+"\","+id+",\""+time+"\")";
       try{JDBCConnect();
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_reserved", "root", "");
       Statement statemant = connection.createStatement();
       statemant.executeUpdate(sql);
   }catch (Exception e){logger.info("Beszurási hiba");}
   }
}
