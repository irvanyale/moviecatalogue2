package app.irvanyale.com.moviecatalogue.ui.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import app.irvanyale.com.moviecatalogue.R;
import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.util.Const;
import app.irvanyale.com.moviecatalogue.util.MyIdlingResource;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_TYPE = "extra_type";

    private ImageView imagePoster;
    private TextView textTitle, textDate, tvVote, textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        imagePoster = findViewById(R.id.image_poster);
        textTitle = findViewById(R.id.text_title);
        textDate = findViewById(R.id.text_date);
        textDescription = findViewById(R.id.text_description);
        tvVote = findViewById(R.id.tv_vote);

        MyIdlingResource.increment();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String dataId = extras.getString(EXTRA_ID);
            String dataType = extras.getString(EXTRA_TYPE);

            if (dataId != null && dataType != null) {
                DetailViewModel detailViewModel =
                        new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                                .get(DetailViewModel.class);

                detailViewModel.setSelectedData(this, dataId);

                String title = "";
                String date = "";
                String desc = "";
                String vote = "";
                Drawable poster = null;

                switch (dataType){
                    case Const.TYPE_MOVIE:
                        MovieEntity movie = detailViewModel.getMovie();
                        title = movie.getTitle();
                        date = movie.getReleaseDate();
                        desc = movie.getOverview();
                        vote = movie.getVote();
                        poster = movie.getImage();
                        break;
                    case Const.TYPE_TVSHOW:
                        TvshowEntity tvshow = detailViewModel.getTvShow();
                        title = tvshow.getTitle();
                        date = tvshow.getReleaseDate();
                        desc = tvshow.getOverview();
                        vote = tvshow.getVote();
                        poster = tvshow.getImage();
                        break;
                }

                populateData(title, date, desc, vote, poster);
            }
        }

        if (!MyIdlingResource.getIdlingResource().isIdleNow()) {
            MyIdlingResource.decrement();
        }
    }

    private void populateData(String title, String date, String desc, String vote, Drawable poster) {
        textTitle.setText(title);
        textDate.setText(date);
        textDescription.setText(desc);
        tvVote.setText(vote);

        if (poster != null){
            Glide.with(this)
                    .load(poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imagePoster);
        }
    }
}
