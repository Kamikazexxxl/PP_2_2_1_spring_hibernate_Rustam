package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Ivan", "Ivanov", "user1@mail.ru",new Car("BMW",1)));
      userService.add(new User("Petr", "Petrov", "user2@mail.ru",new Car("AUDI",2)));
      userService.add(new User("Magomed", "Magomedov", "user3@mail.ru",new Car("LADA",3)));
      userService.add(new User("John", "Johnson", "user4@mail.ru",new Car("MERCEDES",4)));
//      Car car1=new Car("qwe",1);
//      Car car2=new Car("qwer",2);
//      Car car3=new Car("qwert",3);
//      Car car4=new Car("qwerty",4);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
      }
      System.out.println(userService.userCar("LADA",3));
      context.close();
   }
}
