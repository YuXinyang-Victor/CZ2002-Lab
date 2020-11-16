import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.*;

public class StudentCourseController {
    Map<String, Course> map;

    public StudentCourseController() {
        map = AllCourse.deserializeFromFile();
        map = AllCourse.getMap();
    }

    public StudentCourseController(Map<String, Course> map) {
        this.map = map;
    }
    
        //------------------------------for student----------------------------------
    public boolean addStudent(String courseCode, int indexNumber, Student student) {
        Course course = map.get(courseCode);
        if (course.addStudentToIndex(student, indexNumber)) {
            System.out.println("Student " + student.getStudentName() + " added to " + courseCode +".");
            return true;
        }
        else {
            System.out.println("Failed.");
            return false;
        }
    }

    public boolean dropStudent(String courseCode, int indexNumber, Student student) {
        Course course = map.get(courseCode);
        if (course.deleteStudentFromIndex(student, indexNumber)) {
            System.out.println("Student " + student.getStudentName() + " deleted to " + courseCode + ".");
            return true;
        }
        else {
            System.out.println("Failed.");
            return false;
        }
    }

    public void swapIndexStudent(String courseCode, int indexNumber1, int indexNumber2, Student student) {
        Course course = map.get(courseCode);
        boolean res = course.swapIndex(student, indexNumber1, indexNumber2);
        if (res) System.out.println("Course " + courseCode + ": Student " + student.getStudentName() + ", index " + indexNumber1 + " swapped to index " + indexNumber2 + ".");
        else System.out.println("Failed.");
    }

    public void swapWithAnotherStud(String courseCode, int indexNumber1, int indexNumber2 , Student stud1, Student stud2)
    {
        Course course = map.get(courseCode);
        if (course.swapIndexWithAnotherOne(indexNumber1, indexNumber2 , stud1, stud2))
            System.out.println("Course " + courseCode + ": Student " + stud1.getStudentName() + ", index " + indexNumber1 + " swapped with student " + stud2.getStudentName() + ", index " + indexNumber2 + ".");
        else
            System.out.println("Failed.");
    }

    public int getVacancies(String courseCode, int indexNumber) {
        return getVacByIndex(courseCode, indexNumber);
    }

    public void printAllVacancies(String courseCode) {
        printAllVacancies(courseCode);
    }
    
}