package main.java.com.solvd.database.services.designpatterns.listener;

import main.java.com.solvd.database.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListenersHolders {
    private static final List<IUserListener> listeners = new ArrayList<>();

    public static void subscribe(IUserListener userListener){
        listeners.add(userListener);
    }
    public static void unsubscribe(IUserListener userListener){
        listeners.remove(userListener);
    }

    public static void onNewUser(User user) {
        for (IUserListener listener : listeners) {
            listener.onNewUser(user);
        }
    }

    public static void onUserDeleted(User user) {
        for (IUserListener listener : listeners) {
            listener.onUserDeleted(user);
        }
    }
}
