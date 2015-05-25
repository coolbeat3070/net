package api.net;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.naver.com");
			System.out.println("PORT :"+url.getPort());
			System.out.println("Default PORT :"+url.getDefaultPort());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
