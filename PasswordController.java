import java.util.List;

public class PasswordController {
    
    private List passwordList;

    public PasswordController(){
        Allpasswords.deserializeFromFile();
        passwordList = Allpasswords.getList();
    }

//-----------------for studentController and AdminController-----------------

    public boolean checkPassword(Password tobeChecked){
        for (Object pass: passwordList){
            Password p = (Password) pass;
            if (p.isEqual(tobeChecked))
                return true;
        }
        return false;
    }
}
