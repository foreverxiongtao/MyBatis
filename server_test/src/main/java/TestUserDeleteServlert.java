import bean.User;
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
 * Created by xiongtao on 17/8/30.
 */
public class TestUserDeleteServlert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        deleteUser(resp);
    deleteUserAPI(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    private void deleteUser(HttpServletResponse response) {
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserDeleteServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            try {
                int insert = session.delete("com.mybatis.test.UserMapper.deleteUser","jakeworton");
                //设置响应内容类型
                response.setContentType("text/html");
                //设置逻辑实现
                PrintWriter out = response.getWriter();
                out.println("<h3>" + insert + "</h3>");
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteUserAPI(HttpServletResponse response) {
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserDeleteServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            try {
                UserDaoAPI mapper = session.getMapper(UserDaoAPI.class);
                int delete = mapper.delteUser(12);
                //设置响应内容类型
                response.setContentType("text/html");
                //设置逻辑实现
                PrintWriter out = response.getWriter();
                out.println("<h3>" + delete + "</h3>");
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
