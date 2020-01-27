package app.irvanyale.com.moviecatalogue.ui.movie;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

public class MovieViewModel extends ViewModel {

    public List<MovieEntity> getMovies(Context context){
        return DataDummy.generateDummyMovies(context);
    }
}
