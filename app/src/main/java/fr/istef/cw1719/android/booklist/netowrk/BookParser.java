package fr.istef.cw1719.android.booklist.netowrk;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.sql.Array;
import java.util.ArrayList;

import fr.istef.cw1719.android.booklist.models.Book;

public class BookParser {

    public static ArrayList<Book> parseBooks(String json) {
        ArrayList<Book> books = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(json);
        JsonObject jsonObject = jsonTree.getAsJsonObject();
        JsonArray items = jsonObject.getAsJsonArray("items");
        for (JsonElement item : items) {
            JsonObject jsonBook = item.getAsJsonObject();
            String title = jsonBook.getAsJsonObject("volumeInfo").get("title").getAsString();
            String description = jsonBook.get("description").getAsString();
            Book b = new Book(title, "", "", null, description);
            books.add(b);
        }
        return books;
    }
}
