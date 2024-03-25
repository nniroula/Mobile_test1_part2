package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // view binding variable
    private ActivityMainBinding binding;

    // declare other variables
    private TextView displayRadioButton; // to display radio button value

    private double avg;
    private String grade;

    // variables for storing view ids
    private EditText editTextScore1;
    private EditText editTextScore2;
    private EditText editTextScore3;
    private TextView textViewAverage;
    private TextView textViewLetterGrade;

    private double testOneScore;
    private double testTwoScore;
    private double testThreeScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        editTextScore1 = binding.editTextScore1;
        editTextScore2 = binding.editTextScore2;
        editTextScore3 = binding.editTextScore3;

        textViewAverage = binding.textViewAverage;
        textViewLetterGrade = binding.textViewLetterGrade;
    }

    public void onClick(View view){
        if(editTextScore1.getText().toString().isEmpty()){
            testOneScore = 0.00;
        }else{
            testOneScore = Double.parseDouble(editTextScore1.getText().toString());
        }

       // EditText inputScore2 = editTextScore2;
        if(editTextScore2.getText().toString().isEmpty()){
            testTwoScore = 0.00;
        }else{
            testTwoScore = Double.parseDouble(editTextScore2.getText().toString());
        }

       // Toast toast = Toast.makeText(this, "Amount must be a decimal number.", Toast.LENGTH_LONG);
        //Toast toast = Toast.makeText(this, score2, Toast.LENGTH_LONG);
       // toast.setMargin(2, 4);
        //toast.show();
        //return;

        if(editTextScore3.getText().toString().isEmpty()){
            testThreeScore = 0.00;
        }else{
            testThreeScore = Double.parseDouble(editTextScore3.getText().toString());
        }

        // average and letter grade
        DecimalFormat df = new DecimalFormat("#0.00");

        avg = (testOneScore + testTwoScore + testThreeScore)/3.0;
        textViewAverage.setText(df.format(avg));

        // grade calculation
        int averageInt = (int) avg;
        if(averageInt <= 100 && averageInt >= 90){
            grade = "A";
        }else if(averageInt >= 80 && averageInt < 90){
            grade = "B";
        }else if(averageInt >= 70 && averageInt < 80){
            grade = "C";
        }else if(averageInt >= 60 && averageInt < 70){
            grade = "D";
        }else if(averageInt < 60){
            grade = "F";
        }
        // Letter grade display
        textViewLetterGrade.setText(grade);

    }
}