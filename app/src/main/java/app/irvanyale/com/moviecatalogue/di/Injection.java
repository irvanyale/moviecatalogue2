package app.irvanyale.com.moviecatalogue.di;

import android.content.Context;

import app.irvanyale.com.moviecatalogue.data.source.DataRepository;
import app.irvanyale.com.moviecatalogue.data.source.remote.RemoteDataSource;
import app.irvanyale.com.moviecatalogue.util.JsonHelper;

public class Injection {

    public static DataRepository provideRepository(Context context) {

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return DataRepository.getInstance(remoteDataSource);
    }
}
