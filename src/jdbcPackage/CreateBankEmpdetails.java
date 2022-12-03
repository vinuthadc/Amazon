package jdbcPackage;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CreateBankEmpdetails {
    public static void main(String[] args) throws Exception{
        CreateBankEmpdetails obj=new CreateBankEmpdetails();
        //obj.CreateBankEmpdetails();
        obj.Read_EmpTable_Using_JDBC();

    }
    public void CreateBankEmpdetails(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306","root","Vinutha@2022");
            //here sonoo is database name, root is username and password
            if(conn!=null) {
                System.out.println("Connection Success");


                Statement stmt = conn.createStatement();
                // Select/Use The Data Base

                stmt.execute("use SimpliLearn;");
                //Create table inside database
                /*stmt.execute("create table BankEmp" +
                        "(" +
                        "EmpId int not null," +
                        "Mobile double," +
                        "FName varchar(50)," +
                        "LName varchar(50)," +
                        "Email varchar(50)," +
                        "State varchar(2)," +
                        "Doj date," +
                        "Vehicle varchar(200)" +
                        ");");
                System.out.println("Table creation successful");*/

                /*stmt.execute("Insert into BankEmp(EmpId,Mobile,FName,LName,Email,State,Doj,Vehicle) values (2,4445678987,'CAT','MAT','Cat@mat.com','TN','2000-01-02','Bus') ,\n"
                         + "(3,6655678222,'BAT','MAN','BAT@MAN.com','PN','2000-01-03','Van'),\n" +
                        "(4,6655678333,'HE','MAN','HE@MAN.com','JK','2000-01-04','Car'),\n" +
                        "(5,6655678444,'SPIDER','MAN','SPIDER@MAN.com','WB','2000-01-05','Bus'),\n" +
                        "(6,6655678555,'TIK','TOK','TIK@TOK.com','BH','2000-01-06','Car'),\n" +
                        "(7,6655678666,'KIT','KAT','KIT@KAT.com','OR','2000-01-07','Van'),\n" +
                        "(8,6655678888,'MIT','ROT','MIT@ROY.com','KR','2000-01-08','Auto'),\n" +
                        "(9,6655699987,'JOY','TOY','Rik@JOY.TOY','JK','2000-01-09','Cat'),\n" +
                        "(10,6650008987,'SAM','Som','SAM@Som.com','KY','2000-01-10','Car');");
                System.out.println("data inserted successfully");*/

            }
            else
                System.out.println("Connection Failure");


                conn.close();

        }
        catch(Exception e){ e.printStackTrace();}

    }
    public void Read_EmpTable_Using_JDBC(){


        try{
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306","root","Vinutha@2022");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            // Select/Use The Data Base

            stmt.execute("use SimpliLearn;");

            ResultSet result = stmt.executeQuery("select EmpId,Mobile,FName,LName,Email from BankEmp;");


            while (result.next())
            {
                /*int emp_ID = result.getInt("EmpId");
                Double Mo_No = result.getDouble("Mobile");
                String FirstName = result.getString("FName");
                String LastName = result.getString("LName");
                String Email_ID = result.getString("Email");*/
                //To fetch column details using column index follow the below steps
                int emp_ID = result.getInt(1);
                Double Mo_No = result.getDouble(2);
                String FirstName = result.getString(3);
                String LastName = result.getString(4);
                String Email_ID = result.getString(5);


                System.out.println(emp_ID+":"+Mo_No+":"+FirstName+":"+LastName+":"+Email_ID);
            }

            System.out.println("Table Data Addition is Successfull ....??");

            con.close();
        }catch(Exception e){ e.printStackTrace();}

    }







}

