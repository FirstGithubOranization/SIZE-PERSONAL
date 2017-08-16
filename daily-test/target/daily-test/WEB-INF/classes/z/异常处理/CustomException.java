package z.异常处理;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/3/3.
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -7398268583044812188L;



    public CustomException(String message) {
        super(message);
    }


    public static void main(String[] args) {

        throw new CustomException("aa");

    }
}
