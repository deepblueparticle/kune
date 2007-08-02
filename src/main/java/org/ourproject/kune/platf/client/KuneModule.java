package org.ourproject.kune.platf.client;

import org.ourproject.kune.platf.client.actions.InitAction;
import org.ourproject.kune.platf.client.dispatch.Dispatcher;
import org.ourproject.kune.platf.client.extend.ClientModule;
import org.ourproject.kune.platf.client.extend.Register;
import org.ourproject.kune.platf.client.workspace.actions.TabAction;

public class KuneModule implements ClientModule {
    public void configure(Register register) {
    }

    public void registerActions(Dispatcher dispatcher) {
	dispatcher.subscribe("init", new InitAction());
	dispatcher.subscribe("tab", new TabAction());
    }
}
