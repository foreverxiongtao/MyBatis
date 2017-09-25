import bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win 10 on 2017/9/25.
 */
public class MySpringTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MyTest mycts = (MyTest) context.getBean("myTest");
        String test = mycts.test();
        User user = (User) context.getBean("user");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(test);
        resp.getWriter().write(user.toString());
    }

}
