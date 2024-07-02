
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    Name(String fName, String mName, String lName) {
        firstName = fName;
        middleName = mName;
        lastName = lName;
    }

    Name(String fullName) {
        String[] names = fullName.trim().split(" ");
        if (names.length >= 3) {
            firstName = names[0];
            middleName = names[1];
            lastName = names[2];
        } else if (names.length == 2) {
            firstName = names[0];
            middleName = "";
            lastName = names[1];
        } else if (names.length == 1) {
            firstName = names[0];
            middleName = "";
            lastName = "";
        } else {
            throw new IllegalArgumentException("Invalid full name format: " + fullName);
        }
    }

    String getFirstName() {
        return firstName;
    }

    String getMiddleName() {
        return middleName;
    }

    String getLastName() {
        return lastName;
    }

    String getFullName() {
        return firstName + ' ' + middleName + ' ' + lastName;
    }
}