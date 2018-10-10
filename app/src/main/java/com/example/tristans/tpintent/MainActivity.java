package com.example.tristans.tpintent;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    Activity lecontext;

    // Called when the activity is first created
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lecontext = this;
        //récupération du text dans le champ de saisie
        final EditText textchampsaisie = (EditText) findViewById(R.id.textPrincipal);
        Button btaction = (Button) findViewById(R.id.button2);
        //action sur le bouton click appelle de la nouvelle  activité
        btaction.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) { //création de notre item
                Intent defineIntent = new Intent(lecontext, activity_suivante.class);
                // objet qui vas nous permettre de passe des variables ici la variable passInfo
                Bundle objetbunble = new Bundle();
                objetbunble.putString("passInfo", textchampsaisie.getText().toString()); // on passe notre objet a notre activities
                defineIntent.putExtras(objetbunble);
                // on appelle notre activité
                //lecontext.startActivity(defineIntent);
                lecontext.startActivityForResult(defineIntent, 1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Si le résultat provient d’une demande de la fenêtre1
        if (requestCode == 1) { // le code retour est bon
            if (resultCode == 444444) { //récupérer les informations //et les afficher dans TextView
                Log.e("messageReturn ", "return");
                Bundle objetbunble = data.getExtras();
                String InfoPasse = objetbunble.getString("passInfo");
                EditText textchampsaisie = (EditText) findViewById(R.id.textPrincipal);
                textchampsaisie.setText(InfoPasse);
            }
        }
    }
}