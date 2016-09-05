package com.swaziprocurement.pricecheckerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private DbHelper db;
    private Button reg;
    private TextView tvLogin;
    private EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DbHelper(this);
        reg=(Button)findViewById(R.id.bRegister);
        tvLogin=(TextView)findViewById(R.id.tvLogin);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);

        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bRegister:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));


                break;
            default:
        }
    }
    public void register (){
        String email=etEmail.getText().toString();
        String pass=etPass.getText().toString();
        if (email.isEmpty() && pass.isEmpty()){
            displayToast("Username/Password is empty");

        }
        else {
            db.addUser(email,pass);
            displayToast("User registered");

        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
