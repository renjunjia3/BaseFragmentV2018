package wiki.scene.baselibrary.mvp;

import java.lang.ref.WeakReference;

/**
 * Des:Presenter基类
 * Author:scene
 * Date:2018/9/11 11:28
 */
public class BasePresenter<V> implements IPresenter<V> {

    protected WeakReference<V> mMvpView;

    @Override
    public void attachView(V mvpView) {
        this.mMvpView = new WeakReference<>(mvpView);
    }


    protected V getView() {
        return mMvpView.get();
    }


    @Override
    public void detachView() {
        if (mMvpView != null) {
            mMvpView.clear();
            mMvpView = null;
        }
    }
}
