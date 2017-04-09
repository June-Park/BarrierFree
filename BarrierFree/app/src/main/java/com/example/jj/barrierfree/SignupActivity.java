package com.example.jj.barrierfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

public class SignupActivity extends Activity {

    private EditText signupId;
    private EditText signupPw;
    private EditText signupPwCheck;
    private EditText signupNickname;

    private Button signupIdcheckButton;
    private Button signupButton;

    private boolean idValidation = false;
    private boolean pwValidation = false;
    private String validId = "";

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupId = (EditText)findViewById(R.id.signup_id);
        signupPw = (EditText)findViewById(R.id.signup_password);
        signupPwCheck = (EditText)findViewById(R.id.signup_passwordcheck);
        signupNickname = (EditText)findViewById(R.id.signup_nickname);

        signupIdcheckButton = (Button)findViewById(R.id.signup_idcheckButton);
        signupButton = (Button)findViewById(R.id.signup_signupButton);

        //아이디와 비번 칸에는 영어대소문자와 숫자만 입력 가능하도록 함
        signupId.setFilters(new InputFilter[] { editFilter });
        signupPw.setFilters(new InputFilter[] { editFilter });
        signupPwCheck.setFilters(new InputFilter[] { editFilter });

        session = new Session(this);

    }

    protected InputFilter editFilter = new InputFilter() {
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            //Pattern pattern = Pattern.compile("^[A-Z]+$");        // 영문대문자
            // Pattern pattern = Pattern.compile("^[a-zA-Z]+$");        // 영문
            // Pattern pattern = Pattern.compile("^[ㄱ-ㅎ가-힣]+$");        // 한글
            // Pattern pattern = Pattern.compile("^[a-zA-Z0-9ㄱ-ㅎ가-힣]+$");        // 영문,숫자,한글
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");        // 영문대소문자,숫자
            if(!pattern.matcher(source).matches()) {
                return "";
            }
            return null;
        }
    };

    public void onClick(View view)
    {
        AsyncSignup asyncSignup = new AsyncSignup(this);

        switch (view.getId())
        {
            //아이디 중복 확인
            case R.id.signup_idcheckButton:

                validId = signupId.getText().toString().trim();

                if(TextUtils.isEmpty(validId))
                {
                    Toast.makeText(SignupActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.getTrimmedLength(validId)<4)
                {
                    Toast.makeText(SignupActivity.this, "아이디는 4~15자로 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.getTrimmedLength(validId)>15)
                {
                    Toast.makeText(SignupActivity.this, "아이디는 4~15자로 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    try {
                        //반환값이 1이면 true 아니면 false
                        idValidation = asyncSignup.execute("idcheck", validId).get().equals("1") ? true : false;
                        if(idValidation)
                        {
                            Toast.makeText(SignupActivity.this, "사용 가능한 아이디입니다.", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(SignupActivity.this, "다른 아이디를 입력해주세요.", Toast.LENGTH_LONG).show();
                        }
                        //String temp = asyncSignup.execute("idcheck", validId).get();
                        //Toast.makeText(SignupActivity.this, temp+"", Toast.LENGTH_LONG).show();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                break;

            //회원가입
            case R.id.signup_signupButton:

                String pw = signupPw.getText().toString().trim();
                String pwcheck = signupPwCheck.getText().toString().trim();
                String nickname = signupNickname.getText().toString().trim();

                //아이디 유효성 검사가 안됐으면
                if (!(idValidation && (validId.equals(signupId.getText().toString()))))
                {
                    Toast.makeText(SignupActivity.this, "아이디 중복확인을 해주세요.", Toast.LENGTH_LONG).show();
                }
                //비밀번호를 입력하지 않았을 경우
                else if(TextUtils.isEmpty(pw))
                {
                    Toast.makeText(SignupActivity.this, "비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                //비밀번호 확인이 맞지 않으면
                else if(!(pw.equals(pwcheck)))
                {
                    Toast.makeText(SignupActivity.this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String signupResult = "";
                    try {
                        //닉네임을 입력하지 않은 경우 아이디로 처리
                        if(TextUtils.isEmpty(nickname))
                        {
                            nickname = validId;
                        }

                        String temp = asyncSignup.execute("signup", validId, pw, nickname).get();
                        //Toast.makeText(SignupActivity.this, temp+"회원가입 완료?", Toast.LENGTH_LONG).show();



                        //-----------------------------------------------------------------------------------------로그인 후 처리 해주세요

                        String email = validId;
                        String password = pw;
                        String loginResult = "";
                        String processtype = "login";

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

                            Intent mainIntent = new Intent(SignupActivity.this, MainActivity.class);
                            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(mainIntent);

                            finish();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                break;

            default:
                break;
        }
    }
}
