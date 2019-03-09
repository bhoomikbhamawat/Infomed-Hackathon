package com.example.akash.maps;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class logon extends AppCompatActivity {
    private EditText Name;
    private EditText Pass;
    private Button Login;
    private TextView ureg;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog pdilog;
    private TextView Fpswd;
    private LoginButton loginButton;
    private static final String EMAIL = "email";
    CallbackManager callbackManager;
    private TextView txtStatus;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_logon);
        initializeControls();
        loginWithFB();










        loginButton.setReadPermissions(Arrays.asList(EMAIL));

        Name =(EditText)findViewById(R.id.n1);
        Pass =(EditText)findViewById(R.id.p1);
        Login =(Button) findViewById(R.id.b1);
        ureg=(TextView) findViewById(R.id.t1);
        firebaseAuth=FirebaseAuth.getInstance();
        pdilog=new ProgressDialog(this);
        Fpswd =(TextView)findViewById(R.id.fpswd);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            finish();
            startActivity(new Intent(logon.this,menu.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid(Name.getText().toString(), Pass.getText().toString());

            }
        });

       /** Fpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logon.this, Fpasswd.class));
            }
        });**/
        ureg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logon .this, MainActivity.class));
            }
        });



    }

    private void loginWithFB(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                txtStatus.setText("Login Success\n"+loginResult.getAccessToken());


            }

            @Override
            public void onCancel() {
                txtStatus.setText("Login Cancelled");

            }

            @Override
            public void onError(FacebookException error) {
                txtStatus.setText("Login Error:"+error.getMessage());

            }
        });
    }

    private void initializeControls(){
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        txtStatus=(TextView)findViewById(R.id.textView);
    }
    private void  valid(String userName, String pswd) {
        pdilog.setMessage("Welcome  Validating...");
        pdilog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    pdilog.dismiss();
                    Toast.makeText(logon.this, "Login successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(logon.this, menu.class));
                } else {
                    pdilog.dismiss();
                    Toast.makeText(logon.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}