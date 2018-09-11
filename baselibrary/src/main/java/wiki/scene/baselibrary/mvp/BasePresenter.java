package wiki.scene.baselibrary.mvp;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

/**
 * Des:Presenter基类
 * Author:scene
 * Date:2018/9/11 11:28
 */
public class BasePresenter {

    private LifecycleProvider<ActivityEvent> provider;

    public BasePresenter(LifecycleProvider<ActivityEvent> provider) {
        this.provider = provider;
    }

    public LifecycleProvider<ActivityEvent> getProvider() {
        return provider;
    }
}