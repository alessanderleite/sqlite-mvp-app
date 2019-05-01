package br.com.alessanderleite.sqlitemvpapp.presenters;

import android.content.Context;

import java.util.ArrayList;

import br.com.alessanderleite.sqlitemvpapp.infrastructure.helper.DatabaseHelper;
import br.com.alessanderleite.sqlitemvpapp.models.Person;
import br.com.alessanderleite.sqlitemvpapp.views.interfaces.MainActivityInterface;

public class PersonPresenterImp implements PersonPresenterInterface {

    private MainActivityInterface mainActivity;
    DatabaseHelper dbHelper;

    public PersonPresenterImp(MainActivityInterface main) {
        this.mainActivity = main;
    }

    @Override
    public void addPersonAction(String name, String address) {

        Person person = new Person(name, address);
        try {
            dbHelper = new DatabaseHelper((Context) mainActivity);
            dbHelper.addPerson(person);
            mainActivity.addPersonSuccess();
        } catch (Exception e) {
            mainActivity.addPersonError(e.getMessage());
        }
    }

    @Override
    public void deletePersonAction(int id) {

    }

    @Override
    public void updatePersonAction(int id, String name, String address) {

    }

    @Override
    public void viewAllRegisteredAction() {
        dbHelper = new DatabaseHelper((Context) mainActivity);
        ArrayList<Person> arrayList = dbHelper.getAll();

        if (arrayList.size() > 0) {
            Person person = arrayList.get(2);
            System.out.println(person.getName()+ "," + person.getAddress());
        }
    }
}
