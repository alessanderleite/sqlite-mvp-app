package br.com.alessanderleite.sqlitemvpapp.presenters;

import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alessanderleite.sqlitemvpapp.R;
import br.com.alessanderleite.sqlitemvpapp.infrastructure.adapter.PersonAdapter;
import br.com.alessanderleite.sqlitemvpapp.infrastructure.helper.DatabaseHelper;
import br.com.alessanderleite.sqlitemvpapp.models.Person;
import br.com.alessanderleite.sqlitemvpapp.views.interfaces.ListViewActivityInterface;

public class PersonListImp implements PersonListInterface {
    private ListViewActivityInterface listViewActivityInterface;
    private DatabaseHelper dbHelper;
    public PersonAdapter personAdapter;
    private ListView listView;

    public PersonListImp(ListViewActivityInterface listViewActivityInterface, ListView listView) {
        this.listViewActivityInterface = listViewActivityInterface;
        this.listView = listView;
    }

    @Override
    public void showAllPerson() {
        dbHelper = new DatabaseHelper((Context) listViewActivityInterface);
        ArrayList<Person> arrayList = dbHelper.getAll();

        try {
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    Person person = arrayList.get(i);
                    listViewActivityInterface.getListPerson().add(person);
                }
            }

            personAdapter = new PersonAdapter((Context) listViewActivityInterface, R.layout.view_item_layout, listViewActivityInterface.getListPerson());

            listView.setAdapter(personAdapter);
        } catch (Exception e) {
            listViewActivityInterface.errorData(e.getMessage());
        }
    }

    @Override
    public void viewAllRegisteredAction() {
        dbHelper = new DatabaseHelper((Context) listViewActivityInterface);
        ArrayList<Person> arrayList = dbHelper.getAll();

        if (arrayList.size() > 0) {
            Person person = arrayList.get(2);
            System.out.println(person.getName() + "," + person.getAddress());
        }
    }

}
