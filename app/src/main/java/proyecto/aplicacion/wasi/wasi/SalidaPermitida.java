package proyecto.aplicacion.wasi.wasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import proyecto.aplicacion.wasi.wasi.Soporte.Fecha;
import proyecto.aplicacion.wasi.wasi.Soporte.Mensaje;

public class SalidaPermitida extends AppCompatActivity {
    private ImageView foto;
    private TextView mensajeSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salida_permitida);

        foto = (ImageView) findViewById(R.id.fotoHijoSalida2);
        mensajeSalida = (TextView)findViewById(R.id.mensajeSalida);

        mostrarFoto();
    }

    /**
     * Definir documentación y definir método
     */
    private void mostrarFoto(){
        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){
            int tipoSalida = (int)bun.getInt("salida");
            if(tipoSalida == 1){
                setTitle("Permitir Salida");
            }
            else{
                setTitle("Permitir Movilidad");
            }
        }

        Mensaje.hora = Fecha.horaActual();
        Mensaje.fecha = Fecha.fechaActual();

        foto.setImageResource(R.drawable.hijo);
        mensajeSalida.setText(Mensaje.mensajeSalida.replace("paramH", Mensaje.hora).replace("paramD", Mensaje.fecha));
    }
}
