package z.xmlUtil;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/3/6.
 */
public interface IXmlUtil {

    /**
     * 建立xml文档
     * @param fileName
     */
     void createXml(String fileName);

    /**
     * 读取xml文档
     * @param fileName
     */
    void parserXml(String fileName);

}
