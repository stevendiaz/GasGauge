package net.stevendiaz.gasgauge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FillUpActivity extends ActionBarActivity {

    private EditText mGallonsOnFillUp;
    private EditText mOdometerMiles;
    private Button mGetMPGButton;
    private TextView mDisplayMPG;
    private Button mResetMPGButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_up);

        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        //Hook up views to view objects
        mGallonsOnFillUp = (EditText)findViewById(R.id.fillup_gallons_text);
        mOdometerMiles = (EditText)findViewById(R.id.fillup_odometer_text);
        mGetMPGButton = (Button)findViewById(R.id.fillup_mpg_button);
        mDisplayMPG = (TextView)findViewById(R.id.fillup_mpg_text);
        mResetMPGButton = (Button)findViewById(R.id.fillup_reset_button);

        //TODO: move to another method maybe??
        if(userData.getInt(Vehicle.MPG_KEY, -1) == -1){
            mDisplayMPG.setText("No MPG found");
        }
        else {
            mDisplayMPG.setText(Integer.toString(userData.getInt(Vehicle.MPG_KEY, -1)));
        }



    }

    public void calculateMPG(View view){
        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userData.edit();

        //calculates MPG
        int gallonsOnFillUp = Integer.parseInt(mGallonsOnFillUp.getText().toString());
        int updatedMiles = Integer.parseInt(mOdometerMiles.getText().toString());
        int diffMiles = updatedMiles - userData.getInt(Vehicle.ODOMETER_KEY, -1); //TODO: error check this
        int MPG = diffMiles / gallonsOnFillUp;

        //average in the new MPG
        //increment the count
        int mpgCount = userData.getInt(Vehicle.COUNT_KEY, 0) + 1;
        //if MPG hasn't been stored, it doesn't need to be averaged
        int avgMPG;
        if(userData.getInt(Vehicle.MPG_KEY, -1) == -1) {
            avgMPG = MPG;
        }
        else {
            avgMPG = MPG + userData.getInt(Vehicle.MPG_KEY, 0) / mpgCount;
        }


        //update saved data
        editor.putInt(Vehicle.COUNT_KEY, mpgCount);
        editor.putInt(Vehicle.MPG_KEY, avgMPG);
        editor.apply();

        mDisplayMPG.setText(Integer.toString(avgMPG));
    }

    public void resetMPG(View view){
        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userData.edit();

        editor.putInt(Vehicle.MPG_KEY, 0);
        editor.putInt(Vehicle.COUNT_KEY, 0);

        mDisplayMPG.setText(Integer.toString(0));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fill_up, menu);
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
