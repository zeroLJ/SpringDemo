package demo;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

/**
 * 监听Bean的创建
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	/**
	 * 对容器中的Bean实例进行后处理
	 * @param bean 需要进行后处理的原Bean实例
	 * @param beanName 需要进行后处理的Bean的配置id
	 * @return 返回后处理完成后的Bean
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeforeInitialization : " + beanName);
		return bean;  // you can return any other object as well
	}
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("AfterInitialization : " + beanName);
	    return bean;  // you can return any other object as well
	}
}