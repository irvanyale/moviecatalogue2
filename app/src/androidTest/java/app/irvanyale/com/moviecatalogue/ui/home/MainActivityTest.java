package app.irvanyale.com.moviecatalogue.ui.home;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import app.irvanyale.com.moviecatalogue.R;
import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.util.DataDummy;
import app.irvanyale.com.moviecatalogue.util.MyIdlingResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    private Context context;

    private List<MovieEntity> dummyMovie;
    private List<TvshowEntity> dummyTvShow;

    @Before
    public void setUp() {
        context = ApplicationProvider.getApplicationContext();
        dummyMovie = DataDummy.generateDummyMovies(context);
        dummyTvShow = DataDummy.generateDummyTvShows(context);

        IdlingRegistry.getInstance().register(MyIdlingResource.getIdlingResource());
    }

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie.get(0).getTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(dummyMovie.get(0).getReleaseDate())));
        onView(withId(R.id.tv_vote)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_vote)).check(matches(withText(dummyMovie.get(0).getVote())));
        onView(withId(R.id.text_description)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovie.get(0).getOverview())));
    }

    @Test
    public void loadTvShows() {
        onView(withText("Tv Show")).perform(click());
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition(dummyTvShow.size()));
    }

    @Test
    public void loadDetailTvShow() {
        onView(withText("Tv Show")).perform(click());
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvShow.get(0).getTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(dummyTvShow.get(0).getReleaseDate())));
        onView(withId(R.id.tv_vote)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_vote)).check(matches(withText(dummyTvShow.get(0).getVote())));
        onView(withId(R.id.text_description)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(dummyTvShow.get(0).getOverview())));
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(MyIdlingResource.getIdlingResource());
    }
}