package wiki.scene.baselibrary.base;

import android.content.Context;
import android.os.Bundle;

import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxActivity {
    protected Context context;
    private Unbinder bind;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(setLayoutId());
        bind = ButterKnife.bind(this);
        initView();
        setListener();
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected abstract void setListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
