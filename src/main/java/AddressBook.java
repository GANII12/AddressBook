import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class AddressBook<T> {
    static Collection<Contacts> list = new ArrayList<>();
    public static void main(String[] args) {

        AddressBook addressBook= new AddressBook();
        addressBook.input();
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-----------");
            System.out.println("Choose what you want to do : ");
            System.out.println("1. Create Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.println("Enter your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createContacts();
                    break;

                case 2:
                    editContact();
                    break;

                case 3:
                    deleteContact();
                    break;


                case 4:
                    System.out.println("Exit....");
                    break;

                default:
                    System.out.println("Enter valid Option");

            }
        }

    }

    public void createContacts (){
        Contacts contacts = new Contacts();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter firstname : ");
        contacts.setFirstName(sc.nextLine());

        System.out.println("Enter lastname : ");
        contacts.setLastName(sc.nextLine());

        System.out.println("Enter city : ");
        contacts.setState(sc.nextLine());

        System.out.println("Enter state : ");
        contacts.setState(sc.nextLine());

        System.out.println("Enter zip : ");
        contacts.setZip(sc.nextLine());

        System.out.println("Enter phoneNumber : ");
        contacts.setPhoneNumber(sc.nextLine());

        System.out.println("Enter email : ");
        contacts.setEmail(sc.nextLine());

        list.add(contacts);
        System.out.println("Contact " + contacts.getFirstName() + "Created Successfully");
    }

    //edit contact in AddressBook
    public void editContact() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first name you want to edit: ");
        String first = sc.next();

        boolean isPerson = false;

        for (int i = 0; i < list.size(); i++) {
            if (((ArrayList<Contacts>) list).get(i).getFirstName().equals(first)) {

                isPerson = true;


                ((ArrayList<Contacts>) list).get(i).setFirstName(first);

                System.out.print("Enter Last Name:");
                String lastName = sc.next();
                ((ArrayList<Contacts>) list).get(i).setLastName(lastName);

//                System.out.print("Enter Address:");
//                String address = sc.next();
//                ((ArrayList<Contacts>) list).get(i).setAddress(address);

                System.out.print("Enter state:");
                String state = sc.next();
                ((ArrayList<Contacts>) list).get(i).setState(state);

                System.out.print("Enter zip:");
                String zip = sc.next();
                ((ArrayList<Contacts>) list).get(i).setZip(zip);

                System.out.print("Enter phoneNumber:");
                String phoneNumber = sc.next();
                ((ArrayList<Contacts>) list).get(i).setPhoneNumber(phoneNumber);

                System.out.print("Enter email:");
                String email = sc.next();
                ((ArrayList<Contacts>) list).get(i).setEmail(email);

                System.out.println("Contact edited sucessfully");
            }

        }
        if (!isPerson)
            System.out.println("Contact could not be found");
    }

    //to delete address of user
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first name of the contact to be deleted");
        String firstName = sc.next();

        for (int i = 0; i < list.size(); i++) {
            if (((ArrayList<Contacts>) list).get(i).getFirstName().equals(firstName)) {
                list.remove(((ArrayList<Contacts>) list).get(i));
                System.out.println("Contact removed successfully");
            } else {
                System.out.println("Contact not found");
            }
        }
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