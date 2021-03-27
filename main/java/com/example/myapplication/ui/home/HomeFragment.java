package com.example.myapplication.ui.home;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.SharedPreferencesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.ui.dashboard.DashboardFragment;
import com.example.myapplication.ui.dashboard.DashboardViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment  {

//LinearLayout Visualizador;
//FloatingActionButton BtAdd;





    private HomeViewModel homeViewModel;

    public HomeFragment() {

    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Definindo os componentes para a view
        FloatingActionButton BtAdd = (FloatingActionButton) root.findViewById(R.id.BtAdd);
        LinearLayout Visualizador = (LinearLayout) root.findViewById(R.id.Visualizador);
        EditText NomeProd = (EditText) root.findViewById(R.id.NomeProd);
        EditText QtdProd = (EditText) root.findViewById(R.id.QtdProd);
        CheckBox Prc = (CheckBox) root.findViewById(R.id.Prc);
        Button BtSalvar = (Button) root.findViewById(R.id.BtSalvar);
        TextView Tv1 = (TextView) root.findViewById(R.id.Tv1);
        TextView info = (TextView) root.findViewById(R.id.info);
        // --------------------------------

        // Adicinando listener ao botão
        BtAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Visualizador.setVisibility(View.VISIBLE);
                BtAdd.setVisibility(View.GONE);
                info.setVisibility(View.INVISIBLE);
                // Parte responsável pelo clique do botão
            }
        });

        BtSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  NomeProd.getText().toString();
                  QtdProd.getText().toString();



            }
        });

        











        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {




            @Override
            public void onChanged(@Nullable String s) {
                info.setText(s);
            }










        });
        return root;

    }


}