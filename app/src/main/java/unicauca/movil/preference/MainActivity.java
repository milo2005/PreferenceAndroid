package unicauca.movil.preference;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.preference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(this);

        preferences = getSharedPreferences("preferencias", MODE_PRIVATE);

    }

    public void save(){
        String info = binding.info.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("info", info);
        editor.apply();

    }

    public void show(){
        String info =  preferences.getString("info","");
        binding.data.setText(info);
    }
}
