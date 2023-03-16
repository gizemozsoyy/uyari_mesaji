package com.example.proje4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edittext;
TextView txtview;
SharedPreferences  sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences  sharedPreferences=this.getSharedPreferences("com.example.proje4", Context.MODE_PRIVATE);
      edittext =findViewById(R.id.editTextNumber);
      txtview=findViewById(R.id.textView);
     int storedage=   sharedPreferences.getInt("",0);
if(storedage==0){
    txtview.setText("");
}else {
    txtview.setText(""+storedage);
}

    }



 public void saved(View view){

         if (!edittext.getText().toString().matches("")) {
             int userage=Integer.parseInt(edittext.getText().toString());
             txtview.setText("age"+userage);
             sharedPreferences.edit().putInt("",userage).apply();

         }  }
        public void delete (View view){
             int storedData =sharedPreferences.getInt("",0);
         if (storedData!=0){
         sharedPreferences.edit().remove("").apply();
         txtview.setText("");
         }

 }
}