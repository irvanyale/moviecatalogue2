package app.irvanyale.com.moviecatalogue.ui.detail;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {

    @Mock
    private Context context;
    @Mock
    private Resources resString;

    private DetailViewModel viewModelMovie;
    private DetailViewModel viewModelTvShow;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModelMovie = new DetailViewModel();
        viewModelTvShow = new DetailViewModel();
    }

    @Test
    public void getMovieDetail() {

        when(context.getResources()).thenReturn(resString);

        MovieEntity dummyMovie = DataDummy.generateDummyMovies(context).get(0);
        String movieId = dummyMovie.getMovieId();

        viewModelMovie.setSelectedData(context, movieId);

        MovieEntity movieEntity = viewModelMovie.getMovie();

        assertNotNull(movieEntity);
        assertEquals(dummyMovie.getMovieId(), movieEntity.getMovieId());
        assertEquals(dummyMovie.getTitle(), movieEntity.getTitle());
        assertEquals(dummyMovie.getReleaseDate(), movieEntity.getReleaseDate());
        assertEquals(dummyMovie.getImage(), movieEntity.getImage());
        assertEquals(dummyMovie.getOverview(), movieEntity.getOverview());
        assertEquals(dummyMovie.getVote(), movieEntity.getVote());
    }

    @Test
    public void getTvShowDetail() {

        when(context.getResources()).thenReturn(resString);

        TvshowEntity dummyTvShow = DataDummy.generateDummyTvShows(context).get(0);
        String tvshowId = dummyTvShow.getTvshowId();

        viewModelTvShow.setSelectedData(context, tvshowId);
        TvshowEntity tvshowEntity = viewModelTvShow.getTvShow();

        assertNotNull(tvshowEntity);
        assertEquals(dummyTvShow.getTvshowId(), tvshowEntity.getTvshowId());
        assertEquals(dummyTvShow.getTitle(), tvshowEntity.getTitle());
        assertEquals(dummyTvShow.getReleaseDate(), tvshowEntity.getReleaseDate());
        assertEquals(dummyTvShow.getImage(), tvshowEntity.getImage());
        assertEquals(dummyTvShow.getOverview(), tvshowEntity.getOverview());
        assertEquals(dummyTvShow.getVote(), tvshowEntity.getVote());
    }
}