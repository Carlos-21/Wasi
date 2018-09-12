package proyecto.aplicacion.wasi.wasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perfil extends AppCompatActivity implements View.OnClickListener{
    private Button botonApoderado;
    private Button botonMovilidad;
    private Button botonRecogedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        setTitle(R.string.cPerfil);

        botonApoderado = (Button)findViewById(R.id.botonApoderado);
        botonApoderado.setOnClickListener(this);
        botonMovilidad = (Button)findViewById(R.id.botonMovilidad);
        botonMovilidad.setOnClickListener(this);
        botonRecogedor = (Button)findViewById(R.id.botonRecogedor);
        botonRecogedor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.botonApoderado :  intent = new Intent(Perfil.this, Login.class);
                                        intent.putExtra("perfil", 1);
                                        break;
            case R.id.botonMovilidad :  intent = new Intent(Perfil.this, Login.class);
                                        intent.putExtra("perfil", 2);
                                        break;
            case R.id.botonRecogedor :  intent = new Intent(Perfil.this, Login.class);
                                        intent.putExtra("perfil", 3);
                                        break;
        }
        startActivity(intent);
    }
}
