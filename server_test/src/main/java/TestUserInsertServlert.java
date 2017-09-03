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
import java.util.List;

/**
 * Created by xiongtao on 17/8/30.
 */
public class TestUserInsertServlert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        insertUser(resp);
        insertUserByAPI(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    private void insertUser(HttpServletResponse response) {
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserInsertServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            try {
                int insert = session.insert("com.mybatis.test.UserMapper.addUser", new User("zhanghongy", 28));
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


    private void insertUserByAPI(HttpServletResponse response) {
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserInsertServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            UserDaoAPI mapper = session.getMapper(UserDaoAPI.class);
            try {
                int insert = mapper.addUser(new User("xiongtao", 20));
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


}
