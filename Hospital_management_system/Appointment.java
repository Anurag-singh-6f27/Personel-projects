package Hospital_management_system;

import java.sql.*;
import java.util.Scanner;

public class Appointment {
    private static final String url="jdbc:mysql://localhost:3306/hospital_management";
    private static final String user="root";
    private static final String password="@Anurag2374";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, password);
            patients patient = new patients(con, sc);
            doctors doctor = new doctors(con);
            while (true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM ");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Patients by id");
                System.out.println("4. View all Doctors");
                System.out.println("5. View Doctors by id");
                System.out.println("6. Book Appointment");
                System.out.println("7. Exit");
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        patient.add_patient();
                        System.out.println();
                        break;
                    case 2:
                        patient.view_all_patients();
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Enter Patient's id number");
                        int id = sc.nextInt();
                        patient.get_patient_byID(id);
                        System.out.println();
                        break;
                    case 4:
                        doctor.view_all_doctors();
                        break;
                    case 5:
                        System.out.println("Enter Doctor's id number");
                        int idf = sc.nextInt();
                        doctors.get_Doctor_byID(idf);
                        System.out.println();
                        break;
                    case 6:
                        book_appointment(doctor,patient,sc,con);
                        System.out.println();

                        break;
                    case 7:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Enter valid choice");
                        break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void book_appointment(doctors doc,patients pat,Scanner sc,Connection con)
    {
        System.out.println("Enter Patients id");
        int id=sc.nextInt();
        System.out.println("Enter Doctors id");
        int docId= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Appointment date(YYYY-MM-DD)");
        String appointment_date= sc.nextLine();
        if(checkavailability(docId,appointment_date,con)){
            try {
                String query = "Insert into appointments(doctor_ID,patient_ID,Appointment_date) values (?, ?, ?)";
                PreparedStatement p = con.prepareStatement(query);
                p.setInt(1,docId);
                p.setInt(2,id);
                p.setString(3,appointment_date);
                int r= p.executeUpdate();
                if (r>0){
                    System.out.println("Appointment Booked on "+appointment_date);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            System.out.println("Doctor is not available");
        }
    }

    private static boolean checkavailability(int docId, String appointmentDate,Connection con) {
        String query="Select * from appointments where doctor_ID= ? and Appointment_date=?";
        try {
            PreparedStatement p= con.prepareStatement(query);
            p.setInt(1,docId);
            p.setString(2,appointmentDate);
            ResultSet rs=p.executeQuery();
            if(rs.next()){
                return false;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
