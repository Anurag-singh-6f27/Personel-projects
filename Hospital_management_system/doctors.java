package Hospital_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class doctors {
    private static Connection con;
    private Scanner sc;
    public doctors(Connection con){
        this.con=con;
    }
    public void view_all_doctors(){
        try {
            String query = "SELECT * from doctors";
            PreparedStatement p = con.prepareStatement(query);
            System.out.println("Doctors: ");
            System.out.println("+------------------------------------------------------------+");
            System.out.println("|Doctor Id   |Name                  |Specialization          |");
            System.out.println("+------------------------------------------------------------+");
            ResultSet rs= p.executeQuery();
            while (rs.next()){
                int id= rs.getInt("d_ID");
                String name=  rs.getString("name");
                String specialization=rs.getString("specialization");
                System.out.printf("|%-12s|%-22s|%-24s|\n",id,name,specialization);
                System.out.println("+------------------------------------------------------------+");

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void get_Doctor_byID(int id){
        String query = "SELECT * from doctors where d_ID=?";
        try {
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1,id);
            ResultSet rs=p.executeQuery();
            if(rs.next()){
                System.out.println("*******************************************************");
                System.out.println("Doctors info:");
                System.out.println("Doctor Name       ="+rs.getString("name"));
                System.out.println("specialization    ="+rs.getString("specialization"));
                System.out.println("*******************************************************");
            }
            else
                System.out.println("NO! Doctors is found with this id");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean check_doctor(int id){
        String query = "SELECT * from doctors where id=?";
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