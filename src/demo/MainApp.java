package demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 调用java类示例
 */
public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj = context.getBean("helloWorld", HelloWorld.class);
      obj.getMessage();
      //为Spring容器注册关闭钩子
      ((AbstractApplicationContext) context).registerShutdownHook();
   }
}