import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws  UserNotFoundException, AccessDeniedExeption{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль ");
        String password = scanner.nextLine();

        User u = getUserByLoginAndPassword(login, password);

        validatedUser(u);

        System.out.println(" все супер доступ предоставлен");
    }

    public static User[] getUser(){
        User user = new User ("nic", "1111", "nic.@.com", 30);
        User user1 = new User ("maic", "2222", "maic.@.com", 13);
        User user2 = new User ("sara", "3333", "sara.@.com", 15);
        User user3 = new User ("chip", "4444", "chip.@.com", 35);
        User [] users = {user, user1, user2, user3};
        return users;
    }

    public static User getUserByLoginAndPassword (String login, String password) throws UserNotFoundException{
        User [] users = getUser();
        for ( User us : users){
            if (us.getLogin().equals(login) && us.getPassword().equals(password)){
                System.out.println(" Пользователь найден ");
                return us;
            }
        }
        throw new UserNotFoundException("Пользователя с таким логином и паролем нет");
    }

    public static void validatedUser (User user) throws AccessDeniedExeption{
        if (user.getAge() >= 18){
            System.out.println("Доступ разрешен , тебе " + user.getAge()+ " лет");
        } else {
            throw new AccessDeniedExeption(" Тебе еще мало лет ");
        }
    }
}
