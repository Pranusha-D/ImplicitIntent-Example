package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText website, location, shareTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        website = findViewById(R.id.et_website);
        location = findViewById(R.id.et_location);
        shareTxt = findViewById(R.id.et_shareText);
    }

    public void openWebsite(View view) {
        String url = website.getText().toString();

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation(View view) {
        String loc = location.getText().toString();

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + loc));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String share = shareTxt.getText().toString();

        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(share)
                .startChooser();
    }

}