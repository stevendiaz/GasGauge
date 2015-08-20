package net.stevendiaz.gasgauge;

import android.content.Intent;
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
        mCheckMileage = (Button)findViewById(R.id.main_check_miles);
        mFillUpButton = (Button)findViewById(R.id.main_fill_up);
        mUpdateButton = (Button)findViewById(R.id.main_update_vehicle);

    }

    public void startCheckMilesActivity(View view){
        Intent intent = new Intent(this, CheckMilesActivity.class);
        startActivity(intent);
    }

    public void startFillUpActivity(View view){
        Intent intent = new Intent(this, FillUpActivity.class);
        startActivity(intent);
    }

    public void startVehicleInfoActivity(View view){
        Intent intent = new Intent(this, VehicleInfoActivity.class);
        startActivity(intent);
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
