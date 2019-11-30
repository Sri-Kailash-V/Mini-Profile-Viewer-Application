package com.example.alliancefacultyportal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileClass extends AppCompatActivity {
    private ImageView V_image;
    private TextView V_name, V_desig, V_mail, V_descri;
    private Button Document, Video;
    public String name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileclassxml);

        int image = getIntent().getIntExtra("P_image", 0);
        V_image = (ImageView) findViewById(R.id.Profileimage);
        V_image.setImageResource(image);

        name = getIntent().getStringExtra("P_name");
        V_name = findViewById(R.id.Profilename);
        V_name.setText(name);

        int designation = getIntent().getIntExtra("P_designation", 0);
        V_desig = findViewById(R.id.Profiledesignation);
        V_desig.setText(designation);

        int mail = getIntent().getIntExtra("P_mail", 0);
        V_mail = findViewById(R.id.Profilemail);
        V_mail.setText(mail);

        int description = getIntent().getIntExtra("P_description", 0);
        V_descri = findViewById(R.id.Profiledescribe);
        V_descri.setText(description);

        Document = (Button) findViewById(R.id.Documentbutton);
        Document.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileClass.this, DocumentClass.class);
                intent.putExtra("P_name", name);
                startActivity(intent);
            }
        });

        Video = (Button) findViewById(R.id.Videobutton);
        Video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ProfileClass.this, VideoClass.class);
                intent.putExtra("P_name", name);
                startActivity(intent);
            }
        });
    }
}