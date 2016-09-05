package com.swaziprocurement.pricecheckerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login, register;
    private EditText etEMail, etPass;
    private DbHelper db;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session=new Session(this);
        db=new DbHelper(this);
        login =(Button)findViewById(R.id.blogin);
        register =(Button)findViewById(R.id.bRegister);
        etEMail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        if(session.loggedin()){
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.blogin:
                login();
                break;
            case R.id.bRegister:
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));

                break;
            default:
        }

    }
    public void login(){
        session.setLoggedin(true);
        String email=etEMail.getText().toString();
        String pass=etPass.getText().toString();
        if(db.getUser(email,pass)){
            startActivity(new Intent(MainActivity.this,Main2Activity.class));

        }else {
            Toast.makeText(getApplicationContext(),"Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
    }


