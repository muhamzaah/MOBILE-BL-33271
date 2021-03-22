package umn.ac.id.uts_mhamzah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText eName;
    private EditText ePassword;
    private TextView eAttemptsInfo;
    private Button eLogin;
    private int counter = 5;

    String userName = "";
    String userPassword = "";


    class Credentials
    {
        String name = "uasmobile";
        String password = "uasmobilegenap";
    }

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);


        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                userName = eName.getText().toString();
                userPassword = ePassword.getText().toString();


                if(userName.isEmpty() || userPassword.isEmpty())
                {

                    Toast.makeText(MainActivity.this, "Please enter name and password!", Toast.LENGTH_LONG).show();

                }else {


                    isValid = validate(userName, userPassword);




                    if (!isValid) {


                        counter--;


                        eAttemptsInfo.setText("Attempts Remaining: " + String.valueOf(counter));


                        if (counter == 0) {
                            eLogin.setEnabled(false);
                            Toast.makeText(MainActivity.this, "You have used all your attempts try again later!", Toast.LENGTH_LONG).show();
                        }

                        else {
                            Toast.makeText(MainActivity.this, "Incorrect credentials, please try again!", Toast.LENGTH_LONG).show();
                        }
                    }

                    else {


                        startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                    }

                }
            }
        });
    }


    private boolean validate(String userName, String userPassword)
    {

        Credentials credentials = new Credentials();

        if(userName.equals(credentials.name) && userPassword.equals(credentials.password))
        {
            return true;
        }

        return false;
    }
}