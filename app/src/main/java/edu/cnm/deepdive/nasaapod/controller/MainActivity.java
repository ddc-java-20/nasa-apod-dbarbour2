package edu.cnm.deepdive.nasaapod.controller;

import android.os.Bundle;

import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.nasaapod.R;
import edu.cnm.deepdive.nasaapod.databinding.ActivityMainBinding;
import edu.cnm.deepdive.nasaapod.model.entity.Apod;
import edu.cnm.deepdive.nasaapod.viewmodel.ApodViewModel;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
  
  private ActivityMainBinding binding;
  private ApodViewModel viewModel;
  private static final String TAG = MainActivity.class.getSimpleName();
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    // TODO: 2/26/2025 attach listeners to view widgets (fields in binding)
    // TODO: 2/26/2025 update state of view widgets
    setContentView(binding.getRoot());
    viewModel = new ViewModelProvider(this).get(ApodViewModel.class);
    viewModel
        .getApod()
        .observe(this, (apod) ->
            Log.d(TAG, "onChanged: " + apod));
    viewModel.setToday();
  }



}