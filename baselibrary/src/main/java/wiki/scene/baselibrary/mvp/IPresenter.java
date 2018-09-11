package wiki.scene.baselibrary.mvp;

public interface IPresenter<V> {

    void attachView(V view);

    void detachView();

}