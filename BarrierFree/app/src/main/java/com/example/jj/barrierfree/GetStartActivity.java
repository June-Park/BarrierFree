package com.example.jj.barrierfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetStartActivity extends Activity {

    private Button loginButton;
    private Button signupButton;
    private TextView searchinfoText;
    private TextView guestmodeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        loginButton = (Button)findViewById(R.id.getstart_loginButton);
        signupButton = (Button)findViewById(R.id.getstart_signupButton);
        searchinfoText = (TextView)findViewById(R.id.getstart_findidpw);
        guestmodeText = (TextView)findViewById(R.id.getstart_guestmode);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinIntent = new Intent(GetStartActivity.this, LoginActivity.class);
                startActivity(signinIntent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(GetStartActivity.this, SignupActivity.class);
                startActivity(signupIntent);
            }
        });

        searchinfoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        guestmodeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GetStartActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
