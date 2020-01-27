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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {

    @Mock
    private Context context;
    @Mock
    private Resources resString;

    private MovieViewModel viewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        when(context.getResources()).thenReturn(resString);
        List<MovieEntity> movieEntities = viewModel.getMovies(context);
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }
}