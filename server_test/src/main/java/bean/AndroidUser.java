package bean;

import java.util.List;

/**
 * Created by win 10 on 2017/9/5.
 */
public class AndroidUser {
    private int code;
    private String meg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMeg() {
        return meg;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }

    public List<UserDataEntity> getResult() {
        return result;
    }

    public void setResult(List<UserDataEntity> result) {
        this.result = result;
    }

    private List<UserDataEntity> result;
}
