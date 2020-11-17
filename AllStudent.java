import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllStudent implements FileHandle{
    private static Map<String, Student> studentMap;
    public AllStudent(){}

    public static List readSerializedObject(String filename){
        return FileHandle.readSerializedObject(filename);
    }
    public static void serializeToFile() {
        try {
            if (studentMap != null) {
                FileOutputStream fileOut =
                        new FileOutputStream("studentInfo.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(studentMap);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in studentInfo.ser");
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static void deserializeFromFile() {
        try {
            FileInputStream fin=new FileInputStream("studentInfo.ser");
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

    public static Map<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }
}
