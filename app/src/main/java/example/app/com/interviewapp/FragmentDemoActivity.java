package example.app.com.interviewapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by hung on 2/24/18.
 */

public class FragmentDemoActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
