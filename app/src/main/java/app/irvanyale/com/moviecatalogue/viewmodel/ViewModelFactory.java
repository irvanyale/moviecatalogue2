package app.irvanyale.com.moviecatalogue.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import app.irvanyale.com.moviecatalogue.data.source.DataRepository;
import app.irvanyale.com.moviecatalogue.di.Injection;
import app.irvanyale.com.moviecatalogue.ui.detail.DetailViewModel;
import app.irvanyale.com.moviecatalogue.ui.movie.MovieViewModel;
import app.irvanyale.com.moviecatalogue.ui.tvshow.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final DataRepository dataRepository;

    private ViewModelFactory(DataRepository academyRepository) {
        dataRepository = academyRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            return (T) new TvShowViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(dataRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
