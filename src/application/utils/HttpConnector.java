package application.utils;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import application.dto.EventResultMessage;

public class HttpConnector {
	
	public static HttpConnector instance = null;

	public static HttpConnector getInstance() {
		if (instance == null) {
			instance = new HttpConnector();
		}
		return instance;
	}

	
	public EventResultMessage<CloseableHttpResponse, String> send(URI uri) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse res = null;
		String message = "";

		try{
		
			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader("Content-type", "application/json");
			httpGet.setURI(uri);

			res = httpclient.execute(httpGet);

		} catch(Exception e) {
			res = null;
			message = e.getMessage();
			e.printStackTrace();
		}finally{
			try {
				httpclient.close();
			} catch (IOException e) {
				message = e.getMessage();
				e.printStackTrace();
			}
		}
	
		return new EventResultMessage<CloseableHttpResponse, String>(res, message);
	}
}
