import java.util.ArrayList;
import java.util.Scanner;


public class AddressBook<T> {
    public ArrayList<T> list = new ArrayList<T>();

    public static void main(String[] args) {
        for(int i = 0 ; i <= 1 ; i++){
            if (i==0) {
                System.out.println("Enter the contact details : ");
                Scanner sc = new Scanner(System.in);
                Contacts contact1 = getUserInput(sc);
                System.out.println(contact1.toString());
            }
            else {
                System.out.println("Enter new contact details : ");
                Scanner sc1 = new Scanner(System.in);
                Contacts contact2 = getUserInput(sc1);
                System.out.println(contact2.toString());
            }
        }
    }
    public static Contacts getUserInput(Scanner scanner){
        Contacts contacts = new Contacts();
        System.out.println("Enter firstname : ");
        contacts.setFirstName(scanner.nextLine());

        System.out.println("Enter lastname : ");
        contacts.setLastName(scanner.nextLine());

        System.out.println("Enter city : ");
        contacts.setState(scanner.nextLine());

        System.out.println("Enter state : ");
        contacts.setState(scanner.nextLine());

        System.out.println("Enter zip : ");
        contacts.setZip(scanner.nextLine());

        System.out.println("Enter phoneNumber : ");
        contacts.setPhoneNumber(scanner.nextLine());

        System.out.println("Enter email : ");
        contacts.setEmail(scanner.nextLine());

        return contacts;
    }
}

class Contacts {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    public String toString(){
        return "Address{" + "firstName = " + firstName  + ", lastName = " + lastName
                + ", city = " + city  + ", state = " + state
                + ", zipCode = " + zip + ", phoneNumber = " + phoneNumber + ", email = " + email  + '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}