package oscarduartt.com.moremovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class FragmentDetailMovie extends Fragment {

    Movie movie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment_detail_movie, container, false);

        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("MOVIE")) {
            movie = (Movie) intent.getSerializableExtra("MOVIE");
            ImageView imageView = ((ImageView) v.findViewById(R.id.poster));
            Picasso.with(getContext()).load("http://image.tmdb.org/t/p/w185/" + movie.getPoster_path()).into(imageView);
            ((TextView) v.findViewById(R.id.title))
                    .setText(movie.getTitle());
            ((TextView) v.findViewById(R.id.relesase_date))
                    .setText(movie.getRelease_date());
            ((TextView) v.findViewById(R.id.user_rating))
                    .setText(Integer.toString((int) movie.getVote_average()) + "/10");
            ((TextView) v.findViewById(R.id.synopsis))
                    .setText(movie.getOverview());
        }

        return v;
    }
}
