package z.文章优化;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-07 16:17
 **/
public class Text_2 {
    private static String[] illegals = {"点击阅读", "阅读原文", "猛戳", "图片摘自", "转载", "本文来自", "本文选自", "出处：", "出处:", "微信：", "更多精彩", "投稿", "点击加入", "点击上方", "点击下方", "参考来源", "微信平台", "点击关注", "微信号", "来源：", "来源:", "公众号", "网址", "文本版权", "本文来源", "链接：", "链接:", "原文：", "作者:", "作者：", "热文推荐", "源文链接", "图片来源"};

    private static String path = Text_2.class.getClass().getResource("/").getPath();

    private static String PIC_URL_PREFIX = "http://static.poinetech.com/cms";

    private static String mysql_url = "jdbc:mysql://192.168.1.197:3306/size001?characterEncoding=UTF-8";

    private static String mysql_user = "root";

    private static String mysql_pswd = "123456";

    public static void doClear() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_pswd);
            Statement statement = connection.createStatement();
            Class.forName("com.mysql.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM t_article  WHERE c_id ='016db49ba2ef4aec960bfbf90bf3589c' ORDER  BY  c_createtime DESC limit  0,1");
            String content = "";
            while (resultSet.next()) {
                content = resultSet.getString("c_content");
            }
            Document doc = Jsoup.parse(content);
            String coverimg = null;
            System.out.println(doc.getElementsByTag("img"));

