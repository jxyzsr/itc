import com.jzlw.itc.domain.User;
import com.jzlw.itc.service.IHeadpictureService;
import com.jzlw.itc.service.ITrashcanService;
import com.jzlw.itc.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testspring_headpicture {
    @Test
    public void test1(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IHeadpictureService service=ac.getBean("headpictureServiceimpl", IHeadpictureService.class);
        int a = 4;
        String padress = "D:/itc/photo";
        service.insertahp(a,padress);
    }
    @Test
    public void test2(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IHeadpictureService service=ac.getBean("headpictureServiceimpl", IHeadpictureService.class);
        int a = 4;
        String padress = "D:/itc/photo/123131.jpg";
        service.updateahp(a,padress);
    }
    @Test
    public void test3(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        ITrashcanService service=ac.getBean("trashcanServiceimpl", ITrashcanService.class);
        service.selecttrashcan();
    }
}
