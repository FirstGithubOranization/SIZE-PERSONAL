package z.获取视频时长;

import it.sauronsoftware.jave.DownLoadUtil;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.io.IOException;

public class ReadVideo {

    public static void main(String[] args){
        try {
            DownLoadUtil.downLoadFromUrl("http://static.poinetech.com/cms/static/upload/cmsweb/video/mp42016/11/26/d178e2c82b9447578153b3b40045c465.mp4","1.mp4","E:\\");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File source = new File("E:\\1.mp4");
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            System.out.println(ls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}