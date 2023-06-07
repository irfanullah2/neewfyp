package com.apps.kunalfarmah.omrscanner;

import android.app.Dialog;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class StartActivity extends AppCompatActivity {

    Button scan,logout, answer;
    boolean isCamera = true;

    FirebaseAuth Firebase =FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        scan = findViewById(R.id.scan);
        answer = findViewById(R.id.setAnswers);
        logout = findViewById(R.id.Logout);
        scan.setOnClickListener(v -> {
            Dialog dialog = new Dialog(StartActivity.this);
            dialog.setContentView(R.layout.selection_dialog);
            dialog.findViewById(R.id.camera).setOnClickListener(view->{isCamera=true; dialog.cancel(); openActivity();});
            dialog.findViewById(R.id.gallery).setOnClickListener(view->{isCamera=false; dialog.cancel();openActivity();});
            dialog.show();
//            openActivity();
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase.signOut();
                Toast.makeText(StartActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StartActivity.this,LoginActivity.class));
                finish();



            }
        });


        answer.setOnClickListener(v -> startActivity(new Intent(StartActivity.this, AnswersActivity.class)));
    }

    public void openActivity(){
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        intent.putExtra("isCamera",isCamera);
        startActivity(intent);
    }

}