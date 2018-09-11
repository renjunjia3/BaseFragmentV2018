package wiki.scene.basefragmentv2018;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import wiki.scene.baselibrary.base.BaseActivity;

public class TestActivity extends BaseActivity<ITestView, TestPresenter> implements ITestView {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        button = findViewById(R.id.button);
    }

    @Override
    protected void initListener() {
        super.initListener();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkCanClick()) {
                    mPresenter.getData();
                }
            }
        });
    }


    @Override
    public void showLoadingPage() {

    }

    @Override
    public void showErrorPage() {

    }

    @Override
    public void showContentPage() {
        button.setText("修改后");
    }

    @Override
    public void showNetWorkErrorPage() {

    }

    @Override
    public void showNonePage() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApp.getRefWatcher(this).watch(this);
    }
}
