package wiki.scene.basefragmentv2018;

import android.os.Handler;

import wiki.scene.baselibrary.base.BaseActivity;
import wiki.scene.baselibrary.mvp.BasePresenter;

public class TestPresenter extends BasePresenter<ITestView> {
    private TestModel testModel;

    public TestPresenter(BaseActivity activity) {
        testModel = new TestModel(activity);
    }

    public void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().showContentPage();
            }
        }, 3000);

    }


}
