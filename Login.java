import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class Login{
    public static void main(String[] args) {
        Login login =  new Login();
        Allpasswords allpasswords =  new Allpasswords();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select your domain: ");
        System.out.println("1. Student");
        System.out.println("2. Staff");
        System.out.print("Select an option: ");
        int num = scanner.nextInt();

        System.out.print("Network username or new username): ");
        String userName = scanner.nextLine();
        String userName1 = scanner.nextLine();

//        Console console = System.console();
//        char[] passwordArray = console.readPassword("Enter the password: ");
//        String password = new String(passwordArray);

        List list = allpasswords.readSerializedObject("C:\\User\\Chaoshan\\CZ2002-Lab\\userdata.txt");
        list.forEach(o -> {
            System.out.println(o);
        });


    }
}
