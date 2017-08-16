package z.xmlUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/3/6.
 */
public class XmlUtil implements IXmlUtil {

    private Document document;


    public void init() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.newDocument();
        } catch (Exception e) {
        }
    }

    @Override
    public void createXml(String fileName) {
        Element root = this.document.createElement("scores");
        this.document.appendChild(root);

        Element employee = this.document.createElement("employee");
        Element name = this.document.createElement("name");
        name.appendChild(this.document.createTextNode("wangchenyang"));
        employee.appendChild(name);
        Element sex = this.document.createElement("sex");
        sex.appendChild(this.document.createTextNode("m"));
        employee.appendChild(sex);
        Element age = this.document.createElement("age");
        age.appendChild(this.document.createTextNode("26"));
        employee.appendChild(age);
        root.appendChild(employee);
        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);
            System.out.println("生成XML文件成功！");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void parserXml(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);

            NodeList emloyees = document.getChildNodes();
            for (int i = 0; i < emloyees.getLength(); i++) {
                Node employee = emloyees.item(i);
                NodeList employeeInfo = employee.getChildNodes();
                for (int j = 0; j < employeeInfo.getLength(); j++) {
                    Node node = employeeInfo.item(j);
                    NodeList employeeMate = node.getChildNodes();
                    for (int k = 0; k < employeeMate.getLength(); k++) {
                        System.out.println(employeeMate.item(k).getNodeName() + ":" + employeeMate.item(k).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        XmlUtil dd = new XmlUtil();
        String string = "E://grade.xml";
        dd.init();
        dd.createXml(string);
        dd.parserXml(string);
    }
}
