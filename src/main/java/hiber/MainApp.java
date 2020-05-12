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

      userService.add(new User.Builder()
              .withFirstName("User1")
              .withLastName("Lastname1")
              .withEmail("user1@mail.ru")
              .withCar(new Car.Builder()
                      .withName("Car1")
                      .withSeries(1)
                      .build())
              .build());
      userService.add(new User.Builder()
              .withFirstName("User2")
              .withLastName("Lastname2")
              .withEmail("user2@mail.ru")
              .withCar(new Car.Builder()
                      .withName("Car2")
                      .withSeries(2)
                      .build())
              .build());
      userService.add(new User.Builder()
              .withFirstName("User3")
              .withLastName("Lastname3")
              .withEmail("user3@mail.ru")
              .withCar(new Car.Builder()
                      .withName("Car3")
                      .withSeries(3)
                      .build())
              .build());
      userService.add(new User.Builder()
              .withFirstName("User4")
              .withLastName("Lastname4")
              .withEmail("user4@mail.ru")
              .withCar(new Car.Builder()
                      .withName("Car4")
                      .withSeries(4)
                      .build())
              .build());

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }
      System.out.println(userService.getUserOfNameOrSeries("Car2",2).getFirstName());

      context.close();
   }
}
