package app.irvanyale.com.moviecatalogue.data.source;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.data.source.remote.response.MovieResponse;

public interface FakeDataSource {

    List<MovieEntity> getMovies();

    MovieEntity getMovieById(List<MovieResponse> movieResponses, String id);

    List<TvshowEntity> getTvShows();

    TvshowEntity getTvShowById(String id);
}
