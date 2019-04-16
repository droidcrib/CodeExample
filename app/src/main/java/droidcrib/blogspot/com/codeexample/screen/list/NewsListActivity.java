package droidcrib.blogspot.com.codeexample.screen.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import droidcrib.blogspot.com.codeexample.R;
import droidcrib.blogspot.com.codeexample.dagger.DependencyInjector;
import droidcrib.blogspot.com.codeexample.model.Article;
import droidcrib.blogspot.com.codeexample.screen.list.mvp.NewsListActivityPresenter;
import droidcrib.blogspot.com.codeexample.screen.list.mvp.NewsListActivityView;

public class NewsListActivity extends AppCompatActivity implements NewsListActivityView, AdapterItemClickListener {

    private NewsListActivityPresenter presenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsListAdapter newsListAdapter;
    private ConstraintLayout root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.activity_list_recyclerview);
        swipeRefreshLayout = findViewById(R.id.activity_list_swiperefresh);
        root = findViewById(R.id.root_layout);

        DependencyInjector.getAppComponent().inject(this);
        presenter = new NewsListActivityPresenter(this);
        newsListAdapter = new NewsListAdapter(this);
        recyclerView.setAdapter(newsListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.onRefreshAction();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.onRefreshAction();
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    // NewsListActivityView
    @Override
    public void showRefreshIndicator() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefreshIndicator() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateAll(List<Article> articleList) {
        newsListAdapter.updateAll(articleList);
        hideRefreshIndicator();
    }

    @Override
    public void showSnackbar(int position) {
        Snackbar.make(root, "Item clicked at position: " + position, Snackbar.LENGTH_SHORT)
                .show();
    }

    //AdapterItemClickListener
    @Override
    public void onItemClick(int position) {
        presenter.onItemClick(position);
    }

}
