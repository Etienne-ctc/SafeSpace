package com.example.safespace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.StringUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import backend.*;

public class HumeurPatient extends AppCompatActivity {
    private SeekBar humeur;

    CheckBox dep;
    private CheckBox tri;
    private CheckBox anx;
    private CheckBox sol;
    private CheckBox iso;
    private CheckBox fat;
    private CheckBox enn;
    private CheckBox str;
    private CheckBox con;
    private CheckBox irr;
    private CheckBox cal;
    private CheckBox rep;
    private CheckBox ene;
    private CheckBox heu;
    private CheckBox apa;

    private EditText comm1;

    private CheckBox spo;
    private CheckBox fam;
    private CheckBox tra;
    private CheckBox dor;
    private CheckBox repos;
    private CheckBox art;
    private CheckBox lec;
    private CheckBox bal;
    private CheckBox men;

    private EditText comm2;

    private Button valider;

    private Integer seekBar_res;

    private List<String> pourquoi;
    private List<CheckBox> tab_pourquoi;
    private String pourquoi_to_bdd;

    private List<String> activites;
    private List<CheckBox> tab_activites;
    private String activites_to_bdd;

    private String comm_pourquoi;
    private String comm_activites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humeur_patient);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Patient patient = new Patient(id);

        pourquoi = new ArrayList<String>();
        tab_pourquoi = new ArrayList<CheckBox>();
        activites = new ArrayList<String>();
        tab_activites = new ArrayList<CheckBox>();

        humeur = findViewById(R.id.qualite_sommeil_seekBar);
        seekBar_res = humeur.getProgress();

        dep = findViewById(R.id.dep_checkBox26);
        tri = findViewById(R.id.tri_checkBox27);
        anx = findViewById(R.id.anx_checkBox22);
        sol = findViewById(R.id.sol_checkBox29);
        iso = findViewById(R.id.iso_checkBox25);

        fat = findViewById(R.id.fat_checkBox30);
        enn = findViewById(R.id.enn_checkBox31);
        str = findViewById(R.id.str_checkBox17);
        con = findViewById(R.id.con_checkBox18);
        irr = findViewById(R.id.irr_checkBox33);

        cal = findViewById(R.id.cal_checkBox34);
        rep = findViewById(R.id.rep_checkBox35);
        ene = findViewById(R.id.ene_checkBox36);
        heu = findViewById(R.id.heu_checkBox37);
        apa = findViewById(R.id.apa_checkBox38);

        comm1 = findViewById(R.id.commentaire_sommeil_editTextText2);
        comm_pourquoi = String.valueOf(comm1.getText());

        spo = findViewById(R.id.spo_checkBox41);
        fam = findViewById(R.id.fam_checkBox42);
        tra = findViewById(R.id.tra_checkBox14);

        dor = findViewById(R.id.dor_checkBox44);
        repos = findViewById(R.id.repos_checkBox45);
        art = findViewById(R.id.art_checkBox46);

        lec = findViewById(R.id.lec_checkBox47);
        bal = findViewById(R.id.bal_checkBox48);
        men = findViewById(R.id.men_checkBox40);

        comm2 = findViewById(R.id.commentaire_sommeil_editTextText);
        comm_activites = String.valueOf(comm2.getText());

        valider = findViewById(R.id.valider_humeur_button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initComponents();
                gatherInfos();

                if(comm_pourquoi != null){
                    // Send to BDD
                }

                if(comm_activites != null){
                    // Send to BDD
                }

                Calendar calendar = Calendar.getInstance();
                Date aujDate = new Date(calendar.getTimeInMillis());

                Mood mood = new Mood(seekBar_res, aujDate, pourquoi_to_bdd, activites_to_bdd);
                patient.addMood(mood);

                Intent back_intent = new Intent(HumeurPatient.this, HomePatient.class);
                back_intent.putExtra("id", id);
                startActivity(back_intent);
            }
        });
    }

    private void initComponents(){
        // tab_pourquoi
        tab_pourquoi.add(dep);
        tab_pourquoi.add(tri);
        tab_pourquoi.add(anx);
        tab_pourquoi.add(sol);
        tab_pourquoi.add(iso);

        tab_pourquoi.add(fat);
        tab_pourquoi.add(enn);
        tab_pourquoi.add(str);
        tab_pourquoi.add(con);
        tab_pourquoi.add(irr);

        tab_pourquoi.add(cal);
        tab_pourquoi.add(rep);
        tab_pourquoi.add(ene);
        tab_pourquoi.add(heu);
        tab_pourquoi.add(apa);

        // tab_activites
        tab_activites.add(spo);
        tab_activites.add(fam);
        tab_activites.add(tra);

        tab_activites.add(dor);
        tab_activites.add(repos);
        tab_activites.add(art);

        tab_activites.add(lec);
        tab_activites.add(bal);
        tab_activites.add(men);
    }

    private void gatherInfos(){
        // Gather why informations
        if(tab_pourquoi != null){
            for (CheckBox c : tab_pourquoi) {
                if(c.isChecked()){
                    pourquoi.add(c.getText().toString());
                }
            }
            pourquoi_to_bdd = StringUtils.join(pourquoi, ",");
        }

        // Gather activities informations
        if(tab_activites != null){
            for (CheckBox c : tab_activites) {
                if(c.isChecked()){
                    activites.add(c.getText().toString());
                }
            }
            activites_to_bdd = StringUtils.join(activites, ",");
        }
    }
}