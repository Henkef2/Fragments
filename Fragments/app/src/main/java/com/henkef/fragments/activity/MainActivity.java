package com.henkef.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.henkef.fragments.R;
import com.henkef.fragments.fragment.ContatosFragment;
import com.henkef.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa, buttonContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContato = findViewById(R.id.buttonContato);
        buttonConversa = findViewById(R.id.buttonConversa);

        //Remover sombra da ActionBar (sombra que divide o nome do App dos botões convrsas e contatos)
        getSupportActionBar().setElevation(0);   //esse setElevation é como se o botão estivesse elevado acima do nome do App por isso cria uma sombra, ai quanto maior o numero maior será a sombra, se deixar 0 não haverá sombra.

        conversasFragment = new ConversasFragment();

        //Configurar objeto para o Fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace( R.id.frameConteudo, conversasFragment );  //obs: se utilizar o metodo add ele adiciona em cima do outro, se usar o metodo replace ele substitui um pelo outro
        transaction.commit();

        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();

            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();

            }
        });
    }
}