import bean.Course;
import bean.User;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by xiongtao on 17/9/1.
 */
public class TestClassesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        queryClasses(resp);
    }

    private void queryClasses(HttpServletResponse response) {
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserDeleteServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            session.clearCache();
//                Order insert = session.selectOne("com.mybatis.test.OrderMapper.orderSelect",1);
//                Cls classes = session.selectOne("com.mybatis.test.ClsMapper.selectClass", 1);
            Course teacher = session.selectOne("com.mybatis.test.CourseMapper.selectCourse2", 1);
            //设置响应内容类型
            response.setContentType("text/html");
            //设置逻辑实现
            PrintWriter out = response.getWriter();
//                out.println("<h3>" + JSON.toJSONString(classes) + "</h3>\n");
            out.println("<h3>" + JSON.toJSONString(teacher) + "</h3>");
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
