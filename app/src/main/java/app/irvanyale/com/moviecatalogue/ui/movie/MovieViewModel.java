package app.irvanyale.com.moviecatalogue.ui.movie;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.source.DataRepository;

public class MovieViewModel extends ViewModel {

    private DataRepository dataRepository;

    public MovieViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<MovieEntity> getMovies() {
        return dataRepository.getMovies();
    }
}
