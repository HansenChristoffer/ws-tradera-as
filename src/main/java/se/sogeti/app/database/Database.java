package se.sogeti.app.database;

import se.sogeti.app.controllers.Controller;
import se.sogeti.app.models.dto.LinkDTO;

public class Database<T> {

    private Controller<T> controller;

    public Database() {
        this.controller = new Controller<>();
    }

    public LinkDTO fetchOpenLink() {
        return controller.getOpenLink();
    }

    public T postSingle(T object, String uri) {
        return controller.postSingle(object, uri);
    }

    public String callGet(String href) {
        return controller.callGet(href);
    }

    public void close() {
        this.controller = null;
    }

}
