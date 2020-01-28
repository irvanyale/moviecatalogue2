package app.irvanyale.com.moviecatalogue.util;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import app.irvanyale.com.moviecatalogue.data.source.remote.response.MovieResponse;
import app.irvanyale.com.moviecatalogue.data.source.remote.response.TvShowResponse;

public class JsonHelper {

    private Context context;

    public JsonHelper(Context context) {
        this.context = context;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private String parsingFileToString(String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovies() {
        ArrayList<MovieResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("Movies.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movies");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject course = listArray.getJSONObject(i);

                    String movieId = course.getString("movieId");
                    String title = course.getString("title");
                    String releaseDate = course.getString("releaseDate");
                    String overview = course.getString("overview");
                    String vote = course.getString("vote");
                    String image = course.getString("image");

                    MovieResponse movieResponse = new MovieResponse(movieId, title, releaseDate, overview, vote, image);
                    list.add(movieResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public MovieResponse loadMovieById(String id) {
        MovieResponse movieResponse = null;
        try {
            String json = parsingFileToString("Movies.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movies");

                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject course = listArray.getJSONObject(i);

                    String movieId = course.getString("movieId");

                    if (movieId.equals(id)){

                        String title = course.getString("title");
                        String releaseDate = course.getString("releaseDate");
                        String overview = course.getString("overview");
                        String vote = course.getString("vote");
                        String image = course.getString("image");

                        movieResponse = new MovieResponse(movieId, title, releaseDate, overview, vote, image);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieResponse;
    }

    public List<TvShowResponse> loadTvShows() {
        ArrayList<TvShowResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("Tvshow.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("tvshows");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject course = listArray.getJSONObject(i);

                    String tvshowId = course.getString("tvshowId");
                    String title = course.getString("title");
                    String releaseDate = course.getString("releaseDate");
                    String overview = course.getString("overview");
                    String vote = course.getString("vote");
                    String image = course.getString("image");

                    TvShowResponse tvShowResponse = new TvShowResponse(tvshowId, title, releaseDate, overview, vote, image);
                    list.add(tvShowResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public TvShowResponse loadTvShowById(String id) {
        TvShowResponse tvShowResponse = null;
        try {
            String json = parsingFileToString("Tvshow.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("tvshows");

                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject course = listArray.getJSONObject(i);

                    String tvshowId = course.getString("tvshowId");

                    if (tvshowId.equals(id)){

                        String title = course.getString("title");
                        String releaseDate = course.getString("releaseDate");
                        String overview = course.getString("overview");
                        String vote = course.getString("vote");
                        String image = course.getString("image");

                        tvShowResponse = new TvShowResponse(tvshowId, title, releaseDate, overview, vote, image);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tvShowResponse;
    }
}
