package fr.istef.cw1719.android.booklist.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import fr.istef.cw1719.android.booklist.R;
import fr.istef.cw1719.android.booklist.models.Book;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
         Book book = (Book) getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.img_book_cover);
        TextView title = convertView.findViewById(R.id.txt_book_title);
        TextView author = convertView.findViewById(R.id.txt_book_author);

        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        Picasso.with(getContext()).load(book.getImgUrl()).into(img);

        return convertView;
    }
}
