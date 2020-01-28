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
import app.irvanyale.com.moviecatalogue.data.source.DataRepository;
import app.irvanyale.com.moviecatalogue.util.DataDummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvShowViewModelTest {

    @Mock
    private DataRepository dataRepository;

    private TvShowViewModel tvShowViewModel;

    @Before
    public void setUp() {
        tvShowViewModel = new TvShowViewModel(dataRepository);
    }

    @Test
    public void getTvShows() {
        when(dataRepository.getTvShows()).thenReturn(DataDummy.generateDummyTvShows());
        List<TvshowEntity> tvshowEntities = tvShowViewModel.getTvShows();
        verify(dataRepository).getTvShows();
        assertNotNull(tvshowEntities);
        assertEquals(10, tvshowEntities.size());
    }
}