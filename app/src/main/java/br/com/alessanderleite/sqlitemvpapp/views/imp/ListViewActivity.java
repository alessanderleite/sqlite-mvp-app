package br.com.alessanderleite.sqlitemvpapp.views.imp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.alessanderleite.sqlitemvpapp.R;
import br.com.alessanderleite.sqlitemvpapp.infrastructure.adapter.PersonAdapter;
import br.com.alessanderleite.sqlitemvpapp.models.Person;
import br.com.alessanderleite.sqlitemvpapp.presenters.PersonListImp;
import br.com.alessanderleite.sqlitemvpapp.presenters.PersonListInterface;
import br.com.alessanderleite.sqlitemvpapp.views.interfaces.ListViewActivityInterface;

public class ListViewActivity extends AppCompatActivity implements ListViewActivityInterface {

    private PersonListInterface personListInterface;

    private ArrayList<Person> listPerson = new ArrayList<>();
    private String[] namePerson;

    private ListView listView;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        personListInterface = new PersonListImp(ListViewActivity.this, listView);
        personListInterface.showAllPerson();
    }

    @Override
    public void errorData(String exception) {
        Toast.makeText(this, exception, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String[] getNamePerson() {
        return this.namePerson;
    }

    @Override
    public ArrayList<Person> getListPerson() {
        return this.listPerson;
    }

    @Override
    public void setListPerson() {

    }
}
