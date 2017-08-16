package z.今日头条内容抓取;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-12 16:01
 **/
public class CatchNews {

    public static void main(String[] args) {
        try {
           String result =  RequestUtil.request("http://www.toutiao.com/group/6431048671987482882","GET","","");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
