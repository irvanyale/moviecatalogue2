package app.irvanyale.com.moviecatalogue.ui.tvshow;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

public class TvShowViewModel extends ViewModel {

    public List<TvshowEntity> getTvShows(Context context){
        return DataDummy.generateDummyTvShows(context);
    }
}
