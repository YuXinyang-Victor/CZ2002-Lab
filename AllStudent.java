import java.util.List;
import java.util.Map;

public class AllStudent implements FileHandle{
    private static Map<String, Course> studentMap;
    public AllStudent(){}

    public static List readSerializedObject(String filename){
        return FileHandle.readSerializedObject(filename);
    }
}
