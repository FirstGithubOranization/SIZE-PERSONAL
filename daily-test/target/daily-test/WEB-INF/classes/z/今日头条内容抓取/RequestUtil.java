package z.今日头条内容抓取;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 
 * @author hepeixiao
 *
 */
public class RequestUtil {
	
	public static String getRequestContent(HttpServletRequest request) throws Exception{
		String result = null;
		InputStream in = request.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(in);
		
		final int readLen = 1024;
		byte[] bs = new byte[readLen];
		int currReadIndex = 1;
		
		byte[] out = new byte[readLen];
		
		while (bis.read(bs)!=-1) {
			out = Arrays.copyOf(bs, currReadIndex*readLen);
			currReadIndex++;
		}                                                       
		
		result += new String(out,Charset.forName("UTF-8"));
		return result ;
	}
	
	
	public static String request(String url , String method , String data,String token) throws Exception{
		String result = null;
		final int connectTimeOut = 120000;
		final int readTimeOut = 12000;
		
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setConnectTimeout(connectTimeOut);
		conn.setDefaultUseCaches(false);
		conn.setReadTimeout(readTimeOut);
		conn.setRequestMethod(method==null || "".equals(method.trim()) ?"GET":method);
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		conn.setRequestProperty("Accept-Charset", "utf-8");
		conn.addRequestProperty("token", token);
		
		if (data != null && !"".equals(data.trim())) {
			conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
			conn.setDoOutput(true);
			OutputStream out = conn.getOutputStream();
			out.write(data.getBytes(Charset.forName("UTF-8")));
			out.flush();
		}
		
//		conn.setDoInput(true);
		InputStream ins = conn.getInputStream();
		if(ins != null){
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
			String tmp = null;
			StringBuilder sb = new StringBuilder();
			while((tmp = reader.readLine())!=null){
				sb.append(tmp);
			}
			result = sb.toString();
			
		}
		//result = new String(result.getBytes(Charset.forName("UTF-8")));
		return result ;
	}
	
}
