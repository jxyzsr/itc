import com.jzlw.itc.domain.User;
import com.jzlw.itc.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testspring_user {

    @Test
    public void test1(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service=ac.getBean("userServiceimpl", IUserService.class);
        User user = service.selectuserattribute(2);
        System.out.println(user);

    }
    @Test
    public void test2(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service=ac.getBean("userServiceimpl", IUserService.class);
        User user= service.selectoflogin("jxy","123");
        System.out.println(user);
    }
    @Test
    public void test3(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service=ac.getBean("userServiceimpl", IUserService.class);
        User user = new User();
        user.setAge("22");
        user.setUsername("test");
        user.setPassword("123");
        user.setSex("");
        user.setEmail("101@qq.com");
        service.insertauser(user);
    }
    @Test
    public void test4(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service=ac.getBean("userServiceimpl", IUserService.class);
        User user = new User();
        user.setId(6);
        user.setAge("22");
        user.setUsername("test");
        user.setPassword("111");
        user.setSex("男");
        user.setEmail("101101@qq.com");
        service.updateuser(user);
    }
}
