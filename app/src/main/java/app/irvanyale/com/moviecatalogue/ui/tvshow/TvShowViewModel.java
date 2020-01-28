package app.irvanyale.com.moviecatalogue.ui.tvshow;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.data.source.DataRepository;

public class TvShowViewModel extends ViewModel {

    private DataRepository dataRepository;

    public TvShowViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<TvshowEntity> getTvShows() {
        return dataRepository.getTvShows();
    }
}
