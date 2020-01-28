package app.irvanyale.com.moviecatalogue.data.source;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.data.source.remote.RemoteDataSource;
import app.irvanyale.com.moviecatalogue.data.source.remote.response.MovieResponse;
import app.irvanyale.com.moviecatalogue.data.source.remote.response.TvShowResponse;
import app.irvanyale.com.moviecatalogue.util.DataDummyResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataRepositoryTest {

    private RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private FakeDataRepository dataRepository = new FakeDataRepository(remote);

    private List<MovieResponse> movieResponses = DataDummyResponse.generateDummyMovies();
    private String movieId = movieResponses.get(0).getMovieId();
    private MovieResponse movieResponse = DataDummyResponse.generateDummyMoviesById(movieId);

    @Test
    public void getMovies() {
        when(remote.getMovies()).thenReturn(movieResponses);
        List<MovieEntity> movieEntities = dataRepository.getMovies();
        verify(remote).getMovies();
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getMovieById() {
        when(remote.getMovieById(movieId)).thenReturn(movieResponse);
        MovieEntity movieEntities = dataRepository.getMovieById(movieResponses, movieId);
        verify(remote).getMovieById(movieId);
        assertNotNull(movieEntities);
        assertEquals(movieResponse.getMovieId(), movieEntities.getMovieId());
    }

    @Test
    public void getTvShows() {
        List<TvShowResponse> tvshowResponses = DataDummyResponse.generateDummyTvShows();

        when(remote.getTvShows()).thenReturn(tvshowResponses);
        List<TvshowEntity> tvshowEntities = dataRepository.getTvShows();
        verify(remote).getTvShows();
        assertNotNull(tvshowEntities);
        assertEquals(tvshowResponses.size(), tvshowEntities.size());
    }

    @Test
    public void getTvShowById() {
        List<TvShowResponse> tvshowResponses = DataDummyResponse.generateDummyTvShows();
        String tvshowId = tvshowResponses.get(0).getTvshowId();
        TvShowResponse tvShowResponse = DataDummyResponse.generateDummyTvShowsById(tvshowId);

        when(remote.getTvShowById(tvshowId)).thenReturn(tvShowResponse);
        TvshowEntity tvshowEntities = dataRepository.getTvShowById(tvshowId);
        assertNotNull(tvshowEntities);
        assertEquals(tvShowResponse.getTvshowId(), tvshowEntities.getTvshowId());
    }
}