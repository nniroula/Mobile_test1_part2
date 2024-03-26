package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    /* view binding variable */
    private ActivityMainBinding binding;

    /* declare other variables */
    private double avg;
    private String grade;
    private double testOneScore;
    private double testTwoScore;
    private double testThreeScore;

    /* variables for storing view ids */
    private EditText editTextScore1;
    private EditText editTextScore2;
    private EditText editTextScore3;
    private TextView textViewAverage;
    private TextView textViewLetterGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        /*Test 1 */
        try{
            if(editTextScore1.getText().toString().isEmpty()){
                testOneScore = 0.00;
            }else{
                testOneScore = Double.parseDouble(editTextScore1.getText().toString());
                if(testOneScore > 100 || testOneScore < 0){
                    Toast toast = Toast.makeText(this, "Test 1 score cannot be less than 0 or more than 100", Toast.LENGTH_LONG);
                    toast.setMargin(2, 4);
                    toast.show();
                    return;
                }
            }
        }catch(NumberFormatException e){
            //Toast toast = Toast.makeText(this, "Amount must be a decimal number.", Toast.LENGTH_LONG);
            Toast toast = Toast.makeText(this, "Test 1 score must be a number between 0 and 100", Toast.LENGTH_LONG);
            toast.setMargin(2, 4);
            toast.show();
            return;
        }

        /* Test 2 */
        try{
            if(editTextScore2.getText().toString().isEmpty()){
                testTwoScore = 0.00;
            } else{
                testTwoScore = Double.parseDouble(editTextScore2.getText().toString());
                if(testTwoScore > 100 || testTwoScore < 0){
                    Toast toast = Toast.makeText(this, "Test 2 score cannot be less than 0 or more than 100", Toast.LENGTH_LONG);
                    toast.setMargin(2, 4);
                    toast.show();
                    return;
                }
            }
        }catch(NumberFormatException e){
            Toast toast = Toast.makeText(this, "Test 2 score must be a number between 0 and 100", Toast.LENGTH_LONG);
            toast.setMargin(2, 4);
            toast.show();
            return;
        }

        /* Test 3 */
        try{
            if(editTextScore3.getText().toString().isEmpty()){
                testThreeScore = 0.00;
            }else{
                testThreeScore = Double.parseDouble(editTextScore3.getText().toString());
                if(testThreeScore > 100 || testThreeScore < 0){
                    Toast toast = Toast.makeText(this, "Test 3 score cannot be less than 0 or more than 100", Toast.LENGTH_LONG);
                    toast.setMargin(2, 4);
                    toast.show();
                    return;
                }
            }
        }catch(NumberFormatException e){
            Toast toast = Toast.makeText(this, "Test 3 score must be a number between 0 and 100", Toast.LENGTH_LONG);
            toast.setMargin(2, 4);
            toast.show();
            return;
        }

        /* average and letter grade */
        DecimalFormat df = new DecimalFormat("#0.00");
        avg = (testOneScore + testTwoScore + testThreeScore)/3.0;
        textViewAverage.setText(df.format(avg));

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