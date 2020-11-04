import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.*;

public class CourseController implements Serializable{
    Map<String, Course> map;

    public CourseController() {
        map = new HashMap<>();
    }

    public CourseController(Map<String, Course> map) {
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


    //------------------------------for admin-----------------------------------
    public void updateCourseName(String courseCode, String newName) {
        Course course = map.get(courseCode);
        course.setCourseName(newName);
    }//update course name, school, add/delete index, update vacancy in a index
    //update choice by admin controller


    public void updateCourseSchool(String courseCode, String newSchool) {
        Course course = map.get(courseCode);
        course.setCourseSchool(newSchool);
    }

    public void updateCourseIndexVacancy(String courseCode, int indexNumber, int newVac) {
        Course course = map.get(courseCode);
        boolean successful = false;
        successful = course.updateIndex(indexNumber, newVac);
        if (successful)
            System.out.println(course.getCourseCode() + " " + indexNumber + " now has a new capacity of " + newVac);
        else
            System.out.println("Failed.");
    }

    public void addCourseIndex(String courseCode, int newIndex, int capacity, String[] timeSlot) {
        Course course = map.get(courseCode);
        boolean res = course.addIndex(newIndex, capacity, timeSlot);
        if (res) System.out.println("Index: " + newIndex + " added.");
        else System.out.println("Failed.");
    }

    public boolean deleteCourseIndex(String courseCode, int indexNumber) {
        Course course = map.get(courseCode);
        boolean res = course.deleteIndex(indexNumber);
        if (res) System.out.println("Index: " + indexNumber + " deleted.");
        else System.out.println("Failed.");
        return res;
    }

    public void addCourse(String courseName, String courseCode, String school, List<CourseType> availableType, int au) {
        Course course = new Course(courseName, courseCode, school, availableType, au);
        if (map.containsKey(courseCode)) {
            System.out.println("courseCode " + courseCode + " has already exist.");
        }
        else map.put(courseCode, course);
    }

    public void checkVacByAdmin(String courseCode, int indexNumber){
        getVacByIndex(courseCode, indexNumber);
    }

    public void checkAllVacByAdmin(String courseCode){
        printAllVancancies(courseCode);
    }

    public boolean addCourseType(String courseCode, CourseType CourseTypeToAdd) {
        Course course = map.get(courseCode);
        boolean res = course.addCourseType(CourseTypeToAdd);
        if (!res) System.out.println("Course type already exist.");
        return res;
    }

    public boolean deleteCourseType(String courseCode, CourseType CourseType) {
        Course course = map.get(courseCode);
        boolean res = course.deleteCourseType(CourseType);
        if (!res) System.out.println("Course type does not exist.");
        return res;
    }

    public void printStudentsByIndexNumber(String courseCode, int indexNumber) {
        Course course = map.get(courseCode);
        Index index = course.getIndex(indexNumber);
        if (index == null) System.out.println(courseCode + " does not contain index " + indexNumber);
        else {
            List<Student> students = index.getRegisteredStudents();
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void printStudentByCourse(String courseCode){
        Course course = map.get(courseCode);
        for (Index in : course.getAllIndex()){
            printStudentsByIndexNumber(courseCode, in.getIndexNumber());
        }
    }

    //-------------------File Operation Function------------------------

    /*public void saveToFile() throws IOException{
        Properties properties = new Properties();
        for (Map.Entry<String,Course> entry : map.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream("CourseInfo.properties"), null);
    }

    public void loadFile()
                  throws IOException,
               ClassNotFoundException{
        Properties properties = new Properties();
        properties.load(new FileInputStream("CourseInfo.properties"));

        for (String key : properties.stringPropertyNames()) {
           map.put(key, properties.get(key).toString());
        }

    }*/

    public void serializeToFile() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("courseInfo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in courseInfo.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deserializeFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("courseInfo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (Map<String, Course>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

    //------------------------------helper function------------------------------
    private void printAllVancancies(String courseCode) {
        Course course = map.get(courseCode);
        List<Index> indexes = course.getAllIndex();
        for (Index i : indexes) {
            System.out.println(i);
        }
    }

    private int getVacByIndex(String courseCode, int indexNumber) {
        Course course = map.get(courseCode);
        int res = course.getIndexVacancy(indexNumber);
        if (res < 0) System.out.println("Index number " + indexNumber + " does not belong to " + courseCode + ".");
        return res;
    }

}