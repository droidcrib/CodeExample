package droidcrib.blogspot.com.codeexample.screen.list.mvp;

import java.util.List;

import droidcrib.blogspot.com.codeexample.model.Article;

public interface NewsListActivityView {

    void showRefreshIndicator();

    void hideRefreshIndicator();

    void updateAll(List<Article> articleList);

    void showSnackbar(int position);

}
