package nitish.stormy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.InjectView;

/**
 * Created by nitish on 3/5/2016.
 */
public class Location_select extends Activity implements AdapterView.OnItemSelectedListener {

    @InjectView(R.id.textView) TextView TextView1;
    @InjectView(R.id.textView2) TextView TextView2;
    @InjectView(R.id.textView3) TextView TextView3;
    Button butt1;
    String current_city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_select);

        Spinner spinner = (Spinner) findViewById(R.id.city_spinner);
        spinner.setOnItemSelectedListener(this);

        butt1 = (Button) findViewById(R.id.button1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.city_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Location_select.this,MainActivity.class);
                intent.putExtra("city",current_city);
                startActivity(intent);


            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String city_item = parent.getItemAtPosition(position).toString();
        current_city = city_item;

    }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }





}
