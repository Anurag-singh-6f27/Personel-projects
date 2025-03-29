package Student_management_system;

import Student_management_system.database.Student_data;

import java.sql.*;

public class Add_action {
    public boolean add(Studentprofile sp) {
        boolean check = false;
        try {
            Connection con = Student_data.getcon();
            String query = "insert into profile (name, domain, address) values (?,?,?)";
            PreparedStatement p=con.prepareStatement(query);
            p.setString(1, sp.getname());
            p.setString(2,sp.getDomain());
            p.setString(3,sp.getAddress());
            int rows=p.executeUpdate();
            if (rows>0)
                check=true;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
        return check;
    }
    public int return_ID(String name,String domain,String address,Studentprofile sp){
        int generatedId =-1;
        try {
            Connection con = Student_data.getcon();
            String query = "SELECT ID FROM profile WHERE name = ? AND domain = ? AND address = ?";
            PreparedStatement p=con.prepareStatement(query);
            p.setString(1, sp.getname());
            p.setString(2, sp.getDomain());
            p.setString(3, sp.getAddress());
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                generatedId = rs.getInt("id");
            }
    }
    catch (Exception e){

    }
        return  generatedId;
    }

    public void diplay() throws SQLException {
        Connection con = Student_data.getcon();
        String query = "SELECT * FROM profile";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);
        while (rs.next()) {
            System.out.println(
                    "Student ID       ->" + rs.getInt(1) + "\n" +
                            "Student Name     ->" + rs.getString(2) + "\n" +
                            "Student Domain   ->" + rs.getString(3) + "\n" +
                            "Student Address  ->" + rs.getString(4)
            );
            System.out.println("*****************************");
        }
    }

    public boolean diplay_with_id(int id) {
        boolean check=false;
        try {
            Connection con = Student_data.getcon();
            String query = "Select * from profile where id = ?";
            PreparedStatement p=con.prepareStatement(query);
            p.setInt(1,id);
            ResultSet rs=p.executeQuery();
            if(rs.next())
            System.out.println(
                    "Student ID       ->" + rs.getInt(1) + "\n" +
                            "Student Name     ->" + rs.getString(2) + "\n" +
                            "Student Domain   ->" + rs.getString(3) + "\n" +
                            "Student Address  ->" + rs.getString(4)
            );
            else
                System.out.println("No student found with this id");
            check=true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public boolean delete(int ab) {
        boolean check=false;
        try {
            Connection con = Student_data.getcon();
            String query = "DELETE FROM profile WHERE id =?";
            PreparedStatement p=con.prepareStatement(query);
            p.setInt(1,ab);
            p.executeUpdate();
            check=true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public boolean update(int id, int se, String field, Studentprofile spp) {
        boolean check=false;
        try {
            Connection con = Student_data.getcon();
            String query1 = "Update profile set domain=? where id=?";
            String query2 = "Update profile set address=? where id=?";
            if (se == 1) {
                PreparedStatement p = con.prepareStatement(query1);
                p.setString(1,field);
                p.setInt(2,id);
                p.executeUpdate();
                check=true;

            }
            else {
                PreparedStatement p = con.prepareStatement(query2);
                p.setString(1,field);
                p.setInt(2,id);
                p.executeUpdate();
                check=true;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return check;
    }
}
