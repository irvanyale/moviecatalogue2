package app.irvanyale.com.moviecatalogue.ui.tvshow;

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
import app.irvanyale.com.moviecatalogue.data.TvshowEntity;
import app.irvanyale.com.moviecatalogue.ui.detail.DetailActivity;
import app.irvanyale.com.moviecatalogue.util.Const;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private List<TvshowEntity> listTvshow = new ArrayList<>();

    void setTvShows(List<TvshowEntity> listTvshow) {
        if (listTvshow == null) return;
        this.listTvshow.clear();
        this.listTvshow.addAll(listTvshow);
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_tvshow, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        TvshowEntity tvshowEntity = listTvshow.get(position);
        holder.bind(tvshowEntity);
    }

    @Override
    public int getItemCount() {
        return listTvshow.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPoster;
        private TextView tvTitle, tvDescription, tvDate;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.img_poster);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
        }

        void bind(TvshowEntity tvshowEntity){
            tvTitle.setText(tvshowEntity.getTitle());
            tvDescription.setText(tvshowEntity.getOverview());
            tvDate.setText(tvshowEntity.getReleaseDate());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, tvshowEntity.getTvshowId());
                intent.putExtra(DetailActivity.EXTRA_TYPE, Const.TYPE_TVSHOW);
                itemView.getContext().startActivity(intent);
            });

            Glide.with(itemView.getContext())
                    .load(tvshowEntity.getImage())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
        }
    }
}
