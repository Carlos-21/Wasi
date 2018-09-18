package proyecto.aplicacion.wasi.wasi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import proyecto.aplicacion.wasi.wasi.Soporte.Mensaje;

public class Salida extends AppCompatActivity implements View.OnClickListener{
    private ImageView foto;
    private String urlFoto;
    private Button botonSalida;
    private Button botonMovilidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salida);

        foto = (ImageView) findViewById(R.id.fotoHijoSalida);

        botonSalida = (Button)findViewById(R.id.botonSalida);
        botonSalida.setOnClickListener(this);

        botonMovilidad = (Button)findViewById(R.id.botonPermitirMovilidad);
        botonMovilidad.setOnClickListener(this);

        mostrarHijo();
    }

    /**
     * Método encargado de mostrar los datos del hijo seleccionado en la
     * actividad 'activity_hijo_apoderado'
     */
    private void mostrarHijo(){
        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){

            urlFoto = (String)bun.getString("foto");
            setTitle(urlFoto);
            foto.setImageResource(R.drawable.hijo);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonSalida : autorizarSalidaApoderado();
                                    break;
            case R.id.botonPermitirMovilidad : autorizarSalidaMovilidad();
                                               break;
        }
    }

    /**
     * Definir documentación
     */
    private void autorizarSalidaApoderado(){
        Mensaje.nombre = urlFoto;
        AlertDialog.Builder builder = new AlertDialog.Builder(Salida.this);
        builder.setTitle(Mensaje.tituloPermitirSalida);
        builder.setMessage(Mensaje.mensajePermitirSalida.replace("paramN", Mensaje.nombre));
        builder.setCancelable(false);
        builder.setIcon(R.drawable.informacion);

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Salida.this, SalidaPermitida.class);
                intent.putExtra("salida",1);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //No se hace nada
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * Definir documentación
     */
    private void autorizarSalidaMovilidad(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Salida.this);
        builder.setTitle(Mensaje.tituloPermitirMovilidad);
        builder.setMessage(Mensaje.mensajePermitirMovilidad);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.informacion);

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Salida.this, SalidaPermitida.class);
                intent.putExtra("salida",2);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //No se hace nada
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
