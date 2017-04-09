package com.example.jj.barrierfree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Vector;

public class Test extends AppCompatActivity {

    TextView textView;
    static String temp = "초기화";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textView = (TextView)findViewById(R.id.testText);
        GetXmlData getXmlData = new GetXmlData();
        getXmlData.setAllData();



/*        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);}

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://openapi.seoul.go.kr:8088/5375794d6d706a773433566c4d7063/xml/InfoBarrierFree/1/5/");
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                    String line = "";
                    while( (line = br.readLine()) != null) {
                        temp += line;
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    thread.run();*/


        String temp = "";
        Vector<Dataset> data  = getXmlData.getData();
        for(int a=0 ; a<data.size() ; a++)
        {
            temp += "\n";
            temp += data.get(a).getNUM();
            temp += "\n";
            temp += data.get(a).getADDRESS();
            temp += "\n";
            temp += data.get(a).getBIZHOUR();
            temp += "\n";
            temp += data.get(a).getBOARD_LIST();
            temp += "\n";
            temp += data.get(a).getFAX();
            temp += "\n";
        }
        textView.append(temp+"  ?");
    }
}
