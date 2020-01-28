package app.irvanyale.com.moviecatalogue.data.source;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.data.source.remote.RemoteDataSource;
import app.irvanyale.com.moviecatalogue.data.source.remote.response.MovieResponse;
import app.irvanyale.com.moviecatalogue.data.source.remote.response.TvShowResponse;

public class FakeDataRepository implements FakeDataSource{

    private volatile static FakeDataRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    FakeDataRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public List<MovieEntity> getMovies() {
        List<MovieResponse> movieResponses = remoteDataSource.getMovies();
        ArrayList<MovieEntity> movieList = new ArrayList<>();
        for (MovieResponse response : movieResponses) {
            MovieEntity movie =
                    new MovieEntity(
                            response.getMovieId(),
                            response.getTitle(),
                            response.getReleaseDate(),
                            response.getOverview(),
                            response.getVote(),
                            response.getImage());

            movieList.add(movie);
        }
        return movieList;
    }

    @Override
    public MovieEntity getMovieById(List<MovieResponse> movieResponses, String id) {
        MovieEntity movie = null;
        for (MovieResponse response : movieResponses) {

            if (response.getMovieId().equals(id)){
                movie = new MovieEntity(
                        response.getMovieId(),
                        response.getTitle(),
                        response.getReleaseDate(),
                        response.getOverview(),
                        response.getVote(),
                        response.getImage());
            }
        }
        return movie;
    }

    @Override
    public List<TvshowEntity> getTvShows() {
        List<TvShowResponse> tvshowResponses = remoteDataSource.getTvShows();
        ArrayList<TvshowEntity> tvshowList = new ArrayList<>();
        for (TvShowResponse response : tvshowResponses) {
            TvshowEntity tvshow =
                    new TvshowEntity(
                            response.getTvshowId(),
                            response.getTitle(),
                            response.getReleaseDate(),
                            response.getOverview(),
                            response.getVote(),
                            response.getImage());

            tvshowList.add(tvshow);
        }
        return tvshowList;
    }

    @Override
    public TvshowEntity getTvShowById(String id) {
        List<TvShowResponse> tvshowResponses = remoteDataSource.getTvShows();
        TvshowEntity tvshow = null;
        for (TvShowResponse response : tvshowResponses) {

            if (response.getTvshowId().equals(id)){
                tvshow = new TvshowEntity(
                        response.getTvshowId(),
                        response.getTitle(),
                        response.getReleaseDate(),
                        response.getOverview(),
                        response.getVote(),
                        response.getImage());
            }
        }
        return tvshow;
    }
}
