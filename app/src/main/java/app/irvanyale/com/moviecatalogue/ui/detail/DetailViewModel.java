package app.irvanyale.com.moviecatalogue.ui.detail;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.data.source.DataRepository;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

public class DetailViewModel extends ViewModel {

    private String dataId;
    private Context context;
    private DataRepository dataRepository;

    public void setSelectedData(Context context, String dataId) {
        this.context = context;
        this.dataId = dataId;
    }

    public DetailViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public MovieEntity getMovie() {
        return dataRepository.getMovieById(dataId);
    }

    public TvshowEntity getTvShow() {
        return dataRepository.getTvShowById(dataId);
    }
}
