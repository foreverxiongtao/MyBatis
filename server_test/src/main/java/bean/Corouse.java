package bean;

import java.util.List;

/**
 * Created by win 10 on 2017/9/6.
 */
public class Corouse {
    private int id;
    private String corouseName;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorouseName() {
        return corouseName;
    }

    public void setCorouseName(String corouseName) {
        this.corouseName = corouseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
