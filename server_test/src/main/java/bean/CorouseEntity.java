package bean;

/**
 * Created by win 10 on 2017/9/6.
 */
public class CorouseEntity {
    private int code;
    private String meg;
    private Corouse result;

    public CorouseEntity(int code, String meg, Corouse result) {
        this.code = code;
        this.meg = meg;
        this.result = result;
    }

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

    public Corouse getResult() {
        return result;
    }

    public void setResult(Corouse result) {
        this.result = result;
    }
}
