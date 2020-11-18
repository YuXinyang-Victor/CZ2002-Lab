import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
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

        System.out.print("Network username or new username: ");
        String userName = scanner.nextLine();
        String userName1 = scanner.nextLine();

        /* In your final app comment intellij part and
        uncomment this console part. this will hide the password from user
         */

//        Console console = System.console();
//        char[] passwordArray = console.readPassword("Enter the password: ");        //this module only runs with command prompt
//        String password = new String(passwordArray);



        /* if you are using intellij for testing use this part below this
         */
        System.out.print("Network password: ");
        String password = scanner.nextLine();
        boolean newAcc = false;



        try{
            FileReader reader = new FileReader("userdata.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if(line.trim().split(" ")[0].equals(userName1)){
                    if(line.trim().split(" ")[1].equals(password)){
                        if(login.checkAllowedPeriod()){
                            System.out.println("Successfully logged");
                            if(num==1){
                                StudentController studentController =  new StudentController();
                                studentController.showMenu(userName);
                            }
                        }else{
                            System.out.println("Restricted login in this time");
                        }

                    }else{
                        System.out.println("Invalid Password");
                    }
                }else{
                    newAcc= true;
                }
            }
            reader.close();

            if (newAcc){
                FileWriter writer = new FileWriter("userdata.txt", true);
                writer.write("\n"+userName1+ " "+password);
                writer.close();
                System.out.println("New account registered and logged in!");
                newAcc=false;
                FileReader reader1 = new FileReader("userdata.txt");
                BufferedReader bufferedReader1 = new BufferedReader(reader1);
                System.out.println("\nStudent List...");
                while ((line = bufferedReader1.readLine()) != null) {
                    System.out.println(line.trim().split(" ")[0]);
                }
                reader1.close();
            }

        }catch (Exception e){

        }




    }

    public boolean checkAllowedPeriod(){
        String allowedSTime = "0800"; //enter allowed start time in "HHMM" format
        String allowedETime = "2000"; //enter allowed end time in "HHMM" format
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        String time = sdf.format(date);

        if(Integer.parseInt(time)<Integer.parseInt(allowedSTime) && Integer.parseInt(time)>Integer.parseInt(allowedETime)){
            return false;
        }else{
            return true;
        }

    }
}
