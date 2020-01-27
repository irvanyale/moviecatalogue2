package app.irvanyale.com.moviecatalogue.ui.tvshow;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import app.irvanyale.com.moviecatalogue.data.TvshowEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvShowViewModelTest {

    @Mock
    private Context context;
    @Mock
    private Resources resString;

    private TvShowViewModel tvShowViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tvShowViewModel = new TvShowViewModel();
    }

    @Test
    public void getTvShows() {
        when(context.getResources()).thenReturn(resString);
        List<TvshowEntity> tvshowEntities = tvShowViewModel.getTvShows(context);
        assertNotNull(tvshowEntities);
        assertEquals(10, tvshowEntities.size());
    }
}