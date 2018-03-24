package mx.iteso.escalaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {
    EditText name, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.activity_login_name);
        password = findViewById(R.id.activity_login_password);
        login=findViewById(R.id.activity_login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void saveUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("mx.iteso.USER_PREFRENCES", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", name.getText().toString());
        editor.putString("PWD", password.getText().toString());
        editor.putBoolean("LOGGED", true);
        editor.apply();
    }
}
