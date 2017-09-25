import bean.AndroidUser;
import bean.User;
import bean.UserDataEntity;
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
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by xiongtao on 17/8/30.
 */
public class TestUserListServlert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //设置响应内容类型
//        resp.setContentType("text/html");
////设置逻辑实现
//        PrintWriter out = resp.getWriter();
//        out.println("<h3>" + "jay" + "</h3>");

        queryUser(resp);
//        queryUserAPI(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    private void queryUser(HttpServletResponse response) {
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserListServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                AndroidUser androidUser = new AndroidUser();
                androidUser.setCode(0);
                androidUser.setMeg("查询成功");
                List<UserDataEntity> user = session.selectList("com.mybatis.test.UserMapper.selectUserList");
                androidUser.setResult(user);
                //设置响应内容类型
                response.setContentType("text/plain");
                response.setCharacterEncoding("utf-8");
                //设置逻辑实现
                PrintWriter out = response.getWriter();
                String userStr = JSON.toJSONString(androidUser);
                out.println(userStr);
//                out.println("<h3>" + userStr + "</h3>");
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void queryUserAPI(HttpServletResponse response) {
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserListServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                UserDaoAPI mapper = session.getMapper(UserDaoAPI.class);
                List<User> user = mapper.findAllUsers();
                //设置响应内容类型
                response.setContentType("text/html");
                //设置逻辑实现
                PrintWriter out = response.getWriter();
                String userStr = JSON.toJSONString(user);
                out.println("<h3>" + userStr + "</h3>");
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
