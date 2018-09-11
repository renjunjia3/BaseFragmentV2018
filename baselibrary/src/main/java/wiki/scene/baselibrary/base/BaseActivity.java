package wiki.scene.baselibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import wiki.scene.baselibrary.mvp.BasePresenter;
import wiki.scene.baselibrary.mvp.IBaseView;

public abstract class BaseActivity<V extends IBaseView, P extends BasePresenter<V>> extends RxAppCompatActivity {
    public Activity mActivity;
    public P mPresenter;
    private Unbinder unbinder;

    private long lastClick = 0;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        unbinder = ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
    }


    protected abstract int getLayoutId();

    protected abstract P createPresenter();


    /**
     * 初始化View
     */
    protected void initView() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 初始化事件
     */
    protected void initListener() {
    }

    /**
     * 检查是否可以响应点击事件
     *
     * @return true:可以 false:不响应
     */
    private boolean checkCanClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= 200) {
            lastClick = now;
            return true;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
        unbinder.unbind();
    }


}