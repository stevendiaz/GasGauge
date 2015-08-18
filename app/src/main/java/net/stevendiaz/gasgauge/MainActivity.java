package net.stevendiaz.gasgauge;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private Button mFillUpButton;
    private Button mCheckMileage;
    private Button mUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook up button to button objects
        mCheckMileage = (Button)findViewById(R.id.button_check_miles);
        mCheckMileage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new activity means new intent
            }
        });

        mFillUpButton = (Button)findViewById(R.id.button_fill_up);
        mFillUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new activity means new intent
            }
        });

        mUpdateButton = (Button)findViewById(R.id.button_update_vehicle);
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new activity means new intent
            }
        });

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
