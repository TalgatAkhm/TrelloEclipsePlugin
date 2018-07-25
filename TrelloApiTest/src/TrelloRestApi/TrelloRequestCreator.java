package TrelloRestApi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TrelloRequestCreator {
	
	//codestyle
	public static final String apiUrl = "https://api.trello.com/1";
	public static final String apiKey = "c4ecce1f80fefbb749052735a8a5dabd";
	public static final String localToken = "9ac12e523ffabce0bb114b5d2c962dad59d9a92a690c29600dc3774e86d59c22";

	public static final String requestAccountParams = "key=" + apiKey + "&token=" + localToken;
	
	OkHttpClient client = new OkHttpClient();

	public String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}
	}

	public TrelloRequestCreator() {

	}

	public static String getApikey() {
		return apiKey;
	}

}
