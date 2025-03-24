
import java.util.Scanner;

public class emailapp {
    public static void main(String[] args) {
        email em=new email("Anurag","Singh");
        em.Display();
        em.changePassword("Anurag@2374");
        em.Display();
    }
public static class email{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternate_email;
    private String email;
    private int mailbox=500;
    public email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.department=setDepartment();
        this.password=setPasswrod(14);
        this.email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"."+department.toLowerCase()+"@"+"company."+"com";
    }
    public void Display(){
        System.out.println("Name->"+this.firstName+" "+this.lastName);
        System.out.println("Department->"+this.department.toUpperCase());
        System.out.println("Email->"+this.email);
        System.out.println("Password->"+this.password);
        if(alternate_email!=null) System.out.println("Alternate email->"+this.alternate_email);
        System.out.println("Mailbox Capaacity->"+mailbox+"mb");
    }
    private String setDepartment(){
        System.out.println("Enter the department");
        Scanner sc=new Scanner(System.in);
        String department=sc.nextLine();
        return department;
    }
    private String setPasswrod(int length){
        String passwordset="@#$%abcdefghijklmno!@#$%^pqrstuvwxyz123456ABCDEFGHIJKLM%^&*-+NOPQRSTUVWXYZ789&*(?><";
        char[] ch=new char[length];
        for (int i = 0; i < length; i++) {
            int m=(int)(Math.random()*passwordset.length());
            ch[i]=passwordset.charAt(m);
        }
        return new String(ch);
    }
    public void setAlternate_email(String alternate_email){
        this.alternate_email=alternate_email;
    }
    public void changePassword(String Password){
        this.password=Password;
    }
}
}
