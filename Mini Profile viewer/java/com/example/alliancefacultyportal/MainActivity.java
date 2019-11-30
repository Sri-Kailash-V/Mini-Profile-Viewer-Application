package com.example.alliancefacultyportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private ImageButton Login;
    private EditText Password;
    private TextView Info;
    private int Proceed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.loginid);
        Password = (EditText) findViewById(R.id.loginpass);
        Login = (ImageButton) findViewById(R.id.loginbutton);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String username, String password) {
        Intent intent = new Intent(MainActivity.this, ProfileClass.class);
        if ((username.equals("Radha")) && (password.equals("1234"))) {
            intent.putExtra("P_image", R.drawable.radha);
            intent.putExtra("P_name", username);
            intent.putExtra("P_designation", R.string.radhades);
            intent.putExtra("P_mail", R.string.radhamail);
            intent.putExtra("P_description", R.string.radhadescri);
            Proceed = 1;
        } else if ((username.equals("Srinatha")) && (password.equals("2345"))) {
            intent.putExtra("P_image", R.drawable.srinatha);
            intent.putExtra("P_name", username);
            intent.putExtra("P_designation", R.string.srinathades);
            intent.putExtra("P_mail", R.string.srinathamail);
            intent.putExtra("P_description", R.string.srinathadescri);
            Proceed = 1;
        } else if ((username.equals("Bhoomika")) && (password.equals("3456"))) {
            intent.putExtra("P_image", R.drawable.bhoomika);
            intent.putExtra("P_name", username);
            intent.putExtra("P_designation", R.string.bhoomikades);
            intent.putExtra("P_mail", R.string.bhoomikamail);
            intent.putExtra("P_description", R.string.bhoomikadescri);
            Proceed = 1;
        } else if ((username.equals("Vijayalakshmi")) && (password.equals("4567"))) {
            intent.putExtra("P_image", R.drawable.vijayalakshmi);
            intent.putExtra("P_name", username);
            intent.putExtra("P_designation", R.string.vijayalakshmides);
            intent.putExtra("P_mail", R.string.vijayalakshmimail);
            intent.putExtra("P_description", R.string.vijayalakshmidescri);
            Proceed = 1;
        } else if ((username.equals("Shekar")) && (password.equals("5678"))) {
            intent.putExtra("P_image", R.drawable.shekhar);
            intent.putExtra("P_name", username);
            intent.putExtra("P_designation", R.string.shekhardes);
            intent.putExtra("P_mail", R.string.shekharmail);
            intent.putExtra("P_description", R.string.shekhardescri);
            Proceed = 1;
        } else {
            Toast.makeText(this, "Inavlid user name and password ", Toast.LENGTH_SHORT).show();
        }
        if (Proceed == 1) {
            Name.setText("");
            Password.setText("");
            startActivity(intent);
        }
    }
}