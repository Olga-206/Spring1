package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
@Component
public class MainApp {
   @Autowired
   private UserService userService;
   @Autowired
   private UserDao userDao;
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car();
      car1.setModel("Tesla Model S");
      car1.setSeries(100);
      userService.add(car1);

      Car car2 = new Car();
      car2.setModel("BMW X5");
      car2.setSeries(3);

      Car car3 = new Car();
      car3.setModel("Audi A6");
      car3.setSeries(4);

      Car car4 = new Car();
      car4.setModel("Toyota Camry");
      car4.setSeries(40);

      User user1 = new User();
      user1.setFirstName("Иван");
      user1.setLastName("Иванов");
      user1.setEmail("ivan@example.com");
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User();
      user2.setFirstName("Петр");
      user2.setLastName("Петров");
      user2.setEmail("petr@example.com");
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User();
      user3.setFirstName("Анна");
      user3.setLastName("Сидорова");
      user3.setEmail("anna@example.com");
      user3.setCar(car3);
      userService.add(user3);

      User user4 = new User();
      user4.setFirstName("Мария");
      user4.setLastName("Кузнецова");
      user4.setEmail("maria@example.com");
      user4.setCar(car4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      String model1 = "Tesla Model S";
      int series1 = 100;
      User userByCar = userService.getUserByCarModelAndSeries(model1, series1);


      if (userByCar != null){
         String uname = userByCar.getFirstName();
         System.out.println("Пользователь этой машины :" + uname );
      } else {

         System.out.println("Такого юзера нет, сорян");
      }

      context.close();
   }
}
