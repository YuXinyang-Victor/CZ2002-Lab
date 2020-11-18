import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.*;


public class StudentController {
    private String name;
    private char gender;
    private String nationality;
    private String matricNo;

    HashMap<String, Student> studentMap = new HashMap<String, Student>();
    //Map<String,Student> studentMap;
    Student student = new Student(name,gender,nationality,matricNo);
    String studentMatricNo = student.getStudentMatric();

   /* public void setMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }*/

    public void getStudentFromFile() throws ClassNotFoundException {
        HashMap<String, Student> map = new HashMap<String, Student>();
        String matricNumber = studentMatricNo;
        try {
            FileInputStream fin=new FileInputStream("");
            BufferedReader br=new BufferedReader(new InputStreamReader(fin));
            while((matricNumber =br.readLine())!=null)
            {
                if(studentMap.containsKey(matricNumber))
                {
                    studentMap.get(matricNo);
                    System.out.println(studentMap);

                }
                else
                    System.out.println("Student Info not found!");
            }
            fin.close();
            br.close();
        } catch (IOException e) {
            studentMap = new HashMap<String, Student>();
        }

    }
//    public static studentMap<String, Student> getMap() {
//        return studentMap;
//    }

    public void getTimetable(){
        Timetable timetable =  new Timetable();
        timetable.printTimeTable();
    }

    public void showMenu(String stud){

        while (true){
            Scanner scanner =  new Scanner(System.in);
            StudentCourseController courseController= new StudentCourseController();
            System.out.println("-------------------\n    Course Menu     \n-------------------");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. Swap index of the student");
            System.out.println("4. Swap with another student");
            System.out.println("5. Show Vacancies");
            System.out.println("6. Print Timetable");
            System.out.println("7. Exit");
            System.out.print("Enter a number: ");

            int selection = Integer.parseInt(scanner.nextLine());

            Student student = null;
            for(Map.Entry<String, Student> entry : studentMap.entrySet()) {
                Student value = entry.getValue();
                if(value.getStudentName().equals(stud)){
                    student=value;
                    break;
                }
            }

            switch (selection){
                case 1:
                    System.out.println("Enter Course Code: ");
                    String code = scanner.nextLine();

                    System.out.println("Enter index number: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    int index = Integer.parseInt(scanner.nextLine());

                    courseController.addStudent(code, index, student);


                case 2:
                    System.out.println("Enter Course Code: ");
                    String code1 = scanner.nextLine();

                    System.out.println("Enter index number: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    int index1 = Integer.parseInt(scanner.nextLine());

                    courseController.dropStudent(code1, index1, student);


                case 3:
                    System.out.println("Enter Course Code: ");
                    String code3 = scanner.nextLine();

                    System.out.println("Enter index number 1: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    int index31 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter index number 2: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    int index32 = Integer.parseInt(scanner.nextLine());

                    courseController.swapIndexStudent(code3, index31, index32, student);

                case 4:

                    System.out.println("Enter Course Code: ");
                    String code4 = scanner.nextLine();

                    System.out.println("Enter index number 1: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    int index41 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter index number 2: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    int index42 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter the second student: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    String name = scanner.nextLine();
                    Student std2=null;
                    for(Map.Entry<String, Student> entry : studentMap.entrySet()) {
                        Student value = entry.getValue();
                        if(value.getStudentName().equals(name)){
                            std2=value;
                            break;
                        }
                    }

                    courseController.swapWithAnotherStud(code4, index41, index42, student,std2);

                case 5:
                    System.out.println("Enter Course Code: ");
                    String code5 = scanner.nextLine();

                    System.out.println("Enter index number: "); //if index is a size of a array, use array.size()+1  I cannot find it
                    int index5 = Integer.parseInt(scanner.nextLine());

                    courseController.getVacancies(code5,index5);
                    courseController.printAllVacancies(code5);

                case 6:
                    getTimetable();
                case 7:
                    System.exit(0);


            }

        }




    }




}

