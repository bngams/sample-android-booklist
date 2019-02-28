package fr.istef.cw1719.android.booklist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import fr.istef.cw1719.android.booklist.R;
import fr.istef.cw1719.android.booklist.adapters.BookAdapter;
import fr.istef.cw1719.android.booklist.models.Book;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> books = new ArrayList();
    BookAdapter bookAdapter;
    ListView lvBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.books.add(new Book("Title", "https://via.placeholder.com/150", "author", 2010, "Summary"));
        this.books.add(new Book("Title2", "https://via.placeholder.com/150", "author", 2012, "Summary"));

        this.bookAdapter = new BookAdapter(this,
                R.layout.item_book,
                books);

        this.lvBooks = findViewById(R.id.lv_books);
        this.lvBooks.setAdapter(bookAdapter);

        this.lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("CLICK", "pos"+position);
                // Lancer l’intent ici dans le onclick
                Book b = bookAdapter.getItem(position);
                Log.d("CLICK", "pos"+b.getTitle());
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("book", b);
                startActivity(intent);
            }
        });
    }
}
