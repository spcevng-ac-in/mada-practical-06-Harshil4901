package com.example.practical5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;
    Button btn3;
    EditText editText;
    EditText editText2;
    EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url= editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.putExtra("","");
                startActivity(intent);
            }
        });
        editText2 = findViewById(R.id.editText2);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc = editText2.getText().toString();
                Uri addressUri =Uri.parse("geo:0,0?"+loc).buildUpon().appendQueryParameter("q",loc).build();
                Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
                intent.putExtra("","");
                startActivity(intent);
            }
        });
        editText3 = findViewById(R.id.editText3);
        btn3 = findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String share = editText3.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, ""+share);
                intent.setType("text/plain");
                Intent intent1 = Intent.createChooser(intent, null);
                startActivity(intent);
            }
        });


    }
}