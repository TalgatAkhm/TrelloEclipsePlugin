import TrelloRestApi.TrelloRequestCreator;
import model.Board;
import model.BoardList;
import model.Card;
import okhttp3.*;
import utils.ConsoleColors;

import java.io.Console;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("run");
		// OkHttpClient client = new OkHttpClient();
		// System.out.println(api.getResponsedBoard().getName());
		TrelloRequestCreator example = new TrelloRequestCreator();
		String response;
		try {
			response = example.run(TrelloRequestCreator.apiUrl + "/members/me/boards/all?"
					+ TrelloRequestCreator.requestAccountParams);

			Gson gsonParser = new Gson();
			// Board[] allBoards = gsonParser.fromJson(response, Board[].class);

			Type collectionType = new TypeToken<ArrayList<Board>>() {
			}.getType();
			///////////////////////////////////////////////////////
			List<Board> allBoards = gsonParser.fromJson(response, collectionType);
			System.out.println(allBoards.get(0).getName());

			List<Board> apiTestBoard = allBoards.stream().filter(Board -> Board.getName().equals("ApiTest"))
					.collect(Collectors.toList());

			System.out.println(apiTestBoard.size());
			System.out.println(apiTestBoard.get(0).getId());
			/////////////////////////////////////////////////////
			response = example.run(TrelloRequestCreator.apiUrl + "/boards/" + apiTestBoard.get(0).getId() + "/lists?"
					+ TrelloRequestCreator.requestAccountParams);
			// System.out.println(response);

			List<BoardList> apiTestBoardList = gsonParser.fromJson(response, new TypeToken<ArrayList<BoardList>>() {
			}.getType());
			System.out.println("/////////////////////////////////////////////////////");
			/////////////////////////////////////////////////////////////////////////
			for (BoardList list : apiTestBoardList) {
				
				System.out.println("->"+list.getName());
				response = example.run(TrelloRequestCreator.apiUrl + "/lists/" + list.getId() + "/cards?"
						+ TrelloRequestCreator.requestAccountParams);
				List<Card> listCards = gsonParser.fromJson(response, new TypeToken<ArrayList<Card>>() {
				}.getType());
				for(Card card:listCards) {
					System.out.println("     " + card.getName());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("/////////////////////////////////////////////////////");
		System.out.println("done");
	}

}
