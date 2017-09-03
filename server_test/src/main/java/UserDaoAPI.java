import bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 采用注解的方式来完成,需要到config.xml中采用class的方式去进行注册
 */
public interface UserDaoAPI {

    @Insert("insert into Users(name,age) values(#{name},#{age})")
    int addUser(User user);

    @Update("update Users set name=#{name},age=#{age} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from Users where id=#{id}")
    int delteUser(int id);

    @Select("select * from Users where id=#{id}")
    User findUserById(int id);

    @Select("select * from Users ")
    List<User> findAllUsers();
}
