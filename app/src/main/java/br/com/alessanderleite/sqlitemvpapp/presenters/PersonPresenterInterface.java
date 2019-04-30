package br.com.alessanderleite.sqlitemvpapp.presenters;

public interface PersonPresenterInterface {

    void addPersonAction(String name, String address);

    void deletePersonAction(int id);

    void updatePersonAction(int id, String name, String address);

    void viewAllRegisteredAction();
}
