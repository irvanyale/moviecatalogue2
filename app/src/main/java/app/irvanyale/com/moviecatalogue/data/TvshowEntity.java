package app.irvanyale.com.moviecatalogue.data;

import android.graphics.drawable.Drawable;

public class TvshowEntity {

    private String tvshowId;
    private String title;
    private String releaseDate;
    private String overview;
    private String vote;
    private Drawable image;

    public TvshowEntity(String tvshowId, String title, String releaseDate, String overview, String vote, Drawable image) {
        this.tvshowId = tvshowId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.vote = vote;
        this.image = image;
    }

    public String getTvshowId() {
        return tvshowId;
    }

    public void setTvshowId(String tvshowId) {
        this.tvshowId = tvshowId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
