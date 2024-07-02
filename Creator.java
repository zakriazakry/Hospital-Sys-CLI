import java.util.Scanner;

public class Creator {
    private Scanner _scanner;
    private ValidatMe _validator;

    public Creator() {
        _scanner = new Scanner(System.in);
        _validator = new ValidatMe();
    }

    public Doctor createDoctorInstance() {
        int id = insertID();
        Name name = insertName();
        String email = insertEmail();
        String phone = insertPhone();
        double price = insertPrice();
        Date date = insertDate();

        return new Doctor(id, name, email, phone, price, date);
    }
    public Patient createPatientInstance() {
        int id = insertID();
        Name name = insertName();
        String phone = insertPhone();
        Date date = insertDate();

        return new Patient(id, name, phone, date);
    }

    public int insertID() {
        System.out.print("Enter ID: ");
        while (!_scanner.hasNextInt()) {
            System.out.println("Invalid input");
            _scanner.next(); 
        }
        int id = _scanner.nextInt();
        _scanner.nextLine(); 
        return id;
    }
    
    public int insertID(String value) {
        System.out.print("Enter "+ value +" ID: ");
        while (!_scanner.hasNextInt()) {
            System.out.println("Invalid input");
            _scanner.next(); 
        }
        int id = _scanner.nextInt();
        _scanner.nextLine(); 
        return id;
    }

    public Name insertName() {
        String value;
        do {
            System.out.print("Enter Name: ");
            value = _scanner.nextLine().trim();
        } while (!_validator.isName(value));
        return new Name(value);
    }

    public String insertEmail() {
        String value;
        do {
            System.out.print("Enter Email: ");
            value = _scanner.nextLine().trim();
        } while (!_validator.isEmail(value));
        return value;
    }

    public String insertPhone() {
        String value;
        do {
            System.out.print("Enter Phone: ");
            value = _scanner.nextLine().trim();
        } while (!_validator.isPhone(value));
        return value;
    }

    public double insertPrice() {
        double value = 0;
        boolean isValidInput = false;
        do {
            System.out.print("Enter Price: ");
            try {
                value = _scanner.nextDouble();
                isValidInput = true;
            } catch (Exception e) {
            System.out.println("Invalid input");
                _scanner.nextLine();
            }
        } while (!isValidInput);
        return value;
    }

    public Date insertDate() {
        int year = insertYear();
        int month = insertMonth();
        int day = insertDay();
        return new Date(year, month, day);
    }
    
    public Date insertDate(String value) {
        System.out.println(value);
        int year = insertYear();
        int month = insertMonth();
        int day = insertDay();
        return new Date(year, month, day);
    }

    public int insertYear() {
        int year;
        do {
            System.out.print("Enter Year: ");
            while (!_scanner.hasNextInt()) {
            System.out.println("Invalid input");
                _scanner.next();
            }
            year = _scanner.nextInt();
        } while (year <= 0);
        return year;
    }

    public int insertMonth() {
        int month;
        do {
            System.out.print("Enter Month [1 - 12]: ");
            while (!_scanner.hasNextInt()) {
            System.out.println("Invalid input");
                _scanner.next(); 
            }
            month = _scanner.nextInt();
        } while (month < 1 || month > 12);
        return month;
    }

    public int insertDay() {
        int day;
        do {
            System.out.print("Enter Day [1 - 31]: ");
            while (!_scanner.hasNextInt()) {
            System.out.println("Invalid input");
                _scanner.next();
            }
            day = _scanner.nextInt();
        } while (day < 1 || day > 31);
        return day;
    }
}
