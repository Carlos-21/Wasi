package proyecto.aplicacion.wasi.wasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Salida extends AppCompatActivity implements View.OnClickListener{
    private ImageView foto;
    private String urlFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salida);

        foto = (ImageView) findViewById(R.id.fotoHijoSalida);
        mostrarHijo();
    }

    @Override
    public void onClick(View view) {

    }

    private void mostrarHijo(){
        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){

            urlFoto = (String)bun.getString("foto");
            setTitle(urlFoto);
            foto.setImageResource(R.drawable.hijo);
        }
    }

}
