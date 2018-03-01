package example.app.com.interviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button recycleViewActivity = (Button) findViewById(R.id.btn_recycle_demo);
        recycleViewActivity.setOnClickListener(this);

        Button notifDemoActivity = (Button) findViewById(R.id.btn_notif_demo);
        notifDemoActivity.setOnClickListener(this);

        Button serviceDemoActivity = (Button) findViewById(R.id.btn_service_demo);
        serviceDemoActivity.setOnClickListener(this);

        Button fragmentDemoActivity = (Button) findViewById(R.id.btn_fragment_demo);
        fragmentDemoActivity.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recycle_demo:
                startActivity(new Intent(this, RecyclerDemoActivity.class));
                break;
            case R.id.btn_notif_demo:
                startActivity(new Intent(this, NotifDemoActivity.class));
                break;
            case R.id.btn_service_demo:
                startActivity(new Intent(this, ServiceDemoActivity.class));
                break;
            case R.id.btn_fragment_demo:
                Log.e(MainActivity.class.toString(), "clicked");
                startActivity(new Intent(this, FragmentDemoActivity.class));
                break;
            default:
                break;
        }
    }
}
