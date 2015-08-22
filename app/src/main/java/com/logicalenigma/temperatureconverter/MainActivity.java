package com.logicalenigma.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TemperatureConverter";

    private Button mConvertButton;
    private EditText mTemperatureInput;
    private TextView mTemperatureOutput;
    private RadioButton mRadioFahrenheit;
    private RadioButton mRadioCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTemperatureInput = (EditText) findViewById(R.id.edit_temperature);
        mTemperatureOutput = (TextView) findViewById(R.id.text_converted);
        mConvertButton = (Button) findViewById(R.id.button_convert);
        mRadioCelsius = (RadioButton) findViewById(R.id.radio_celsius);


        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTemperatureInput.getText().length() != 0) {
                    float value = Float.parseFloat(mTemperatureInput.getText().toString());
                    String text;
                    if (mRadioCelsius.isChecked()) {
                        // convert to Celsius
                        text = String.format(getResources().getText(R.string.format_celsius).toString(),
                                TemperatureUtil.convertToCelsius(value) );
                    }
                    else {
                        text = String.format(getResources().getText(R.string.format_fahrenheit).toString(),
                                TemperatureUtil.convertToFahrenheit(value) );
                    }
                    mTemperatureOutput.setText(text);
                }
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
