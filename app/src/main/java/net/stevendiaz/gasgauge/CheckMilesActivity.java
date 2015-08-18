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
import android.widget.Toast;



public class CheckMilesActivity extends ActionBarActivity {

    private EditText mMilesUpdate;
    private TextView mMilesLeft;
    private Button mCheckMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_miles);

        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userData.edit();

        mMilesUpdate = (EditText)findViewById(R.id.miles_update);

        mMilesLeft = (TextView)findViewById(R.id.display_miles_left);

        mCheckMiles = (Button)findViewById(R.id.check_miles_button);

    }

    public void displayMilesLeft(View view){
        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userData.edit();


        //TODO: check is Odometer exists
        // Check if new miles is > than old miles
        if(userData.getInt(Vehicle.MPG_KEY, -1) == -1){
            Toast.makeText(this, "Can not calculate miles", Toast.LENGTH_LONG);
        }
        else {
            //get MPG
            //TODO: Finish calcuation

            int currentMiles = Integer.parseInt(mMilesUpdate.getText().toString());
            int MPG = userData.getInt(Vehicle.MPG_KEY, -1);
            int oldMiles = userData.getInt(Vehicle.ODOMETER_KEY, -1);
            int gallonsInTank = userData.getInt(Vehicle.GALLONS_KEY, -1);

            mMilesLeft.setText(getMPG(MPG, oldMiles, currentMiles, gallonsInTank));

            //update odometer
            editor.putInt(Vehicle.ODOMETER_KEY, currentMiles);

        }

    }

    public int getMPG(int MPG, int oldMiles, int currentMiles, int gallonsInTank){
        double milesTraveled = (double)(currentMiles - oldMiles);
        double gallonsLeft = gallonsInTank - (milesTraveled / MPG);
        return (int)gallonsLeft * MPG;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_miles, menu);
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
