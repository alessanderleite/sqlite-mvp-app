package br.com.alessanderleite.sqlitemvpapp.views.interfaces;

import java.util.ArrayList;

import br.com.alessanderleite.sqlitemvpapp.models.Person;

public interface ListViewActivityInterface {

    void errorData(String exception);

    String[] getNamePerson();

    ArrayList<Person> getListPerson();

    void setListPerson();
}
