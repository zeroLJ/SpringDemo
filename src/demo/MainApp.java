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
      
//      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      HelloWorld obj = context.getBean("helloWorld", HelloWorld.class);
      obj.getMessage();
      ((AbstractApplicationContext) context).registerShutdownHook();
	   
   }
}