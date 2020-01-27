package app.irvanyale.com.moviecatalogue.ui.movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import app.irvanyale.com.moviecatalogue.R;
import app.irvanyale.com.moviecatalogue.data.MovieEntity;
import app.irvanyale.com.moviecatalogue.ui.detail.DetailActivity;
import app.irvanyale.com.moviecatalogue.util.Const;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieEntity> listMovie = new ArrayList<>();

    void setMovies(List<MovieEntity> listMovie) {
        if (listMovie == null) return;
        this.listMovie.clear();
        this.listMovie.addAll(listMovie);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieEntity movieEntity = listMovie.get(position);
        holder.bind(movieEntity);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPoster;
        private TextView tvTitle, tvDescription, tvDate;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.img_poster);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
        }

        void bind(MovieEntity movieEntity){
            tvTitle.setText(movieEntity.getTitle());
            tvDescription.setText(movieEntity.getOverview());
            tvDate.setText(movieEntity.getReleaseDate());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, movieEntity.getMovieId());
                intent.putExtra(DetailActivity.EXTRA_TYPE, Const.TYPE_MOVIE);
                itemView.getContext().startActivity(intent);
            });

            Glide.with(itemView.getContext())
                    .load(movieEntity.getImage())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
        }
    }
}
