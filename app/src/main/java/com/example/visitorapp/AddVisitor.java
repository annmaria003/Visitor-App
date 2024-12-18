package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddVisitor extends AppCompatActivity {

    EditText fName, lName, purp, meet;
    Button submitButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitor);

        fName = (EditText) findViewById(R.id.firstname);
        lName = (EditText) findViewById(R.id.lastname);
        purp = (EditText) findViewById(R.id.purpose);
        meet = (EditText) findViewById(R.id.wmeet);
        submitButton = (Button) findViewById(R.id.submit_button);
        backButton = (Button) findViewById(R.id.back_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName = fName.getText().toString();
                String LastName = lName.getText().toString();
                String Purpose = purp.getText().toString();
                String Meet = meet.getText().toString();

                Toast.makeText(getApplicationContext(),FirstName+" "+LastName+" "+Purpose+" "+Meet,Toast.LENGTH_LONG).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}