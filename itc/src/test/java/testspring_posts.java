import com.jzlw.itc.domain.Posts;
import com.jzlw.itc.service.IPostsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testspring_posts {
    @Test
    public void test1(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IPostsService service=ac.getBean("postsServiceimpl", IPostsService.class);
        Posts posts = new Posts("测试2","ceshi","qweqwe",2);
        service.insertaposts(posts);
    }
    @Test
    public void test2(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        IPostsService service=ac.getBean("postsServiceimpl", IPostsService.class);
        int id = 3;
        int userid = 2;
        service.deleteaposts(3,2);
    }
}
