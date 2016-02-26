package oscarduartt.com.moremovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by oilopez on 25/02/2016.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, Movie[] movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fragment_top_movies, parent, false);
        }

        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageView);

        Picasso.with(getContext()).load(movie.getImage()).into(imageview);

        return convertView;
    }
}
