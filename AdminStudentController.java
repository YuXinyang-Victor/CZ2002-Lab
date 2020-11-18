import java.util.Map;
import java.time.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class AdminStudentController{
    private static Map<String, Student> studentMap;
    public AdminStudentController() {
        AllStudent.deserializeFromFile();
        studentMap = AllStudent.getStudentMap();
    }

    public static void addStudent (Student s){
        if (studentMap.containsKey(s.getStudentMatric())){
            System.out.println("Matric No:" + s.getStudentMatric() + "already exist.");
        }
        else studentMap.put(s.getStudentMatric(), s);
        AllStudent.setMap(studentMap);
    }

    public static void editAccessPeriod(String matricNo, String newAccessPeriod){
        try{
            if (studentMap.containsKey(matricNo)==false){
                System.out.println("Matric No: does not exist");
            }
            else{
                Student s = studentMap.get(matricNo);
                String arr[] = newAccessPeriod.split("-");
                SimpleDateFormat parser = new SimpleDateFormat("dd/mm/yyyy HH:mm");
                Date opening = parser.parse(arr[0]);
                Date closing = parser.parse(arr[1]);
                LocalDateTime openingTime = LocalDateTime.ofInstant(opening.toInstant(),ZoneId.systemDefault());
                LocalDateTime closingTime = LocalDateTime.ofInstant(closing.toInstant(),ZoneId.systemDefault());
                LocalDateTime[] access = {openingTime,closingTime};
                s.setAccessPeriod(access);
                AllStudent.setMap(studentMap);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}