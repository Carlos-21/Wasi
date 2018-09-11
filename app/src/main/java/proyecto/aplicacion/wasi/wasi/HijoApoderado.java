package proyecto.aplicacion.wasi.wasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import proyecto.aplicacion.wasi.wasi.Dato.Hijo;
import proyecto.aplicacion.wasi.wasi.Soporte.Adaptador;

public class HijoApoderado extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijo_apoderado);

        setTitle(R.string.cHijos);

        lista = (RecyclerView) findViewById(R.id.listaHijo);
        lista.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        lista.setLayoutManager(linearLayoutManager);

        Adaptador adaptador = new Adaptador(Hijo.listarHijos());
        adaptador.setOnClickListener(this);
        lista.setAdapter(adaptador);

    }

    @Override
    public void onClick(View view) {
        System.out.println("Nombre : "+Hijo.listarHijos().get(lista.getChildAdapterPosition(view)).getNombre());
        Intent intent = new Intent(HijoApoderado.this, Salida.class);
        intent.putExtra("foto", Hijo.listarHijos().get(lista.getChildAdapterPosition(view)).getNombre() + " " + Hijo.listarHijos().get(lista.getChildAdapterPosition(view)).getApellido());
        startActivity(intent);
    }
}
