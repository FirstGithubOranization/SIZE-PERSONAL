package z.imgs;

import java.io.*;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/2/21.
 */
public class DownLoadTest {

    public static void main(String[] args) {
        String txtPath = "F:\\imgs.txt";
        File file =new File(txtPath);
        int i = 0 ;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null) {//使用readLine方法，一次读一行
                try {
                    //判断url是否需要加前缀
                    System.out.println("第" + i + "个文件");
                    String url;
                    i++;
                    if (s.contains("http://")) {
                        url = s;
                    } else {
                        url = "http://static.poinetech.com/cms" + s;
                    }
                    DownLoadUtil.downLoadFromUrl(url, i + ".jpg", "F:\\img\\");
                }catch (Exception ex){
                    System.out.println("第" + i + "个文件下载失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
