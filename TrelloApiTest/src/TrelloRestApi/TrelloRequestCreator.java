package TrelloRestApi;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Board;
import model.BoardList;
import model.Card;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TrelloRequestCreator {
	public static final String apiUrl = "https://api.trello.com/1";
	public static final String apiKey = "c4ecce1f80fefbb749052735a8a5dabd";
	public static final String localToken = "9ac12e523ffabce0bb114b5d2c962dad59d9a92a690c29600dc3774e86d59c22";
	public static final String requestAccountParams = "key=" + apiKey + "&token=" + localToken;

	Requester requester;
	Gson gsonParser;
	String response;

	public TrelloRequestCreator() {
		requester = new Requester();
		gsonParser = new Gson();
	}

	public static String getApikey() {
		return apiKey;
	}

	public List<Board> getAllBoards() {
		response = "";
		try {
			response = requester.run(apiUrl + "/members/me/boards/all?" + requestAccountParams);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (response.length() == 0) {
			return null;
		}
		return gsonParser.fromJson(response, new TypeToken<ArrayList<Board>>() {
		}.getType());
	}

	public Board getCurrentBoardByName(String name) {
		return getAllBoards().stream().filter(Board -> Board.getName().equals(name)).collect(Collectors.toList())
				.get(0);
	}

	public List<BoardList> getBoardList(Board board) {
		response = "";
		try {
			response = requester.run(apiUrl + "/boards/" + board.getId() + "/lists?" + requestAccountParams);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(response.length()==0) {
			return null;
		}
		return gsonParser.fromJson(response, new TypeToken<ArrayList<BoardList>>() {
		}.getType());
	}
	
	public List<Card> getCards(BoardList list){
		response = "";
		try {
			response = requester.run(apiUrl + "/lists/" + list.getId() + "/cards?"
					+ requestAccountParams);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(response.length()==0) {
			return null;
		}
		
		return gsonParser.fromJson(response, new TypeToken<ArrayList<Card>>() {
		}.getType());
	}
}
