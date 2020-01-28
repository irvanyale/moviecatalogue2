package app.irvanyale.com.moviecatalogue.data.source;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;

public interface DataSource {

    List<MovieEntity> getMovies();

    MovieEntity getMovieById(String id);

    List<TvshowEntity> getTvShows();

    TvshowEntity getTvShowById(String id);
}
