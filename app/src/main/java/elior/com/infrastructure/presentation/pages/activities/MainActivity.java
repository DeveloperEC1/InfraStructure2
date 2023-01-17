package elior.com.infrastructure.presentation.pages.activities;

import android.os.Bundle;

import elior.com.infrastructure.R;
import elior.com.infrastructure.data.managers.ViewModelManager;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelManager.instance.initViewModels(this);

        setContentView(R.layout.activity_main);
    }

}
