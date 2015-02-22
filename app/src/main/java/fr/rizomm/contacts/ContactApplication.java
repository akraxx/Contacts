package fr.rizomm.contacts;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Maximilien on 22/02/2015.
 */
public class ContactApplication extends Application {
    private ObjectGraph graph;

    @Override public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new ContactModule(this)
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
