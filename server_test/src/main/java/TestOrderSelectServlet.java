import bean.Order;
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
 * Created by xiongtao on 17/8/31.
 */
public class TestOrderSelectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        selectOrder(resp);
    }
    
    private void selectOrder(HttpServletResponse response){
        String resource = "config.xml";
        InputStream inputStream = null;
        try {
            inputStream = TestUserDeleteServlert.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            try {
//                Order insert = session.selectOne("com.mybatis.test.OrderMapper.orderSelect",1);
                Order insert = session.selectOne("com.mybatis.test.OrderMapper.orderSelect2",1);
                //设置响应内容类型
                response.setContentType("text/html");
                //设置逻辑实现
                PrintWriter out = response.getWriter();
                out.println("<h3>" + JSON.toJSONString(insert) + "</h3>");
            } finally {
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
