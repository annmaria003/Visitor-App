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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddVisitor extends AppCompatActivity {

    EditText fName, lName, purp, meet;
    Button submitButton, backButton;

    String FirstName,LastName,Purpose,Meet;
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
                FirstName = fName.getText().toString();
                LastName = lName.getText().toString();
                Purpose = purp.getText().toString();
                Meet = meet.getText().toString();

                if(FirstName.isEmpty()||LastName.isEmpty()||Purpose.isEmpty()||Meet.isEmpty()){
                    Toast.makeText(getApplicationContext(),"All the fields are mandatory",Toast.LENGTH_LONG).show();
                }
                else {
                    CallApi();
                }
            }

            private void CallApi() {
                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data = new JSONObject();
                try {
                    data.put("firstname",FirstName);
                    data.put("lastname",LastName);
                    data.put("purpose",Purpose);
                    data.put("whomToMeet",Meet);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response ->Toast.makeText(getApplicationContext(),"succesfully added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Something went wrong!",Toast.LENGTH_LONG).show()
                );

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(request);
            }

        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}