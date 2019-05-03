package br.com.alessanderleite.sqlitemvpapp.views.imp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alessanderleite.sqlitemvpapp.R;
import br.com.alessanderleite.sqlitemvpapp.presenters.PersonPresenterImp;
import br.com.alessanderleite.sqlitemvpapp.presenters.PersonPresenterInterface;
import br.com.alessanderleite.sqlitemvpapp.views.interfaces.MainActivityInterface;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    private PersonPresenterInterface personPresenter;
    private SharedPreferences sharedPreferences;
    Button submit;
    Button viewList;
    Button recyclerList;
    EditText name;
    EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IS_LOGGED_IN", true);

        editor.apply();

        //get SharedPrefences;

        Boolean isLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false);

        personPresenter = new PersonPresenterImp(this);

        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.adress);
        submit = (Button) findViewById(R.id.submit_registration);
        viewList = (Button) findViewById(R.id.list_person);
        recyclerList = (Button) findViewById(R.id.recycler_list);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personPresenter.addPersonAction(name.getText().toString(), address.getText().toString());
            }
        });

        viewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        recyclerList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void addPersonSuccess() {
        Toast.makeText(this, "Person successfully added!", Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void showValidationError(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addPersonError(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }
}
