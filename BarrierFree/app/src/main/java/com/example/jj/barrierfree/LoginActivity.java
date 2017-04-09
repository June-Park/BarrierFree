package com.example.jj.barrierfree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail;
    private EditText loginPassword;
    String loginResult = "초기값";

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = (EditText)findViewById(R.id.login_email);
        loginPassword = (EditText)findViewById(R.id.login_password);

        /**/
        session = new Session(this);

        /*if(session.loggedin())
        {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }*/
    }

    public void doLogin(View view)
    {

        String processtype = "login";
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        AsyncLogin asyncLogin = new AsyncLogin(this);
        try {
            loginResult = asyncLogin.execute(processtype, email, password).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////// 로그인상황시 어딘가에 세팅
        //로그인 성공시. login.php 파일 확인해보면 echo로 "Login" 찍음. 실패시 "Fail".
        if(loginResult.equals("Login"))
        {
            /*세션*/
            session.setLoggedin(true);

            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainIntent);

            finish();
        }
        else
        {
            // 다이얼로그 바디
            AlertDialog.Builder alert_confirm = new AlertDialog.Builder(this);
            // 메세지
            alert_confirm.setMessage("아이디와 비밀번호를 다시 한 번 확인해주세요.");
            // 확인 버튼 리스너
            alert_confirm.setPositiveButton("확인", null);
            // 다이얼로그 생성
            AlertDialog alert = alert_confirm.create();

            // 아이콘
            //alert.setIcon(R.drawable.ic_launcher);
            // 다이얼로그 타이틀
            alert.setTitle("로그인");
            // 다이얼로그 보기
            alert.show();
        }

    }
}
