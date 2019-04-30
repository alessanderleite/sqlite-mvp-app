package br.com.alessanderleite.sqlitemvpapp.views.interfaces;

import java.util.ArrayList;

import br.com.alessanderleite.sqlitemvpapp.models.Person;

public interface MainActivityInterface {

    void addPersonSuccess();

    void showValidationError(String info);

    void addPersonError(String info);
}
