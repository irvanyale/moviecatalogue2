package app.irvanyale.com.moviecatalogue.ui.detail;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.data.source.DataRepository;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DetailViewModelTest {

    @Mock
    private Context context;

    private DetailViewModel viewModelMovie;
    private DetailViewModel viewModelTvShow;

    @Mock
    private DataRepository dataRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModelMovie = new DetailViewModel(dataRepository);
        viewModelTvShow = new DetailViewModel(dataRepository);
    }

    @Test
    public void getMovieDetail() {

        MovieEntity dummyMovie = DataDummy.generateDummyMovies().get(0);
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

        TvshowEntity dummyTvShow = DataDummy.generateDummyTvShows().get(0);
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