package elior.com.infrastructure.others;

import android.app.Application;

public class MyApplication extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }

    public static Application getApplication() {
        return application;
    }

}