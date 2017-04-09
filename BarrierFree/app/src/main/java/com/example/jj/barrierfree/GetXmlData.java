package com.example.jj.barrierfree;

import android.os.StrictMode;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;


/**
 * Created by JJ on 2017-03-27.
 * Open API URL connecting : http://blog.naver.com/baek2304/220420964159
 */


public class GetXmlData {

    public Vector<Dataset> datalist;
    int index = 0;
    static String rst = ""; //테스트용 스테틱-----------------------------------------------------------------------------------------삭제요망

    public GetXmlData()
    {

    }

    //전체보기. 전체검색
    public void setAllData()
    {
        datalist = new Vector<Dataset>();

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);}

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://openapi.seoul.go.kr:8088/5375794d6d706a773433566c4d7063/xml/InfoBarrierFree/1/20/");
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp = factory.newPullParser();

                    String line = "";
                    String temp = "";

                    while( (line = br.readLine()) != null) {
                        temp += line;
                    }

                    xpp.setInput(new StringReader(temp));

                    String tag = null;
                    String ttContents = null, ttTitle = null;

                    int eventType = xpp.getEventType();

                    while (eventType != XmlPullParser.END_DOCUMENT) {

                        datalist.add(new Dataset());

                        if (eventType == XmlPullParser.START_TAG) {
                            tag = xpp.getName();
                            //rst += tag.toString();
                        }

                        else if (eventType == XmlPullParser.TEXT) {
                            if (tag.equals("NUM")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setNUM(ttTitle);
                                rst += ttTitle + "///";
                                // rst += "ttTitle 걸림/" + ttTitle;
                                //rst += list.size()+"개///";
                            }
                            if (tag.equals("NAME")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setNAME(ttTitle);
                            }
                            if (tag.equals("TEL")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setTEL(ttTitle);
                            }
                            if (tag.equals("FAX")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setFAX(ttTitle);
                            }
                            if (tag.equals("ADDRESS")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setADDRESS(ttTitle);
                            }
                            if (tag.equals("BIZHOUR")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setBIZHOUR(ttTitle);
                            }
                            if (tag.equals("REST")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setREST(ttTitle);
                            }
                            if (tag.equals("INFOMATION")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFORMATION(ttTitle);
                            }
                            if (tag.equals("BOARD_LIST")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setBOARD_LIST(ttTitle);
                            }
                            if (tag.equals("INFORMATI_1")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFORMATI_1(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_1")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_1(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_2")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_2(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_3")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_3(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_4")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_4(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_5")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_5(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_6")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_6(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_7")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_7(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_8")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_8(ttTitle);
                            }
                            if (tag.equals("INFO_BLE_9")) {
                                ttTitle = xpp.getText();
                                datalist.get(index).setINFO_BLE_9(ttTitle);
                            }
                            /*--------------------------------------------------------------------위도 경도 다음위도 다음경도 아직 안넣음*/



                        }

                        else if (eventType == XmlPullParser.END_TAG) {
                            tag = xpp.getName();

                            if (tag.equals("row")) {
                                rst += "끝태그";
                                //break;
                                ++index;
                            }
                        }
                        eventType = xpp.next();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.run();
        //thread.start();

    }


    public Vector<Dataset> getData()
    {
        return datalist;
    }

}
