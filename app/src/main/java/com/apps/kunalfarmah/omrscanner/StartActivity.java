package com.apps.kunalfarmah.omrscanner;

import android.app.Dialog;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class StartActivity extends AppCompatActivity {




    Button scan,setting, answer;

    boolean isCamera = true;

    FirebaseAuth Firebase =FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        scan = findViewById(R.id.Scanid);
        answer = findViewById(R.id.Keyid);
        setting = findViewById(R.id.Settingid);





        scan.setOnClickListener(v -> {
            Dialog dialog = new Dialog(StartActivity.this);
            dialog.setContentView(R.layout.selection_dialog);
            dialog.findViewById(R.id.camera).setOnClickListener(view->{isCamera=true; dialog.cancel(); openActivity();});
            dialog.findViewById(R.id.gallery).setOnClickListener(view->{isCamera=false; dialog.cancel();openActivity();});
            dialog.show();
//            openActivity();
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StartActivity.this,SettingActivity.class);
                startActivity(i);


            }
        });

/*
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase.signOut();
                Toast.makeText(StartActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StartActivity.this,LoginActivity.class));
                finish();



            }
        });
*/

        answer.setOnClickListener(v -> startActivity(new Intent(StartActivity.this, AnswersActivity.class)));
    }




    public void openActivity(){
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        intent.putExtra("isCamera",isCamera);
        startActivity(intent);
    }

}