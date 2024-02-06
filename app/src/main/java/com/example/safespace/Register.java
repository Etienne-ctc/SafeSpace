package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import backend.User;

public class Register extends AppCompatActivity {
    private EditText prenom;
    private EditText nom;
    private EditText log;
    private EditText mdp;
    private EditText mdp_check;
    private Button valider;
    private Button switch_button;
    private Button diplome;
    private Boolean mode = Boolean.FALSE; // False pour patient et True pour pro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        prenom = findViewById(R.id.prenom_editTextText);
        nom = findViewById(R.id.nom_editTextText);

        log = findViewById(R.id.login_editTextText);
        mdp = findViewById(R.id.mdp_editText);
        mdp_check = findViewById(R.id.mdp_check_editText);

        diplome = findViewById(R.id.diplome_button);
        diplome.setVisibility(View.GONE);

        valider = findViewById(R.id.valider_button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mdp.getText().toString().equals(mdp_check.getText().toString())){
                    User user;
                    if(mode.equals(Boolean.FALSE)) {
                        user = new User(String.valueOf(nom.getText()), String.valueOf(prenom.getText()),
                                String.valueOf(log.getText()), String.valueOf(mdp.getText()), false);
                    }
                    else if(mode.equals(Boolean.TRUE)){
                        user = new User(String.valueOf(nom.getText()), String.valueOf(prenom.getText()),
                                String.valueOf(log.getText()), String.valueOf(mdp.getText()), true);
                    }
                    Intent back_intent = new Intent(Register.this, MainActivity.class);
                    startActivity(back_intent);
                }
                else {
                    Toast.makeText(Register.this, "Les mots de passes doivent être égaux", Toast.LENGTH_LONG).show();
                }
            }
        });

        switch_button = findViewById(R.id.switch_button);
        switch_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mode = Boolean.TRUE;
                diplome.setVisibility(View.VISIBLE);
                switch_button.setVisibility(View.GONE);
                createOnClickPhotoButton();
            }
        });
    }

    public void createOnClickPhotoButton(){
        diplome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 1);
            }
        });
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent data){
        super.onActivityResult(RequestCode, ResultCode, data);
        if(RequestCode==1 && ResultCode==RESULT_OK){
            Uri selectedImage = data.getData();
            String[] filepathname = new String[]{MediaStore.Images.Media.DATA};
            // String[] filepathname = [MediaStore.Images.Media.DATA];
            Cursor cursor = this.getContentResolver().query(selectedImage, filepathname, null, null, null);
            cursor.moveToFirst();
            int colIndex = cursor.getColumnIndex(filepathname[0]);
            String imgPath = cursor.getString(colIndex);
            cursor.close();
            Bitmap image = BitmapFactory.decodeFile(imgPath);
            // Send to BDD
        }
        else {
            Toast.makeText(this, "Aucune image selectionnée", Toast.LENGTH_LONG).show();
        }
    }

}