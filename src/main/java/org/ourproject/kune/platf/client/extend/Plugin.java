package org.ourproject.kune.platf.client.extend;

import org.ourproject.kune.platf.client.services.I18nTranslationService;

public abstract class Plugin {
    private String name;
    private final boolean started;
    private UIExtensionPointManager extensionPointManager;
    private I18nTranslationService i18n;

    public Plugin(final String name) {
        this.name = name;
        this.started = false;
        // InitDataDTO...
    }

    protected void init(final UIExtensionPointManager extensionPointManager, final I18nTranslationService i18n) {
        this.extensionPointManager = extensionPointManager;
        this.i18n = i18n;
    }

    public final boolean isActive() {
        return started;
    }

    //
    // public final Dispatcher getDisplacher() {
    // return dispatcher;
    // }

    public final I18nTranslationService getI18n() {
        return i18n;
    }

    public UIExtensionPointManager getExtensionPointManager() {
        return extensionPointManager;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    protected abstract void start();

    protected abstract void stop();

}
