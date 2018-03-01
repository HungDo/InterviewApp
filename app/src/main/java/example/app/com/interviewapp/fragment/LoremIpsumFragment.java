package example.app.com.interviewapp.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import example.app.com.interviewapp.R;

/**
 * Created by hung on 2/24/18.
 */

public class LoremIpsumFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loremipsum, container, false);

        Button btnSwitch = view.findViewById(R.id.btn_switch);
        btnSwitch.setOnClickListener(v -> {
            Log.e(LoremIpsumFragment.class.toString(), "clicked");

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            Fragment currentFrag = getFragmentManager().findFragmentById(R.id.frag_top);

            if (currentFrag instanceof GalleryFragment) {
                Fragment fragment = new ImageFragment();
                fragmentTransaction.replace(R.id.frag_top, fragment);
            } else  {
                Fragment fragment = new GalleryFragment();
                fragmentTransaction.replace(R.id.frag_top, fragment);
            }

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        RequestQueue rq = Volley.newRequestQueue(this.getContext());
//        rq.add(new Request<String>() {
//            @Override
//            protected Response<String> parseNetworkResponse(NetworkResponse response) {
//                return null;
//            }
//
//            @Override
//            protected void deliverResponse(String response) {
//
//            }
//        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
