package com.example.jj.barrierfree;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by JJ on 2017-03-19.
 * 회원가입을 위한 PHP 연동 페이지
 * 아이디 중복체크, 디비에 새 회원정보 삽입
 */

public class AsyncSignup extends AsyncTask<String, Void, String> {

    Context context;
    String result = "";
    ProgressDialog mdialog;

    public AsyncSignup(Context ctx)
    {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String asyncId = params[1];
        String php_url = "";

        /*아이디 중복체크*/
        if(type.equals("idcheck"))
        {
            php_url = "http://13.124.84.116/idcheck.php";

            try {
                URL url = new URL(php_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                //아이디 전달
                String post_data = URLEncoder.encode("asyncId", "UTF-8")+"="+URLEncoder.encode(asyncId, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                //input

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String line = "";

                while ((line=bufferedReader.readLine()) != null)
                {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*회원가입. 정보 삽입*/
        else if(type.equals("signup"))
        {
            php_url = "http://13.124.84.116/signup.php";

            String asyncPassword = params[2];
            String asyncNickname = params[3];

            try {
                URL url = new URL(php_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                //아이디, 비번, 닉네임 전달
                String post_data = URLEncoder.encode("asyncId", "UTF-8")+"="+URLEncoder.encode(asyncId, "UTF-8")
                        +"&"+URLEncoder.encode("asyncPassword", "UTF-8")+"="+URLEncoder.encode(asyncPassword, "UTF-8")
                        +"&"+URLEncoder.encode("asyncNickname", "UTF-8")+"="+URLEncoder.encode(asyncNickname, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                //input

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String line = "";

                while ((line=bufferedReader.readLine()) != null)
                {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String s) {


    }

}
