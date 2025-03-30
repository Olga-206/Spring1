import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());


        HelloWorld bean1 =
                (HelloWorld) applicationContext.getBean("helloworld");

        System.out.println(bean == bean1);

        Cat bean3 =
                (Cat) applicationContext.getBean("Cat");


        Cat bean4 =
                (Cat) applicationContext.getBean("Cat");

        System.out.println(bean3 == bean4);
    }
}

