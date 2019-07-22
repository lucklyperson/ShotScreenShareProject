package demo.gradle.com.shotscreenshareproject;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    private ScreenShotManager screenShotManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        //请求存储权限
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, permissions, 111);

        screenShotManager = new ScreenShotManager(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //开启监听截屏
        if (screenShotManager != null) {
            screenShotManager.startListener();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //关闭截屏监听(防止触发)
        if (screenShotManager != null) {
            screenShotManager.stopListener();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //todo
    }
}
