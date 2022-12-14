package elior.com.infrastructure.pages.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public Activity activity;
    private ProgressDialog dialog;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity) context;

        dialog = new ProgressDialog(activity);
    }

    public void showProgressDialog(String text) {
        dialog.setMessage(text);
        dialog.show();
    }

    public void hideProgressDialog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
