package example.app.com.interviewapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hung on 1/9/17.
 */
public class RecyclerDemoActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<CustomViewHolder> adapter;
    private Handler handler;
    private int items;
    private final int DELAY = 2000;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),
                    ((TextView) v.findViewById(R.id.tv_display)).getText(),
                    Toast.LENGTH_SHORT).show();
        }
    };

    private Runnable incrementer = new Runnable() {
        @Override
        public void run() {
            items += 1;

            adapter.notifyDataSetChanged();

            handler.postDelayed(incrementer, DELAY);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerView.Adapter<CustomViewHolder>() {
            @Override
            public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new CustomViewHolder(view);
            }

            @Override
            public void onBindViewHolder(CustomViewHolder holder, int position) {
                holder.display.setText("Position " + position);
                holder.display.setOnClickListener(clickListener);
            }

            @Override
            public int getItemCount() {
                return items;
            }
        };

        recyclerView.setAdapter(adapter);

        // incrementer
        handler = new Handler();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(incrementer);
    }

    protected void onResume() {
        super.onResume();
        incrementer.run();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(incrementer);
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView display;

        public CustomViewHolder(View itemView) {
            super(itemView);

            display = (TextView) itemView.findViewById(R.id.tv_display);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_list_item);
        }
    }
}
