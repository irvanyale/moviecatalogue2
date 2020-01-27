package app.irvanyale.com.moviecatalogue.ui.detail;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

public class DetailViewModel extends ViewModel {

    private String dataId;
    private Context context;

    public void setSelectedData(Context context, String dataId) {
        this.context = context;
        this.dataId = dataId;
    }

    public MovieEntity getMovie() {
        MovieEntity movie = null;
        List<MovieEntity> movieEntities = DataDummy.generateDummyMovies(context);
        for (MovieEntity movieEntity : movieEntities) {
            if (movieEntity.getMovieId().equals(dataId)) {
                movie = movieEntity;
            }
        }
        return movie;
    }

    public TvshowEntity getTvShow() {
        TvshowEntity tvshow = null;
        List<TvshowEntity> tvshowEntities = DataDummy.generateDummyTvShows(context);
        for (TvshowEntity tvshowEntity : tvshowEntities) {
            if (tvshowEntity.getTvshowId().equals(dataId)) {
                tvshow = tvshowEntity;
            }
        }
        return tvshow;
    }
}
