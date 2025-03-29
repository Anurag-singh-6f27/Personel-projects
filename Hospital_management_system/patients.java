package Hospital_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class patients {
    private Connection con;
    private Scanner sc;
    public patients(Connection con,Scanner sc){
        this.con=con;
        this.sc=sc;
    }
    public void add_patient(){
        System.out.println("Enter the name of Patient");
        String name=sc.nextLine();
        System.out.println("Enter the age of Patient");
        int age= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Patient gender");
        String gender= sc.next();
       try {
            String query="Insert into patients(name,age,gender) values(?,?,?)";
            PreparedStatement p=con.prepareStatement(query);
            p.setString(1,name);
            p.setInt(2,age);
            p.setString(3,gender);
            int row= p.executeUpdate();
            if(row>0){
                System.out.println("Patient added successfully");
            }
            else {
                System.out.println("Registration failed");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void view_all_patients(){
        try {
            String query = "SELECT * from patients";
            PreparedStatement p = con.prepareStatement(query);
            System.out.println("Patients: ");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|Patient Id     |Name                |Age          |Gender          |");
            System.out.println("+-------------------------------------------------------------------+");
            ResultSet rs= p.executeQuery();
            while (rs.next()){
               int id= rs.getInt("p_ID");
              String name=  rs.getString("name");
               int age= rs.getInt("age");
                String gender=rs.getString("gender");
                System.out.printf("|%-15s|%-20s|%-13s|%-16s|\n",id,name,age,gender);
                System.out.println("+-------------------------------------------------------------------+");

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void get_patient_byID(int id){
        String query = "SELECT * from patients where p_ID=?";
        try {
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1,id);
            ResultSet rs=p.executeQuery();
            if(rs.next()){
                System.out.println("*******************************************************");
                System.out.println("Patient info:");
                System.out.println("Patient Name  ="+rs.getString("name"));
                System.out.println("Patient Age   ="+rs.getString("age"));
                System.out.println("Patient gender="+rs.getString("gender"));
                System.out.println("*******************************************************");
            }
            else
                System.out.println("NO! Parients is found with this id");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean check_patient(int id){
        String query = "SELECT * from patients where id=?";
        try {
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1,id);
            ResultSet rs=p.executeQuery();
            if(rs.next())
                return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
