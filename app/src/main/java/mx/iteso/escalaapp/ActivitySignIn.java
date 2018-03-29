package mx.iteso.escalaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySignIn extends AppCompatActivity {
    EditText firstname, lastname, email, password, descrption;
    AutoCompleteTextView city, state, gym;
    Button done, facebook_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        firstname = findViewById(R.id.sigin_firstname);
        lastname = findViewById(R.id.sigin_lastname);
        password = findViewById(R.id.sigin_password);
        email = findViewById(R.id.signin_email);

        city = findViewById(R.id.sigin_city_autocomplete);
        String[] cities = getResources().getStringArray(R.array.ciudades);
        ArrayAdapter<String> adapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);
        city.setAdapter(adapterCities);

        state = findViewById(R.id.sigin_state_autocomplete);
        String[] states = getResources().getStringArray(R.array.estados);
        ArrayAdapter<String> adapterStates = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, states);
        state.setAdapter(adapterStates);

        descrption = findViewById(R.id.signin_description);
        gym = findViewById(R.id.sigin_gym);
        String[] gyms = getResources().getStringArray(R.array.muros);
        ArrayAdapter<String> adapterGyms = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gyms);
        gym.setAdapter(adapterStates);

        done = findViewById(R.id.signin_done_button);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkDataUser()) {
                    saveUser();
                    Intent intent = new Intent(ActivitySignIn.this, ActivityMainCompetitions.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        facebook_signin = findViewById(R.id.activity_login_facebook_button);
        facebook_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivitySignIn.this, "Iniciar sesion mediante Facebook", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ActivitySignIn.this, ActivityMainCompetitions.class);

            }
        });
    }

    public boolean checkDataUser() {
        if (firstname.getText().toString().isEmpty())
            Toast.makeText(ActivitySignIn.this, "Falta el nombre", Toast.LENGTH_SHORT).show();
        else if (lastname.getText().toString().isEmpty())
            Toast.makeText(ActivitySignIn.this, "Falta el apellido", Toast.LENGTH_SHORT).show();
        else if (email.getText().toString().isEmpty())
            Toast.makeText(ActivitySignIn.this, "Falta el mail", Toast.LENGTH_SHORT).show();
        else if (password.getText().toString().isEmpty()) {
            if (password.getText().equals(firstname.getText().toString()) || password.getText().length() < 5) {
                Toast.makeText(ActivitySignIn.this, "La contraseña no es valida", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(ActivitySignIn.this, "Falta la contraseña", Toast.LENGTH_SHORT).show();
        } else if (city.getText().toString().isEmpty())
            Toast.makeText(ActivitySignIn.this, "Falta la ciudad", Toast.LENGTH_SHORT).show();
        else if (state.getText().toString().isEmpty())
            Toast.makeText(ActivitySignIn.this, "Falta el estado", Toast.LENGTH_SHORT).show();
        else if (descrption.getText().toString().length() > 100)
            Toast.makeText(ActivitySignIn.this, "Descripción max(100)", Toast.LENGTH_SHORT).show();
        else if (gym.getText().toString().length() < 2)
            Toast.makeText(ActivitySignIn.this, "Muro no valido", Toast.LENGTH_SHORT).show();
        else return true;
        return false;
    }

    public void saveUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("mx.iteso.USER_PREFRENCES", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", email.getText().toString());
        editor.putString("PWD", password.getText().toString());
        editor.putBoolean("LOGGED", true);
        editor.apply();
    }
}
