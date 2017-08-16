package z.文章优化;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import jp.sourceforge.qrcode.QRCodeDecoder;
import  jp.sourceforge.qrcode.data.QRCodeImage;

public class GucasQRCodeDecoder {
    public GucasQRCodeDecoder() {

    }

    /**
     * decode qrcode image.
     * @param qrcodePicfilePath
     * @return decoding value.
     */
    public static String decode(String qrcodePicfilePath) {
        /* 读取二维码图像数据 */
        File imageFile = new File(qrcodePicfilePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Decoding failed, read QRCode image error: " + e.getMessage());
            return null;
        }
        /*
        try {
            String decodedData = new String(decoder.decode(new J2SEImageGucas(image)), "GBK");
            System.out.println(decodedData);
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */
        /* 解二维码 */
        QRCodeDecoder decoder = new QRCodeDecoder();
        String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
        return decodedData;
    }

    /**
     *  判断指定路径下的图片是不是二维码
     *
     * @param path
     * @return true 包含二维码  false 不包含二维码
     */
    public static boolean  isQR(String path){
        QRCodeDecoder decoder = new QRCodeDecoder();
        File imageFile = new File(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
            String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isQR("C:\\Users\\Administrator\\Desktop\\SIZE1.0\\size-service-cms\\size-service-cms\\target\\size-service-cms\\WEB-INF\\classes\\temp.jpeg"));
//        QRCodeDecoder decoder = new QRCodeDecoder();
//        File imageFile = new File("http://hi.csdn.net/attachment/201201/6/0_13258325299J8D.gif");
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(imageFile);
//        } catch (IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        System.out.println("识别二维码");

        /*
        try {
            String decodedData = new String(decoder.decode(new J2SEImageGucas(image)), "GBK");
            System.out.println(decodedData);
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */

//        String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
//        System.out.println(decodedData);

    }
}

class J2SEImageGucas implements QRCodeImage {
    BufferedImage image;

    public J2SEImageGucas(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getPixel(int x, int y) {
        return image.getRGB(x, y);
    }
}