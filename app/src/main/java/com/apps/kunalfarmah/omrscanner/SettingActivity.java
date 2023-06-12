package com.apps.kunalfarmah.omrscanner;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import java.util.List;
public class SettingActivity extends AppCompatActivity {

    private static final String WHATSAPP_PACKAGE = "com.apps.kunalfarmah.omrscanner";

    Button logout;

    private Button btnShare;

    FirebaseAuth Firebase =FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        logout = findViewById(R.id.Logoutid);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase.signOut();
                Toast.makeText(SettingActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SettingActivity.this,LoginActivity.class));
                finish();
            }
        });


        btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareViaWhatsApp();
            }
        });
    }


    private void shareViaWhatsApp() {
        PackageManager packageManager = getPackageManager();
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");

        // Check if WhatsApp is installed
        if (isPackageInstalled("com.whatsapp", packageManager)) {
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome app: " +
                    "https://www.twitter.com/myapp");
            startActivity(whatsappIntent);
        } else {
            Toast.makeText(this, "WhatsApp is not installed on your device", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }











    }
}












