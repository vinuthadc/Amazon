package jdbcPackage;
import java.sql.*;
public class JDBC_con {

    public static void main(String[] args) throws SQLException
    {

        JDBC_con obj = new JDBC_con();
        obj.doFirst_JDBC_Connection();
        //obj.change_Mobile_Number(3333, 3);

    }
    public void doFirst_JDBC_Connection() throws SQLException {
        try {
            // First Load The MySQL Driver ..
            Class.forName("com.mysql.jdbc.Driver");
            // To Do The Connections

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","Vinutha@2022");

            if(conn!=null) {
                System.out.println("Connection Success");
                // Create Statement and execute the Query ..
                //Statement STMT = conn.createStatement();
                //STMT.execute("Create database Orkut;");
                //System.out.println("Database Creation is Done!");
                //STMT.execute("Use Orkut;");
			/*STMT.execute("create table Students(Roll INT NOT NULL,"
                    + "Age INT NOT NULL, "
                    + "Mobile INT NOT NULL, "
                    + "FirstName varchar(255), "
                    + "LastName varchar(255) );");
			System.out.println("Table Creation is Done!");*/
                //STMT.execute("insert into Students Values(1,23,45698,'Aarav','A');");
                //STMT.execute("insert into Students Values(2,23,45698,'Vic','parmar');");
                //STMT.execute("insert into Students Values(3,28,45691,'Mona','parmar');");
                //STMT.execute("insert into Students Values(4,20,45692,'Teena','parmar');");

                //System.out.println("data insertion is Done!");
                //STMT.execute("update Students set Mobile='11111' where Roll=2");
                //STMT.execute("update Students set FirstName='Raksha' where Age=20");
                //System.out.println("Table Data Update is Done");

                //STMT.execute("drop database Orkut;");
                //System.out.println("Database deletion is Done!");


                conn.close();

            }
            else

                System.out.println("Connection Failure");
        }


        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    // Here is another method
    public void change_Mobile_Number(int MN, int roll) throws SQLException {



        try {

            // First Load The MySQL Driver ..

            //Class.forName("com.mysql.jdbc.Driver");

            // To Do The Connections

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","Vinutha@2022");

            if(conn!=null) {
                System.out.println("Connection Success");

                // Create Statement and execute the Query ..


                Statement STMT = conn.createStatement();

                STMT.execute("use Orkut;");

                STMT.execute("update Students set Mobile='"+MN+"' where Roll= '"+roll+"' ");
                System.out.println("Table Data Update is Done");


                conn.close();


            }
            else

                System.out.println("Connection Failure");
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }


}







