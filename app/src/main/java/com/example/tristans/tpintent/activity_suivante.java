package com.example.tristans.tpintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_suivante extends Activity {

    Activity lecontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivante);
        lecontext = this;
        //lecontext.setTitle("fenetre 2");
        //récupération du text dans le champ de saisie

        final EditText textchampsaisie = (EditText) findViewById(R.id.textSecondaire);
        Bundle objetbunble = this.getIntent().getExtras();
        // récupération de la valeur
        //String InfoPasse=objetbunble.description() ;
        String InfoPasse = objetbunble.getString("passInfo");
        // on afffiche l'information dans l'edittext

        textchampsaisie.setText(InfoPasse);

        Button btaction = (Button) findViewById(R.id.returnButton);
        //action sur le bouton click appelle de la nouvelle  activité
        btaction.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Log.d("button", "click");

                Intent defineIntent = new Intent(lecontext, MainActivity.class);
                // objet qui vas nous permettre de passe des variables ici la variable passInfo
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", textchampsaisie.getText().toString()); // on passe notre objet a notre activities
                defineIntent.putExtras(objetbunble);
                setResult(444444, defineIntent);
                //Demande la destruction de la fenêtre courante.
                finish();
            }
        });
    }
}
