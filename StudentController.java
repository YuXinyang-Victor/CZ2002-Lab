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

    }




}

