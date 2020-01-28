package app.irvanyale.com.moviecatalogue.ui.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.irvanyale.com.moviecatalogue.R;
import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.util.MyIdlingResource;
import app.irvanyale.com.moviecatalogue.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MyIdlingResource.increment();

        if (getActivity() != null) {

            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());

            MovieViewModel movieViewModel =
                    new ViewModelProvider(this, factory)
                            .get(MovieViewModel.class);

            List<MovieEntity> movies = movieViewModel.getMovies();

            MovieAdapter movieAdapter = new MovieAdapter();
            movieAdapter.setMovies(movies);

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(movieAdapter);
        }

        if (!MyIdlingResource.getIdlingResource().isIdleNow()) {
            MyIdlingResource.decrement();
        }
    }
}
