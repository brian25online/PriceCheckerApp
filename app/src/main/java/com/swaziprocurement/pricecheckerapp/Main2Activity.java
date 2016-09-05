package com.swaziprocurement.pricecheckerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
private Button btnLogout;
    private Button bAdd;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        session=new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout=(Button)findViewById(R.id.bLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();

            }
        });

        bAdd=(Button)findViewById(R.id.bAdd);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAct();
            }
        });
    }

    private void logout(){

        session.setLoggedin(false);
        finish();
        startActivity(new Intent(Main2Activity.this,MainActivity.class));
    }

    private void openAct(){
        startActivity(new Intent(Main2Activity.this,Main3Activity.class));

    }

}
