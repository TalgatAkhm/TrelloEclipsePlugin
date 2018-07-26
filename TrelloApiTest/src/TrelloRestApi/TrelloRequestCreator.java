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
	public static final String API_URL = "https://api.trello.com/1";
	public static final String API_KEY = "c4ecce1f80fefbb749052735a8a5dabd";
	public static final String LOCAL_TOKEN = "9ac12e523ffabce0bb114b5d2c962dad59d9a92a690c29600dc3774e86d59c22";
	public static final String REQUEST_ACCOUNT_DATA = "key=" + API_KEY + "&token=" + LOCAL_TOKEN;

	Requester requester;
	Gson gsonParser;
	String response;
	Type toListOfBoards;
	Type toListOfCards;
	Type toListOfBoardLists;

	public TrelloRequestCreator() {
		requester = new Requester();
		gsonParser = new Gson();
		toListOfBoards = new TypeToken<ArrayList<Board>>() {
		}.getType();
		toListOfCards = new TypeToken<ArrayList<Card>>() {
		}.getType();
		toListOfBoardLists = new TypeToken<ArrayList<BoardList>>() {
		}.getType();
	}

	public static String getApikey() {
		return API_KEY;
	}

	public List<Board> getAllBoards() {
		response = "";
		try {
			response = requester.run(API_URL + "/members/me/boards/all?" + REQUEST_ACCOUNT_DATA);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (response.length() == 0) {
			return null;
		}
		return gsonParser.fromJson(response, toListOfBoards);
	}

	public Board getCurrentBoardByName(String name) {
		return getAllBoards().parallelStream()
				.filter(Board -> Board.getName().equals(name))
				.collect(Collectors.toList())
				.get(0);
	}

	public List<BoardList> getBoardList(Board board) {
		response = "";
		try {
			response = requester.run(API_URL + "/boards/" + board.getId() + "/lists?" + REQUEST_ACCOUNT_DATA);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.length() == 0) {
			return null;
		}
		return gsonParser.fromJson(response, toListOfBoardLists);
	}

	public List<Card> getCards(BoardList list) {
		response = "";
		try {
			response = requester.run(API_URL + "/lists/" + list.getId() + "/cards?" + REQUEST_ACCOUNT_DATA);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (response.length() == 0) {
			return null;
		}

		return gsonParser.fromJson(response, toListOfCards);
	}
}
