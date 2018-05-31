package moim.prjmoim;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;

import static moim.prjmoim.Join.etEmail1;
import static moim.prjmoim.Join.etId1;
import static moim.prjmoim.Join.etName1;
import static moim.prjmoim.Join.etPhone1;
import static moim.prjmoim.Join.etPwd1;
import static moim.prjmoim.Join.etPwdCheck1;
import static moim.prjmoim.Join.sEmail1;
import static moim.prjmoim.Join.sId1;
import static moim.prjmoim.Join.sName1;
import static moim.prjmoim.Join.sPhone1;
import static moim.prjmoim.Join.sPwd1;
import static moim.prjmoim.Join.sPwdCheck1;

/**
 * Created by D7701 on 2018-05-23.
 */


public class Insert {
    public void dataInsert() {
        new Thread() {
            @Override
            public void run() {

                try {
                    sName1 = etName1.getText().toString();
                    sId1 = etId1.getText().toString();
                    sPwd1 = etPwd1.getText().toString();
                    sPwdCheck1 = etPwdCheck1.getText().toString();
                    sPhone1 = etPhone1.getText().toString();
                    sEmail1 = etEmail1.getText().toString();

                    URL setURL = new URL("Http://ny276.dothome.co.kr/insert.php/");
                    HttpURLConnection http;
                    http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(sName1).append("/").append(sId1).append("/").append(sPwd1).append("/").append(sPhone1).append("/").append(sEmail1).append("/");
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "euc-kr");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "euc-kr");
                    final BufferedReader redear = new BufferedReader(tmp);
                    while(redear.readLine() != null)
                    {
                        System.out.println(redear.readLine());
                    }
                } catch (Exception e) {
                    Log.e("", "", e);
                }
            }
        }.start();
    }
}


