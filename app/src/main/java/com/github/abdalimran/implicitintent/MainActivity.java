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

    public void Visit(View view) {
        String url=enterurl.getText().toString();

        if(url.equals("")!=true) {
            if (url.startsWith("http://") == false)
                url = "http://" + url;

            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter a valid URL", Toast.LENGTH_LONG).show();
        }
    }
}
