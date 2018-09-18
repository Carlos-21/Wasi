package proyecto.aplicacion.wasi.wasi.Pestaña.Movilidad;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import proyecto.aplicacion.wasi.wasi.Dato.Hijo;
import proyecto.aplicacion.wasi.wasi.R;
import proyecto.aplicacion.wasi.wasi.Soporte.Adaptador;

public class EntregadoMovilidadFragment extends Fragment implements View.OnClickListener {
    private RecyclerView listaMovilidadHabilitados;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movilidad_entregado, container, false);

        listaMovilidadHabilitados = (RecyclerView) view.findViewById(R.id.listaMovilidadEntregado);
        listaMovilidadHabilitados.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        listaMovilidadHabilitados.setLayoutManager(linearLayoutManager);

        Adaptador adaptador = new Adaptador(Hijo.listarHijos());
        adaptador.setOnClickListener(this);
        listaMovilidadHabilitados.setAdapter(adaptador);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
