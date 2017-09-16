//package z.关于JDNI与JUNIT整合办法;
//
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.mock.jndi.SimpleNamingContextBuilder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.naming.NamingException;
//
///**
//  *
//  * @author hepeixiao
//  * @date 2016年10月19日下午3:41:00
//  *
//  */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath*:spring-*.xml")
//public class BaseTest {
////
////	@Rule
////	private ExpectedException ex = ExpectedException.none();
//
//	@BeforeClass
//	public static void init(){
//		final String bindprefix = "java:comp/env/";
//
//		DriverManagerDataSource dm = new DriverManagerDataSource();
//		dm.setDriverClassName("com.mysql.jdbc.Driver");
//		dm.setUrl("jdbc:mysql://192.168.1.197:3306/size001?useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull");
//		dm.setPassword("123456");
//		dm.setUsername("root");
//
//		SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
////		builder.bind(bindprefix+"size/redis/host", "127.0.0.1");
////		builder.bind(bindprefix+"size/redis/port", "6379");
////		builder.bind(bindprefix+"size/redis/password", "123456");
////		builder.bind(bindprefix+"size/redis/maxtotal", "1000");
////		builder.bind(bindprefix+"size/redis/maxidle", "200");
//		builder.bind(bindprefix+"jdbc/size001", dm);
//
//		System.setProperty("size/redis/host", "127.0.0.1");
//		System.setProperty("size/redis/port", "6379");
//		System.setProperty("size/redis/password", "123456");
//		System.setProperty("size/redis/maxtotal", "1000");
//		System.setProperty("size/redis/maxidle", "200");
//
//		try {
//			builder.activate();
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//
//
//	}
//
//
//}
