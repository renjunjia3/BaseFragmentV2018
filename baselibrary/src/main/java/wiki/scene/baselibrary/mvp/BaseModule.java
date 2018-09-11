package wiki.scene.baselibrary.mvp;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wiki.scene.baselibrary.base.BaseActivity;
import wiki.scene.baselibrary.base.BaseFragment;

public class BaseModule {

    protected BaseActivity mActivity;
    protected BaseFragment mFragment;

    public BaseModule(BaseActivity act) {
        this.mActivity = act;
    }

    public BaseModule(BaseFragment frag) {
        this.mFragment = frag;
    }

    protected <T> void addActSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mActivity.<T>bindUntilEvent(ActivityEvent.DESTROY))//绑定生命周期，防止内存泄露
                .subscribe(observer);
    }

    protected <T> void addFragSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mFragment.<T>bindUntilEvent(FragmentEvent.DESTROY))//绑定生命周期，防止内存泄露
                .subscribe(observer);
    }

}