//            System.out.println(doc.text());
//          coverimg = hidden(doc);
            recoverd(doc);
            /*更新优化之后的文章*/
            PreparedStatement preparedStatement;
            if (null == coverimg) {
                preparedStatement = connection.prepareStatement("UPDATE t_article SET  c_content =  ? , c_fix = 0 WHERE c_id = '016db49ba2ef4aec960bfbf90bf3589c'");
            } else {
                preparedStatement = connection.prepareStatement("UPDATE t_article SET  c_content =  ? , c_coverimgurl = ?,c_fix = 0 WHERE c_id = '016db49ba2ef4aec960bfbf90bf3589c'");
            }
            preparedStatement.setString(1, doc.toString());
            if (null != coverimg) {
                preparedStatement.setString(2, coverimg);
            }
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static String DISPLAYNONE = "display:none;";

    /**
     * 恢复文章
     *
     * @param document
     */
    private static void recoverd(Document document) {


        Elements elements = document.getAllElements();
        for (Element element : elements) {
            element.attr("hidden", false);
            element.attr("style", element.attr("style").replace(DISPLAYNONE, ""));
        }
        System.out.println("恢复完成");
    }


    private static boolean contentMainStyle(Element element, String mainStyle) {
        return element.toString().contains(mainStyle);
    }

    /**
     * * 返回推荐封面图
     *
     * @param doc 文章主体doc 对象
     * @return 推荐封面图
     */
    private static String hidden(Document doc) {

        /*推荐封面图*/
        String coverImgUrl = null;

        /*是否存在非法元素 如果判断是非法文章，无条件隐藏文字的第一张图片*/
        boolean illagal = false;

        Elements elements = doc.getAllElements();

        String mainStyle = getMainStyle(doc);

        /*方法二============================================================================*/
        List<Element> eList = new ArrayList<>();
        List<Integer> childNumList = new ArrayList<>();

        Element topElement = null;
        int topNum = 0;
        /*求出子元素最多的元素*/
        for (Element e : elements) {
            int tempNum = e.childNodes().size();
            if (tempNum > topNum) {
                topElement = e;
                topNum = tempNum;
            }
        }
        Elements childrenElements = topElement.children();
        int startIndex = -1;
        int endIndex = -1;
        int size = childrenElements.size();
        boolean isMainAppear = false;
        for (int i = 0; i < childrenElements.size(); i++) {
            /*判断是否已经出现过*/
            if (!isMainAppear) {
                isMainAppear = contentMainStyle(childrenElements.get(i), mainStyle);
            }
            if (valid(childrenElements.get(i), i, size)) {
                if (!isMainAppear) {
                    startIndex = i;
                } else {
                    endIndex = i;
                }
            }


        }
           /*优化主体前部分*/
        for (int i = startIndex; i >= 0; i--) {
            childrenElements.get(i).attr("hidden", true);
        }

        /*优化文章主体后部分*/
        for (int i = endIndex; i < childrenElements.size(); i++) {
            childrenElements.get(i).attr("hidden", true);

        }

        /*优化文章中间部分*/
        for (int i = startIndex; i < endIndex; i++) {
            boolean flag = valid(childrenElements.get(i), i, childrenElements.size());
            if (flag) {
                illagal = true;
                childrenElements.get(i).attr("hidden", true);
            }
        }

        /*处理文章开图是是图片问题
        * 如果判断是自动上传的文章，
        * 那么再如果在正文开始前第一张就是图片，
        * 那么，隐藏图片
        * */

        if (illagal) {
            String src = childrenElements.get(0).attr("src");
            if (src != null && !src.equals("")) {
                childrenElements.get(0).attr("hidden", true);
            }
        }
        /*============================================================================*/

        /*处理封面图问题 从文章主体部分去一张最大的非二维码图片*/
        {
            long maxCoverLenght = 0;
            StringBuffer maxCoverUrl = null;
            for (int i = startIndex; i < endIndex; i++) {
                Elements imgElements = childrenElements.get(i).getElementsByTag("img");
                for (Element e : imgElements) {
                    String url = e.attr("src");
                    if (url != null && !url.equals("")) {
                        String imgPath = downloadImg(url);
                        boolean isQR = GucasQRCodeDecoder.isQR(imgPath);
                    /*如果不是二维码*/
                        if (!isQR) {
                            File file = new File(imgPath);
                            long currentCoverLenght = file.length();
                            if (currentCoverLenght > maxCoverLenght) {
                                maxCoverLenght = currentCoverLenght;
                                maxCoverUrl = new StringBuffer(url);
                            }
                        }
                    }
                }
            }
            if (null != maxCoverUrl) {
                coverImgUrl = maxCoverUrl.toString();
            }
        }
        /*去除带二维码部分*/
        Elements imgElements = doc.getElementsByTag("img");
        for (Element e : imgElements
                ) {
            String url = e.attr("src");
            if (url != null) {
                boolean isQR = GucasQRCodeDecoder.isQR(downloadImg(url));
                if (isQR) {
                    e.attr("hidden", true);
                }
            }
        }
        coverImgUrl = coverImgUrl.replace("http://static.poinetech.com/cms", "");
        return coverImgUrl;
    }


    /**
     * 传入 url 下载图片到缓存位置
     *
     * @param url 路径
     * @return 图片路径
     */
    private static String downloadImg(String url) {
        try {
            DownLoadUtil.downLoadFromUrl(url, getFileName(url), path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path + getFileName(url);

    }

    /**
     * 获取主要的style样式
     *
     * @param document 当前对象
     * @return 主要的样式String字符串
     */
    private static String getMainStyle(Document document) {
        Elements elements = document.getAllElements();
        /*记录所有出现过的style*/
//        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");

        Map<String, Integer> styleMap = new HashMap<>();
        for (Element element : elements) {
            String style = element.attr("style");
            if (null != style && !style.equals("")) {
                if (styleMap.containsKey(style)) {
                    styleMap.put(style, styleMap.get(style) + 1);
                } else {
                    styleMap.put(style, 1);
                }
            }
        }
//        int maxTime = 0;
        return isLegal(document, styleMap);
    }

    //TODO==求出主体部分的style
    private static String isLegal(Document document, Map<String, Integer> map) {
        String finalStyleString = "";
        Integer finalStyleInteger = 0;
        OK:
        {
            if (map.keySet().size() == 0) {
                throw new RuntimeException("无法定位文章主体");
            }
            for (String string : map.keySet()
                    ) {
                Integer tempInteger = map.get(string);
                if (tempInteger > finalStyleInteger) {
                    finalStyleInteger = tempInteger;
                    finalStyleString = string;
                }
            }
            Elements elements = document.getElementsByAttributeValue("style", finalStyleString);
            int charNum = 0;
            for (Element e : elements
                    ) {
                charNum += getUTFCharNum(e);
            }
            if (charNum < 100) {
                map.remove(finalStyleString);
                finalStyleInteger = 0;
                finalStyleString = "";
                break OK;
            }
        }
        return finalStyleString;
    }

    /**
     * 获取该标签下中文字符数量
     *
     * @param element element 对象
     * @return 中文字符数量
     */

    private static int getUTFCharNum(Element element) {
        int number = 0;
        String pString = element.ownText();
        number += pString.length();
//        if (element.getAllElements().size() != 0) {
//            for (Element e : element.getAllElements()
//                    ) {
//                number += getUTFCharNum(e);
//            }
//        }
        return number;
    }

    /**
     * 返回 true 说明非法 false 合法
     *
     * @param element  p 标签元素
     * @param position 第几个p标签
     * @return true 说明非法 false 合法
     */
    private static boolean valid(Element element, int position, int lenght) {
        Elements elements = element.getElementsByTag("img");
        if (position == 0 && null != elements) {
            return true;
        }
        /*隐藏最后一张图片*/
        if (position == lenght - 1) {
            if (element.toString().trim().contains("http://static.poinetech.com/cms")) return true;
        }
        /*判断是否包含非法字符*/
        for (String illegal : illegals
                ) {
            if (element.toString().contains(illegal)) {
                return true;
            }
        }
        /*判断是否包二维码含图片*/
        if ((elements != null ? elements.size() : 0) != 0) {
            for (Element e : elements
                    ) {
                String url = e.attr("src");

                try {
                    /*缓存图片*/
                    DownLoadUtil.downLoadFromUrl(url, getFileName(url), path);
                    //TODO==验证下载下来的图片是否包含二维码
                    return GucasQRCodeDecoder.isQR(path);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return false;
    }


    private static String getFileName(String url) {
        int startIndex = url.lastIndexOf(".");
        int urlLenght = url.length();
        String fileName = url.substring(startIndex, urlLenght);
        return "temp" + fileName;
    }

    public static void main(String[] args) {
        doClear();
//        File file = new File("E:\\1.gif");
//        System.out.println(file.length());
//        String s = "往期回顾";
//        System.out.println(s.contains("往期回顾"));

    }


}
