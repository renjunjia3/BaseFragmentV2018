package wiki.scene.basefragmentv2018;

import android.annotation.SuppressLint;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.LogUtils;

import wiki.scene.baselibrary.base.BaseApp;
import wiki.scene.baselibrary.util.PermissionHelper;

public class MyApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        applyStoragePermission();
        initCrash();
    }

    @SuppressLint("MissingPermission")
    private void initCrash() {
        CrashUtils.init(new CrashUtils.OnCrashListener() {
            @Override
            public void onCrash(String crashInfo, Throwable e) {
                LogUtils.e(crashInfo);
                AppUtils.relaunchApp();
            }
        });
    }

    private void applyStoragePermission() {
        PermissionHelper.requestStorage(new PermissionHelper.OnPermissionGrantedListener() {
            @Override
            public void onPermissionGranted() {
                initCrash();
            }
        });
    }

}
