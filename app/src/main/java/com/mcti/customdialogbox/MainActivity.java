package com.mcti.customdialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialg_layout,viewGroup,false);
        //view
        TextView question = dialogView.findViewById(R.id.question);
        RadioButton answer1 = dialogView.findViewById(R.id.answer1);
        RadioButton answer2 = dialogView.findViewById(R.id.answer2);
        RadioButton answer3 = dialogView.findViewById(R.id.answer3);
        RadioButton answer4 = dialogView.findViewById(R.id.answer4);
        Button submit = dialogView.findViewById(R.id.submit);
        radioGroup = dialogView.findViewById(R.id.radio);
        question.setText("how we declare static method in Java?");
        answer1.setText("this");
        answer2.setText("super");
        answer3.setText("static");
        answer4.setText("final");
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        RadioButton radioButton = radioGroup.findViewById(i);
                        answer = radioButton.getText().toString();
                        Toast.makeText(MainActivity.this, ""+answer, Toast.LENGTH_SHORT).show();
                    }
                });
        
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("static".equals(answer)){
                Toast.makeText(MainActivity.this, "right "+answer, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "wrong "+answer, Toast.LENGTH_SHORT).show();
                }
                
            }
        });
        
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
