public interface IUsers {




    void Room_Status();
    void Room_Rental();

}

class CompanyUser implements IUsers
{

     String CompanyName;
     String Reserved_Room;
     int UserId;
     String ContactPerson;
     String ContactPhone;
     String Password;


    @Override
    public void Room_Status() {

    }


    @Override
    public void Room_Rental() {

    }
}