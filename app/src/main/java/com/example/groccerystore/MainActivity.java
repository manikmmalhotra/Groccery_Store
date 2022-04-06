package com.example.groccerystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.groccerystore.Fragments.HomeFragment;
import com.example.groccerystore.Fragments.MoreFragment;
import com.example.groccerystore.Fragments.NotifFragment;
import com.example.groccerystore.Fragments.PlayerFragment;
import com.example.groccerystore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.player:
                    replaceFragment(new PlayerFragment());
                    break;
                case R.id.notif:
                    replaceFragment(new NotifFragment());
                    break;
                case R.id.more:
                    replaceFragment(new MoreFragment());
                    break;

            }

            return true;
        });
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}