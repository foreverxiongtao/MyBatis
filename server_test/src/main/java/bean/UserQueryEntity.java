package bean;

/**
 * Created by win 10 on 2017/9/6.
 */
public class UserQueryEntity {
    private  String name;
    private  int maxAge;
    private int minAge;

    public UserQueryEntity(String name, int maxAge, int minAge) {
        this.name = name;
        this.maxAge = maxAge;
        this.minAge = minAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
