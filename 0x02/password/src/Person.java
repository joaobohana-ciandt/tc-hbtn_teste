package src;

public class Person {
    public boolean checkUser(String user){
        return user.matches("^[a-zA-Z0-9]{8,}$");
    }

    public boolean checkPassword(String password){
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
