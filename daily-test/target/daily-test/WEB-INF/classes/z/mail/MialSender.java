package z.mail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/2/24.
 */
public class MialSender {


//        private static final String sendUserName = "coo1943@126.com";// 发送邮件需要连接的服务器的用户名
//
//        private static final String sendPassword = "252621820";// 发送邮件需要连接的服务器的密码
//
//        private static final String sendProtocol = "smtp";// 发送邮件使用的端口
//
//        private static final String sendHostAddress = "smtp.126.com";// 发送邮件使用的服务器的地址
//
//        public static void test() throws AddressException, MessagingException {
//
//            Properties properties = new Properties();
//            properties.setProperty("mail.smtp.auth", "true");// 服务器需要认证
//            properties.setProperty("mail.transport.protocol", sendProtocol);// 声明发送邮件使用的端口
//            properties.setProperty("mail.host", sendHostAddress);// 发送邮件的服务器地址
//
//            Session session = Session.getInstance(properties, new Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(sendUserName, sendPassword);
//                }
//            });
//            session.setDebug(true);//在后台打印发送邮件的实时信息
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(sendUserName));
//            message.setSubject("Demo2JavaCode发送邮件测试，采用Authenticator");// 设置主题
//            message.setRecipients(Message.RecipientType.TO, InternetAddress
//                    .parse("zhangzh@poinetech.com"));// 发送
//            message.setRecipients(Message.RecipientType.CC, InternetAddress
//                    .parse("msn_wangxiangpan@hotmail.com"));// 抄送
//            message
//                    .setContent(
//                            "<span style=\"font-size:20px; color:#FFCCFF\" mce_style=\"font-size:20px; color:#FFCCFF\">如果您看到，证明测试成功了！</span>",
//                    "text/html;charset=gbk");
//
//            Transport.send(message);//发送邮件
//        }

//    public static void main(String[] args) {
//        try {
//            test();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }


}
