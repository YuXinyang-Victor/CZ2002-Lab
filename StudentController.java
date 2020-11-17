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

    Map<String, Student> studentMap;
    //Map<String,Student> studentMap;
    //Student student = new Student(name,gender,nationality,matricNo);
   // String studentMatricNo = student.getStudentMatric();

   /* public void setMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }*/

    public StudentController() {
        studentMap = AllStudent.deserializeFromFile();
        studentMap = AllStudent.getStudentMap();
    }
    public StudentController(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }


//    public static studentMap<String, Student> getMap() {
//        return studentMap;
//    }




}

