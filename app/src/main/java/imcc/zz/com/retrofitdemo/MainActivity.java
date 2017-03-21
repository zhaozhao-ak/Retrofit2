package imcc.zz.com.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import imcc.zz.com.retrofitdemo.Bean.BaseBean;
import imcc.zz.com.retrofitdemo.Bean.NewsDetailInfo;
import imcc.zz.com.retrofitdemo.Bean.TabNewsInfo;
import imcc.zz.com.retrofitdemo.network.NetWorkRequest;
import imcc.zz.com.retrofitdemo.network.NetWorkSubscriber;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }


    public void getOnclick(View view){
        switch (view.getId()){
            case R.id.btn_1:
                NetWorkRequest.tabNews(new NetWorkSubscriber<BaseBean.TabNewsBean>() {
                    @Override
                    public void onError(Throwable e) {
                        System.out.println("zhao------tabNews-----error------");
                    }
                    @Override
                    public void onNext(BaseBean.TabNewsBean tabNewsBean) {
                        System.out.println("zhao------tabNews-----onNext------"+tabNewsBean.getInfo().toString());
                        tv.setText(tabNewsBean.getInfo().toString());
                        List<TabNewsInfo> list = new ArrayList<TabNewsInfo>();
                        list = tabNewsBean.getInfo();
                        for (TabNewsInfo tabNewsInfo :list){
                            System.out.println("zhao------tabNewsInfo-------"+tabNewsInfo.getName());

                        }

                    }
                });

                break;
            case R.id.btn_2:
                NetWorkRequest.tabName(new NetWorkSubscriber<BaseBean.TabNameBean>() {
                    @Override
                    public void onError(Throwable e) {
                        System.out.println("zhao------tabName-----error------");
                    }


                    @Override
                    public void onNext(BaseBean.TabNameBean tabNameBean) {
                        System.out.println("zhao------tabName-----onNext------"+tabNameBean.getInfo().toString());
                        tv.setText(tabNameBean.getInfo().toString());

                    }
                });



                break;
            case R.id.btn_3:

                NetWorkRequest.newsList(id, 1, new NetWorkSubscriber<BaseBean.NewsListBean>() {

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("zhao------newsList-----error------");
                    }


                    @Override
                    public void onNext(BaseBean.NewsListBean newsListBean) {
                        System.out.println("zhao------newsList-----onNext------"+newsListBean.getInfo().toString());
                        tv.setText(newsListBean.getInfo().toString());

                    }
                });



                break;
            case R.id.btn_4:


                NetWorkRequest.newsDetail(id, new NetWorkSubscriber<NewsDetailInfo>() {
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        System.out.println("zhao------newsDetail-----error------");

                    }

                    @Override
                    public void onNext(NewsDetailInfo newsDetailInfo) {
                        super.onNext(newsDetailInfo);
                        System.out.println("zhao------newsDetail-----onNext------"+newsDetailInfo.toString());
                        tv.setText(newsDetailInfo.toString());
                    }
                });



                break;
            case R.id.btn_5:
                NetWorkRequest.imageList(id, 2, new NetWorkSubscriber<BaseBean.ImageListBean>() {
                    @Override
                    public void onError(Throwable e) {
                        System.out.println("zhao------imageList-----error------");

                    }


                    @Override
                    public void onNext(BaseBean.ImageListBean imageListBean) {
                        System.out.println("zhao------imageList-----onNext------"+imageListBean.getInfo().toString());
                        tv.setText(imageListBean.getInfo().toString());
                    }
                });

                break;

//            NetWorkRequest.imageNew(id, rows, new NetWorkSubscriber<BaseBean.ImageNewBean>() {
//                @Override
//                public void onError(Throwable e) {
//                    imageNewData.error();
//                }
//
//
//                @Override
//                public void onNext(BaseBean.ImageNewBean imageNewBean) {
//                    imageNewData.addData(imageNewBean.getInfo());
//                }
//            });


//            NetWorkRequest.imageDetail(id, new NetWorkSubscriber<BaseBean.ImageDetailBean>() {
//
//                @Override
//                public void onError(Throwable e) {
//                    super.onError(e);
//                    imageDetailData.error();
//                }
//
//
//                @Override
//                public void onNext(BaseBean.ImageDetailBean imageDetailBean) {
//                    super.onNext(imageDetailBean);
//                    imageDetailData.addData(imageDetailBean.getList());
//                }
//            });









        }


    }
}
