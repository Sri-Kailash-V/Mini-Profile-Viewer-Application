package com.example.alliancefacultyportal;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class DocumentClass extends AppCompatActivity {
    Spinner spinner;
    String[] SPINNERVALUES = {"Pdf1", "Pdf2", "Pdf3"};
    String SpinnerValue;
    Button Documentview;
    private int position = 0;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.documentclassxml);
        name = getIntent().getStringExtra("P_name").toLowerCase();
        spinner = (Spinner) findViewById(R.id.DocumentSelecter);
        Documentview = (Button) findViewById(R.id.Documentbutton);
        final PDFView pdf = (PDFView) findViewById(R.id.PdfView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SPINNERVALUES);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerValue = (String) spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        Documentview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = name.concat(SpinnerValue);
                pdf.fromAsset(str.concat(".pdf")).load();
            }
        });
    }
}