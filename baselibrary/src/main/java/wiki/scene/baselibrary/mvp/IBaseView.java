package wiki.scene.baselibrary.mvp;

/**
 * Des:View的基类
 * Author:scene
 * Date:2018/9/11 11:28
 */
public interface IBaseView {

    void showLoadingPage();

    void showErrorPage();

    void showContentPage();

    void showNetWorkErrorPage();

    void showNonePage();

    void showToast(String message);
}