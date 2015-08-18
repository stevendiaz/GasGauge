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

/// Use this Activity to take in Vehicle Information and create a Vehicle Object



public class VehicleInfoActivity extends ActionBarActivity {
    private EditText mVehicleNameField;
    private EditText mOdometerField;
    private EditText mGallonsField;
    private Button mEnterButton;
    private Vehicle mVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);
        //Method to hook up the buttons

        //Get shared preferences object
        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor preferenceEditor = userData.edit();


        //gets data if it exists
        //if data hasn't been entered yet then
        mVehicleNameField = (EditText)findViewById(R.id.vehicle_name_text);

        String mVehiclename = userData.getString(Vehicle.NAME_KEY, "");
        mVehicleNameField.setText(mVehiclename);

        mOdometerField = (EditText)findViewById(R.id.vehicle_miles_text);

        int mOdometer = userData.getInt(Vehicle.ODOMETER_KEY, 0);
        mOdometerField.setText(Integer.toString(mOdometer));

        mGallonsField = (EditText)findViewById(R.id.vehicle_gallons_text);
        int mGallons = userData.getInt(Vehicle.GALLONS_KEY, 0);
        mGallonsField.setText(Integer.toString(mGallons));

        mEnterButton = (Button)findViewById(R.id.vehicle_enter_button);

    }

    public void saveVehicleData(View view){
        SharedPreferences userData = getSharedPreferences(Vehicle.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userData.edit();

        String vehicleName = mVehicleNameField.getText().toString();
        int miles = Integer.parseInt(mOdometerField.getText().toString());
        int gallonsInTank = Integer.parseInt(mGallonsField.getText().toString());

        editor.putString(Vehicle.NAME_KEY, vehicleName);
        editor.putInt(Vehicle.ODOMETER_KEY, miles);
        editor.putInt(Vehicle.GALLONS_KEY, gallonsInTank);

        editor.apply();
    }


    //Submit form button onClick
    //Makes new vehicle object


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vehicle_info, menu);
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
