package app.irvanyale.com.moviecatalogue.ui.movie;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.source.DataRepository;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {

    private MovieViewModel viewModel;

    @Mock
    private DataRepository dataRepository;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(dataRepository);
    }

    @Test
    public void getMovies() {
        when(dataRepository.getMovies()).thenReturn(DataDummy.generateDummyMovies());
        List<MovieEntity> movieEntities = viewModel.getMovies();
        verify(dataRepository).getMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }
}