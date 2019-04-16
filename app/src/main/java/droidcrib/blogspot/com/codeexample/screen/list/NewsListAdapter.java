package droidcrib.blogspot.com.codeexample.screen.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import droidcrib.blogspot.com.codeexample.R;
import droidcrib.blogspot.com.codeexample.model.Article;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private final List<Article> articles = new ArrayList<>();
    private AdapterItemClickListener adapterItemClickListener;

    NewsListAdapter(AdapterItemClickListener adapterItemClickListener) {
        this.adapterItemClickListener = adapterItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder vh = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_news_item, parent, false));
        vh.itemView.setOnClickListener(v -> {
            adapterItemClickListener.onItemClick(vh.getAdapterPosition());
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(articles.get(position).imageUrl).into(holder.userImage);
        holder.title.setText(articles.get(position).title);
        holder.author.setText(articles.get(position).authorName);
        holder.intro.setText(articles.get(position).intro);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    void updateAll(List<Article> data) {
        articles.clear();
        articles.addAll(data);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView title;
        TextView author;
        TextView intro;

        ViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.news_user_image);
            title = itemView.findViewById(R.id.news_title);
            author = itemView.findViewById(R.id.news_author);
            intro = itemView.findViewById(R.id.news_intro);
        }
    }


}
