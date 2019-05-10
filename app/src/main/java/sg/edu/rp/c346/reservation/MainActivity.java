package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button cfm;
    Button reset;
    EditText name;
    EditText number;
    EditText size;
    CheckBox smoking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cfm = findViewById(R.id.buttonConfirm);
        reset = findViewById(R.id.btnreset);

        name = findViewById(R.id.editTextName);
        number = findViewById(R.id.editTextPhone);
        size = findViewById(R.id.size);

        smoking = findViewById(R.id.smoking);

        tp = findViewById(R.id.timePicker);
        dp = findViewById(R.id.datePicker);

        cfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = "";
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                time = hour + ":"+min;

                String date = "";
                int day = dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();

                date = day+"/"+(month+1)+"/"+year;
                String area ="";

                if(smoking.isChecked()){
                     area += "Smoking area";
                }
                else{
                     area += "Non-smoking area";
                }
                String message = "Name: " + name.getText().toString() + "\n"+
                        "Mobile Number: " + number.getText().toString() + "\n"+
                        "Group Size: " + size.getText().toString() + "\n" +
                        "Dining Area: " + area + "\n" +
                        "Time: "+time + "\n" + "Date: " + date;
                Toast.makeText(MainActivity.this,message,
                        Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                number.setText("");
                size.setText("");

                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

                dp.updateDate(2019,5,1);
            }
        });
    }




}
