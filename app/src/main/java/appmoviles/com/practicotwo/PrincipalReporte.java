package appmoviles.com.practicotwo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import appmoviles.com.practicotwo.Model.Usuario;

public class PrincipalReporte extends AppCompatActivity {

    private TextView mensaje;
    private TextView txt_spiderman;
    private TextView txt_ironman;
    private TextView txt_america;
    private TextView txt_marvel;
    private TextView txt_hulk;
    private TextView txt_viuda;
    private TextView txt_thor;
    private TextView txt_strange;

    private double total=0;
    private double spi=0;
    private double iro=0;
    private double ame=0;
    private double mar=0;
    private double hulk=0;
    private double viuda=0;
    private double thor=0;
    private double str=0;

    private RadioGroup grupos;
    private RadioButton grupo1;
    private RadioButton grupo2;
    private RadioButton grupo3;
    private RadioButton grupo4;
    private RadioButton grupo5;
    private RadioButton grupo6;

    private Button btn_sel;

    FirebaseDatabase rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_reporte);

        mensaje = findViewById(R.id.txt_mensaje);
        txt_spiderman = findViewById(R.id.txt_spiderman);
        txt_ironman = findViewById(R.id.txt_ironman);
        txt_america = findViewById(R.id.txt_america);
        txt_marvel = findViewById(R.id.txt_marvel);
        txt_hulk = findViewById(R.id.txt_hulk);
        txt_viuda = findViewById(R.id.txt_viuda);
        txt_thor = findViewById(R.id.txt_thor);
        txt_strange = findViewById(R.id.txt_strange);

        grupos = findViewById(R.id.opc_grupos);
        grupo1 = findViewById(R.id.radio_opcGrupo1);
        grupo2 = findViewById(R.id.radio_opcGrupo2);
        grupo3 = findViewById(R.id.radio_opcGrupo3);
        grupo4 = findViewById(R.id.radio_opcGrupo4);
        grupo5 = findViewById(R.id.radio_opcGrupo5);
        grupo6 = findViewById(R.id.radio_opcGrupo6);

        btn_sel = findViewById(R.id.btn_sel);

        rtdb = FirebaseDatabase.getInstance();

        rtdb.getReference().child("Usuarios").child("Todo el publico").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot hijo : dataSnapshot.getChildren()){
                    Usuario a = hijo.getValue(Usuario.class);
                    String heroe = a.getSuperheroe();
                    total++;
                    if(heroe.equals("Spiderman")){
                        spi++;
                    }else if(heroe.equals("Ironman")){
                        iro++;
                    }else if(heroe.equals("Capitan America")){
                        ame++;
                    }else if(heroe.equals("Capitana Marvel")){
                        mar++;
                    }else if(heroe.equals("Hulk")){
                        hulk++;
                    }else if(heroe.equals("La Viuda Negra")){
                        viuda++;
                    }else if(heroe.equals("Thor")){
                        thor++;
                    }else{
                        str++;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(grupo1.isChecked()){

                    rtdb.getReference().child("Usuarios").child("Todo el publico").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();
                                total++;
                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else if(grupo2.isChecked()){

                    rtdb.getReference().child("Usuarios").child("Mujeres adultas").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();
                                total++;
                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else if(grupo3.isChecked()){

                    rtdb.getReference().child("Usuarios").child("Hombres adultos").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();
                                total++;
                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else if(grupo4.isChecked()){

                    rtdb.getReference().child("Usuarios").child("Mujeres adolescentes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();
                                total++;
                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else if(grupo5.isChecked()){

                    rtdb.getReference().child("Usuarios").child("Hombres adolescentes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();
                                total++;
                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else{

                    rtdb.getReference().child("Usuarios").child("Niños").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for(DataSnapshot hijo : dataSnapshot.getChildren()){
                                Usuario a = hijo.getValue(Usuario.class);
                                String heroe = a.getSuperheroe();
                                total++;
                                if(heroe.equals("Spiderman")){
                                    spi++;
                                }else if(heroe.equals("Ironman")){
                                    iro++;
                                }else if(heroe.equals("Capitan America")){
                                    ame++;
                                }else if(heroe.equals("Capitana Marvel")){
                                    mar++;
                                }else if(heroe.equals("Hulk")){
                                    hulk++;
                                }else if(heroe.equals("La Viuda Negra")){
                                    viuda++;
                                }else if(heroe.equals("Thor")){
                                    thor++;
                                }else{
                                    str++;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


            }
        });

        if(total!=0){
            txt_spiderman.setText("Spiderman: " + spi/total );
            txt_ironman.setText("Ironman: " + iro/total);
            txt_america.setText("Capitan America: " + ame/total);
            txt_marvel.setText("Capitana Marvel: " + mar/total);
            txt_hulk.setText("Hulk: " + hulk/total);
            txt_viuda.setText("La Viuda Negra: "+ viuda/total);
            txt_thor.setText("Thor: "+ thor/total);
            txt_strange.setText("Doctor Strange: "+ str/total);
        }

    }
}
