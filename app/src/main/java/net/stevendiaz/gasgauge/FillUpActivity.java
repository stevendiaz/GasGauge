package net.stevendiaz.gasgauge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_up);

        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        //Hook up views to view objects
        mGallonsOnFillUp = (EditText)findViewById(R.id.fillup_gallons_text);
        mOdometerMiles = (EditText)findViewById(R.id.fillup_odometer_text);
        mGetMPGButton = (Button)findViewById(R.id.get_mpg_button);
        mDisplayMPG = (TextView)findViewById(R.id.display_mpg_text);
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
        int gallonsOnFillUp = Integer.parseInt(mGallonsOnFillUp.getText().toString());
        int updatedMiles = Integer.parseInt(mOdometerMiles.getText().toString());
        int diffMiles = updatedMiles - userData.getInt(Vehicle.ODOMETER_KEY, -1);

        int MPG;
        MPG = diffMiles / gallonsOnFillUp;
        Log.d("TAG", "MPG: " +MPG);
        editor.putInt(Vehicle.MPG_KEY, MPG);
        editor.putInt(Vehicle.ODOMETER_KEY, updatedMiles);
        editor.apply();

        mDisplayMPG.setText(Integer.toString(MPG));
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
