public class UserNotFoundException extends Exception{
    //неверный логин или пароль
    public UserNotFoundException (String message){
        super(message);
    }
}
