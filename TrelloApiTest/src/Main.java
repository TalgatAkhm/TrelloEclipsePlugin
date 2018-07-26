import TrelloRestApi.Requester;
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
		// System.out.println("run");

		TrelloRequestCreator creator = new TrelloRequestCreator();

		Board apiTestBoard = creator.getCurrentBoardByName("ApiTest");
		
		for (BoardList list : creator.getBoardList(apiTestBoard)) {
			System.out.println("->" + list.getName());
			for (Card card : creator.getCards(list)) {
				System.out.println("     " + card.getName());
			}
		}

		System.out.println("done");
	}

}
