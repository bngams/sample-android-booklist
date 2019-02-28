package fr.istef.cw1719.android.booklist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.istef.cw1719.android.booklist.R;
import fr.istef.cw1719.android.booklist.models.Book;

public class DetailActivity extends AppCompatActivity {

    TextView title;
    TextView year;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Book b = (Book) getIntent().getSerializableExtra("book");
        if(b != null) {
            this.loadBook(b);
        }
    }

    private void loadBook(Book book) {
        this.img = findViewById(R.id.detail_img);
        this.title = findViewById(R.id.detail_txt_title);
        this.year = findViewById(R.id.detail_txt_year);

        this.title.setText(book.getTitle());
        this.year.setText(book.getYear().toString());
        Picasso.with(getApplicationContext()).load(book.getImgUrl()).into(img);
    }
}
