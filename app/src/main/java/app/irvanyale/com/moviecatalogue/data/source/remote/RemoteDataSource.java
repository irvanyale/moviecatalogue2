package app.irvanyale.com.moviecatalogue.data.source.remote;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.source.remote.response.MovieResponse;
import app.irvanyale.com.moviecatalogue.data.source.remote.response.TvShowResponse;
import app.irvanyale.com.moviecatalogue.util.JsonHelper;

public class RemoteDataSource {

    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public List<MovieResponse> getMovies() {
        return jsonHelper.loadMovies();
    }

    public MovieResponse getMovieById(String id) {
        return jsonHelper.loadMovieById(id);
    }

    public List<TvShowResponse> getTvShows() {
        return jsonHelper.loadTvShows();
    }

    public TvShowResponse getTvShowById(String id) {
        return jsonHelper.loadTvShowById(id);
    }
}
