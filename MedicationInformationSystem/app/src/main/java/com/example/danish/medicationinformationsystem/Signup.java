package com.example.danish.medicationinformationsystem;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    Button btn_sign_up1;
    EditText username,pass_word,name;
    TextView login1;
    TextView s_up;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_signup);
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        s_up = (TextView) findViewById(R.id.link_signup);
        login1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Log.d("mylog", "Going to Create an Account");
                Intent intentSignUP = new Intent(Signup.this, Login.class);
                startActivity(intentSignUP);
            }
        });

        username =(EditText)findViewById(R.id.input_email);
        pass_word =(EditText)findViewById(R.id.input_password);
        name =(EditText)findViewById(R.id.input_name);
        btn_sign_up1=(Button)findViewById(R.id.btn_signup);
        btn_sign_up1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName=username.getText().toString();
                String password=pass_word.getText().toString();
                String name1= name.getText().toString();


                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||name.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    Log.d("mylog", "Feild Empty" );
                    return;
                }
                // check if both password matches

                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password, name1);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    Log.d("mylog", "Account Successfully Created" );
                    Intent intent = new Intent(Signup.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }

}


