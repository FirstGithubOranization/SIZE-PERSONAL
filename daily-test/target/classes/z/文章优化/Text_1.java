package z.文章优化;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.sql.*;
import java.util.*;


/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-06-02 9:58
 **/
public class Text_1 {


    private static String[] illegals = {"本文选自", "出处：", "出处:", "微信：", "更多精彩", "投稿", "点击加入", "点击上方", "点击下方", "参考来源", "微信平台", "点击关注", "微信号", "来源：", "来源:", "公众号", "网址", "文本版权", "本文来源", "链接：", "链接:", "原文：", "作者:", "作者：", "热文推荐", "源文链接"};

    private static String path = Text_1.class.getClass().getResource("/").getPath();

    private static String PIC_URL_PREFIX = "http://static.poinetech.com/cms";

    private static String mysql_url = "jdbc:mysql://192.168.1.197:3306/size001?characterEncoding=UTF-8";

    private static String mysql_user = "root";

    private static String mysql_pswd = "123456";

    public static void doClear() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(mysql_url, mysql_user, mysql_pswd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM t_article  WHERE  c_id = '80ec1fb492af4caebabe44b9eec591ea' ORDER  BY  c_createtime limit  0,1");
            String content = "";
            while (resultSet.next()) {
                content = resultSet.getString("c_content");
            }
            Document doc = Jsoup.parse(content);
            hidden(doc);


//            System.out.println(doc);
            /*更新优化之后的文章*/
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE t_article SET  c_content =  ? , c_fix = 1 WHERE c_id = '80ec1fb492af4caebabe44b9eec591ea'");
            preparedStatement.setString(1, doc.toString());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void hidden(Document doc) {

        Elements elements = doc.getElementsByTag("section");
        List<Node> nodes = doc.childNodes();

        for (Node node : nodes
                ) {
            validNode(node);
        }
        /*收留最后的有效行*/
        List<Integer> columnList = new ArrayList<>();
        /*收留所有有效的行数*/
        List<Integer> columnNumList = new ArrayList<>();

        /*显示的行数集合*/
        HashSet<Integer> finalSet = new HashSet<>();
        List<Set<Integer>> deleteList = new ArrayList<>();
        Integer finalNum = 0;

        HashSet<Integer> tempSet = new HashSet<>();
        Integer tempNum = 0;
        Integer deleteNum = 0;

        int size = elements.size();
        /*获取有用行数标示位置*/
        for (int i = 0; i < size; i++) {
            /*获取每一行中文字符数量*/
            columnNumList.add(i, getUTFCharNum(elements.get(i)));
            if (valid(elements.get(i), i, size)) {

            } else {
                columnList.add(i);
            }
        }
        /*使用冒泡算法，计算出可用的连续块*/
        int lastNum = 0;
        for (int j = 0; j < columnList.size(); j++) {
            //获取list中当前的有效行数编号
            int currentNum = columnList.get(j);
            /*如果有效行数是连续的*/
            if (currentNum - lastNum == 1) {
                tempSet.add(currentNum);
                tempNum += getUTFCharNum(elements.get(currentNum - 1));
            } else {
                if (finalNum < tempNum) {
                    System.out.println("即将去除的连续行数：" + finalNum);
                    finalNum = tempNum;
                    System.out.println("即将去除的行数字数：" + finalSet);
                    System.out.println(" ");
                    Iterator<Integer> iterator = tempSet.iterator();
                    while (iterator.hasNext()) {
                        finalSet.add(iterator.next());
                    }
                    System.out.println("目前finalSet：" + finalSet);
                    System.out.println("finalNum：" + finalNum);
                    System.out.println();

                } else {
                    /*记录隐藏掉的数据*/
                    deleteNum += tempNum;
                    deleteList.add(tempSet);
                }
                tempNum = 0;
                tempSet.clear();
            }
            /*将上一行的标号设置为当前的标号，进入下一次比较*/
            lastNum = currentNum;
        }

        /*额外计算清除数据是否过大*/
        {
            if (deleteNum >= finalNum / 2) {
                /*求出均值*/
                int limitNum = deleteNum / deleteList.size();
                /*大于limitNum的部分不进行处理 ， 但是广告部分依旧隐藏*/
                boolean flag = true;/*清楚最后部分*/
                for (int i = deleteList.size(); i > 0; i--) {
                    Set<Integer> recoverSet = deleteList.get(i - 1);
                    if (flag) {
                        int recoverNum = 0;
                        for (Integer col : recoverSet
                                ) {
                            recoverNum += getUTFCharNum(elements.get(col - 1));
                        }
                        if (recoverNum > limitNum) {
                            flag = false;
                            for (Integer aRecoverSet : recoverSet) {
                                finalSet.add(aRecoverSet);
                            }
                        }
                    } else {
                        for (Integer aRecoverSet : recoverSet) {
                            finalSet.add(aRecoverSet);
                        }
                    }
                }
            }
        }
        /*将不在finalSet中的<p>全部隐藏*/
        for (int i = 0; i < elements.size(); i++) {
            if (finalSet.add(i + 1)) {
                for (Element e : doc.getElementsByTag("p").get(i).getAllElements()
                        ) {
                    e.attr("hidden", true);
                }
//                for (Element e :doc.getElementsByTag("p").get(i).getElementsByTag("span")
//                        ) {
//                    e.attr("hidden", true);
//                }
            }
        }
    }

    /**
     * 获取该标签下中文字符数量
     *
     * @param element
     * @return
     */
    private static int getUTFCharNum(Element element) {
        int number = 0;
        String pString = element.ownText();
        number += pString.length();
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

    /**
     * 递归验证合法性
     *
     * @param node
     * @return
     */
    private static boolean validNode(Node node) {
        if (node.childNodeSize() == 0) {
            String nodeString = node.ownerDocument().ownText();
            System.out.println(nodeString);
            return false;
        } else {
            for (Node n : node.childNodes()
                    ) {
                validNode(n);
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

    }

}
