import java.security.MessageDigest;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
class Password implements Serializable{
    // association with username 
    // encryption and checking takes place
    String hashed_pass;
    String username;

    public Password(){ this.hashed_pass = ""; this.username = "";}


    public Password(String username, String raw){
        this.username = username;
        this.hashed_pass = hash(raw);

    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.hashed_pass = hash(password);
    }


    private String hash(String raw){
        try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(raw.getBytes(StandardCharsets.UTF_8));
        return (bytesToHex(encodedhash));
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


    public boolean isEqual(Password p2){
        if (this.hashed_pass.compareTo(p2.hashed_pass) == 0 && (this.username.toUpperCase()).compareTo(p2.username.toUpperCase())==0)
            return true;
        else
            return false;
    }
    
}