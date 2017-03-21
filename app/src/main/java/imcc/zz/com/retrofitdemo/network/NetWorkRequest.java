package imcc.zz.com.retrofitdemo.network;


import imcc.zz.com.retrofitdemo.Bean.BaseBean;
import imcc.zz.com.retrofitdemo.Bean.NewsDetailInfo;
import imcc.zz.com.retrofitdemo.utils.RxUtils;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {

    private static <M> void addObservable(Observable<M> observable, Subscriber<M> subscriber) {
        RxUtils.getInstance().addSubscription(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public static void newsDetail(int id, Subscriber<NewsDetailInfo> subscriber) {
        addObservable(Network.getTngouApi().getNewsDetail(id), subscriber);
    }

    public static void newsList(int id, int page, Subscriber<BaseBean.NewsListBean> subscriber) {
        addObservable(Network.getTngouApi().getNewsList(id, page), subscriber);
    }

    public static void tabNews(Subscriber<BaseBean.TabNewsBean> subscriber) {
        addObservable(Network.getTngouApi().getTabNews(), subscriber);
    }

    public static void imageDetail(int id, Subscriber<BaseBean.ImageDetailBean> subscriber) {
        addObservable(Network.getTngouApi().getImageDetail(id), subscriber);
    }

    public static void imageList(int id, int page, Subscriber<BaseBean.ImageListBean> subscriber) {
        addObservable(Network.getTngouApi().getImageList(id, page), subscriber);
    }

    public static void imageNew(int id, int rows, Subscriber<BaseBean.ImageNewBean> subscriber) {
        addObservable(Network.getTngouApi().getImageNews(id, rows), subscriber);
    }

    public static void tabName(Subscriber<BaseBean.TabNameBean> subscriber) {
        addObservable(Network.getTngouApi().getTabName(), subscriber);
    }

}
