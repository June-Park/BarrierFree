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
 * Created by JJ on 2017-03-15.
 * 로그인을 위한 어싱크 백그라운드 작업
 */

//////////////////////////////////////////////////////////////////////////////////////////프로그래스 다이얼로그 필요 없을듯. 점검할 것.

public class AsyncLogin extends AsyncTask<String, Void, String> {

    Context context;
    String result = "";
    //AlertDialog dialog;
    ProgressDialog mdialog;

    public AsyncLogin(Context ctx)
    {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String asyncEmail = params[1];
        String asyncPassword = params[2];
        String login_url = "http://13.124.84.116/login.php";
        //10.0.0.2 = android localhost

        if(type.equals("login"))
        {
            try {
                URL url = new URL(login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("asyncEmail", "UTF-8")+"="+URLEncoder.encode(asyncEmail, "UTF-8")+"&"+
                        URLEncoder.encode("asyncPassword", "UTF-8")+"="+URLEncoder.encode(asyncPassword, "UTF-8");

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
        //dialog = new AlertDialog.Builder(context).create();
        //dialog.setTitle("login status");
        mdialog = new ProgressDialog(context);
        mdialog.setMessage("login check...");
        mdialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        //dialog.setMessage(result);
        //dialog.show();

       // mdialog.setMessage(result);
        //mdialog.show();
        mdialog.dismiss();

    }

}
