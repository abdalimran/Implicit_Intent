package com.github.abdalimran.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText enterurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterurl = (EditText) findViewById(R.id.enterurl);
    }

  /*
    Implicit Intent doesn't specifiy the component.
    In such case, intent provides information of available components provided by the system that is to be invoked.

    Here I'm using an implicit intent to show a webpage using android's default browser.
    */

    public void Visit(View view) {
        String url=enterurl.getText().toString();

        if(url.equals("")!=true) {
            if (url.startsWith("http://") == false)
                url = "http://" + url;

            Intent implicit_intent=new Intent(Intent.ACTION_VIEW);
            implicit_intent.setData(Uri.parse(url));
            startActivity(implicit_intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter a valid URL", Toast.LENGTH_LONG).show();
        }
    }
}
