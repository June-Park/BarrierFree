package com.example.jj.barrierfree;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JJ on 2017-03-18.
 * 로그인, 로그아웃 상태를 위한 세션 객체
 * 참고 소스1 : https://www.youtube.com/watch?v=RWmbONsSg1E#t=747.444128
 */

public class Session {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context ctx)
    {
        context = ctx;
        prefs = context.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean loggedin)
    {
        editor.putBoolean("loggedInmode", loggedin);
        editor.commit();
    }

    public boolean loggedin()
    {
        return prefs.getBoolean("loggedInmode", false);
    }
}
