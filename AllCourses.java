public class  AllCourse {
    private static Map<String, Course> map;
    public AllCourse() {}
    
    public static void serializeToFile() {
        try {
            if (map != null) {
                FileOutputStream fileOut =
                    new FileOutputStream("courseInfo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in courseInfo.ser");
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    public static void deserializeFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("courseInfo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (Map<String, Course>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            map = new HashMap<String, Course>();
        } catch (ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
    
    public static Map<String, Course> getMap() {
        return map;
    }
    
    public static void setMap(Map<String, Course> map) {
        this.map = map;
    }
    
}
