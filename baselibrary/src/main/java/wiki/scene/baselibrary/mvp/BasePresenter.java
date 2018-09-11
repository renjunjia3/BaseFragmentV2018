package wiki.scene.baselibrary.mvp;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Des:Presenter基类
 * Author:scene
 * Date:2018/9/11 11:28
 */
public class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    private WeakReference<V> weakView;
    private V proxyView;

    @Override
    public void attachView(V view) {
        this.weakView = new WeakReference<>(view);
        MvpViewInvocationHandler invocationHandler = new MvpViewInvocationHandler(this.weakView.get());
        // 在这里采用动态代理
        proxyView = (V) Proxy.newProxyInstance(
                view.getClass().getClassLoader(),
                view.getClass().getInterfaces(),
                invocationHandler);
        Proxy.getProxyClass(view.getClass().getClassLoader(), view.getClass().getInterfaces());
    }


    protected V getView() {
        return proxyView;
    }

    /**
     * 用于检查View是否为空对象
     *
     * @return 判断的结果
     */
    private boolean isAttachView() {
        return this.weakView != null && this.weakView.get() != null;
    }

    @Override
    public void detachView() {
        if (weakView != null) {
            weakView.clear();
            weakView = null;
        }
    }


    private class MvpViewInvocationHandler implements InvocationHandler {

        private IBaseView mvpView;

        MvpViewInvocationHandler(IBaseView mvpView) {
            this.mvpView = mvpView;
        }

        @Override
        public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
            if (isAttachView()) {
                return method.invoke(mvpView, arg2);
            }
            return null;
        }

    }
}
