package proyecto.aplicacion.wasi.wasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Apoderado extends AppCompatActivity implements View.OnClickListener{
    private Button permitirSalida;
    private Button asignarRecogedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoderado);

        permitirSalida = (Button)findViewById(R.id.botonPermitirSalida);
        permitirSalida.setOnClickListener(this);
        asignarRecogedor = (Button)findViewById(R.id.botonAsignarRecogedor);
        asignarRecogedor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.botonPermitirSalida : intent = new Intent(Apoderado.this, HijoApoderado.class);
                                            break;
        }
        startActivity(intent);
        finish();
    }

}
