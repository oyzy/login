
public class LoginService {

    public LoginService() {
    }

    public boolean login(String name, String password){
        final String name1 = "jyt";
        final String password1 = "123456";
        if (name1.equals(name) && password1.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
