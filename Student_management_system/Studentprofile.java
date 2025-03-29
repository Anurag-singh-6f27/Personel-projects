package Student_management_system;

import java.sql.SQLException;
import java.util.Scanner;

public class Studentprofile {
    private int id;
    private String name;
    private String domain;
    private String address;

    public Studentprofile(int id,String name, String domain,String address){
        this.id=id;
        this.name=name;
        this.domain=domain;
        this.address=address;
    }
    public Studentprofile(String name, String domain,String address){
        this.name=name;
        this.domain=domain;
        this.address=address;
    }

    public Studentprofile() {

    }


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public String getDomain(){
        return domain;
    }
    public void setDomain(String domain){
        this.domain=domain;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    @Override
    public String toString() {
        return "Student id=" + id + "\n"+
                "Student name=" + name + "\n" +
                "Student domain=" + domain + "\n" +
                "Student address=" + address + "\n";
    }

    public static void main(String[] args) throws SQLException {
        short choice;
        Add_action ad=new Add_action();
        Scanner sc= new Scanner(System.in);
        System.out.println("The Student profile portel");
        while (true) {
            System.out.println(
                    "\n Press 1 for Adding Profile \n"+
                            "\n Press 2 for Displaying Profiles \n"+
                            "\n Press 3 for Displaying Profile with ID \n"+
                            "\n Press 4 for Deleting Profile \n"+
                            "\n Press 5 for Updating Profile \n"+
                            "\n Press 6 for Exiting the protal \n"
            );
            System.out.println("Please provide input");
            choice=sc.nextShort();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("** Add Student Profile **");
                    System.out.println("Enter Student Name:");
                    String name= sc.nextLine();
                    System.out.println("Enter Student Domain:");
                    String domain= sc.nextLine();
                    System.out.println("Enter Student Address:");
                    String address= sc.nextLine();
                    Studentprofile sp=new Studentprofile(name,domain,address);
                    boolean valid=ad.add(sp);
                    if(valid) {
                        System.out.println("** Student profile added successfully **");
                        System.out.println("ID of the student is-> " + ad.return_ID(name,domain,address,sp));
                    }
                    else
                        System.out.println("Error occured");
                    break;

                case 2:
                    System.out.println("Display");
                    ad.diplay();
                    break;
                case 3:
                    System.out.println("Enter Student ID");
                    int a= sc.nextInt();
                    sc.nextLine();
                    boolean m2=ad.diplay_with_id(a);
                    if (m2==false)
                        System.out.println("Error occured");
                    break;
                case 4:
                    System.out.println("Enter Student ID to Delete Student profile");
                    int ab= sc.nextInt();
                    sc.nextLine();
                    boolean m=ad.delete(ab);
                    if (m)
                        System.out.println("Profile of Student deleted");
                    else
                        System.out.println("Error occured");
                    break;
                case 5:
                    System.out.println("""
                            To update Student profile\s
                            Press 1 to update Student Domain\s
                            Press 2 To update Student Address""");
                    int se= sc.nextInt();
                    sc.nextLine();
                    if(se==1) {
                        Studentprofile spp = new Studentprofile();
                        System.out.println("Enter Student ID");
                        int id=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Domain");
                        String domainn= sc.nextLine();
                        spp.setDomain(domainn);
                        boolean right=ad.update(id,se,domainn,spp);
                        if (right){
                            System.out.println("Student Domain updated");
                        }
                    }
                    else if(se==2) {
                        Studentprofile spp = new Studentprofile();
                        System.out.println("Enter Student ID");
                        int id=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Address");
                        String domainn= sc.nextLine();
                        spp.setAddress(domainn);
                        boolean right=ad.update(id,se,domainn,spp);
                        if (right){
                            System.out.println("Student Address updated");
                        }
                    }
                    else {
                        System.out.println("Invalid input");
                    }

                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
