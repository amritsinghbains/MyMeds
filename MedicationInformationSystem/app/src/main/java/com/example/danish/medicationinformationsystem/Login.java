package com.example.danish.medicationinformationsystem;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity  {
    Button btn_login;
    EditText username,pass_word;
    TextView sign_up;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        btn_login = (Button) findViewById(R.id.btn_login);
        username =(EditText)findViewById(R.id.input_email);
        pass_word =(EditText)findViewById(R.id.input_password);
        btn_login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                //Button btnSignIn=(Button)findViewById(R.id.btn_login);

                // Set On ClickListener
               // btnSignIn.setOnClickListener(new OnClickListener() {
                    //@Override
                 //   public void onClick(View v) {
                        // get The User name and Password
                        String userName = username.getText().toString();
                        String password = pass_word.getText().toString();

                        // fetch the Password form database for respective user name
                        // String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                        // check if the Stored password matches with  Password entered by user
                        if (password.equals("123") && userName.equals("123")) {
                            Toast.makeText(Login.this, "Congrats: Login Successful", Toast.LENGTH_LONG).show();

                            Intent intent1 = new Intent(Login.this, Main_Menu.class);
                            startActivity(intent1);
                        } else {
                            Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                        }
                    }
                });



      //      }

       // });
        sign_up = (TextView) findViewById(R.id.link_signup);
        sign_up.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(Login.this, Sign_up.class);
                startActivity(intent);
            }
        });

    }

}
