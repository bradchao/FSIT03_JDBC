import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GiftExample {

	public static void main(String[] args) {
		String strUrl = "http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx";
		String json = getJSONString(strUrl);
	}
	
	private static String getJSONString(String strUrl){
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream())) ;
			String line = null;
			while ( (line = reader.readLine()) != null){
				sb.append(line);
			}
			reader.close();
			System.out.println(sb);
		} catch (Exception e) {
			System.out.println(e);
		}
		return sb.toString();
	}
	

}
