package cc.kune.common.client.actions.ui.descrip;

import cc.kune.common.client.actions.AbstractAction;
import cc.kune.common.client.actions.Action;
import cc.kune.common.client.actions.BaseAction;

import com.google.gwt.resources.client.ImageResource;

public class MenuDescriptor extends AbstractGuiActionDescrip {

    public static final String MENU_CLEAR = "menuclear";
    public static final String MENU_HIDE = "hidemenu";
    public static final String MENU_ONHIDE = "menuonhide";
    public static final String MENU_ONSHOW = "menuonshow";
    public static final String MENU_SHOW = "showmenu";
    public static final String MENU_SHOW_NEAR_TO = "showmenunearto";
    protected static final String MENU_STANDALONE = "menustandalone";

    public MenuDescriptor() {
        this(new BaseAction(null, null));
    }

    public MenuDescriptor(final AbstractAction action) {
        this(NO_PARENT, action);
    }

    public MenuDescriptor(final AbstractGuiActionDescrip parent, final AbstractAction action) {
        super(action);
        setParent(parent);
        putValue(MENU_HIDE, false);
        putValue(MENU_SHOW, false);
        putValue(MENU_CLEAR, false);
        putValue(MENU_STANDALONE, false);
    }

    public MenuDescriptor(final String text) {
        this(new BaseAction(text, null));
    }

    public MenuDescriptor(final String text, final ImageResource icon) {
        this(new BaseAction(text, null, icon));
    }

    public MenuDescriptor(final String text, final String tooltip) {
        this(new BaseAction(text, tooltip));
    }

    public MenuDescriptor(final String text, final String tooltip, final ImageResource icon) {
        this(new BaseAction(text, tooltip, icon));
    }

    public MenuDescriptor(final String text, final String tooltip, final String icon) {
        this(new BaseAction(text, tooltip, icon));
    }

    public void clear() {
        // Action detects changes in values, then we fire a change (whatever) to
        // fire this method in the UI
        putValue(MENU_CLEAR, !((Boolean) getValue(MENU_CLEAR)));
    }

    @Override
    public Class<?> getType() {
        return MenuDescriptor.class;
    }

    public void hide() {
        putValue(MENU_HIDE, !((Boolean) getValue(MENU_HIDE)));
    }

    public boolean isStandalone() {
        return (Boolean) super.getValue(MENU_STANDALONE);
    }

    /**
     * Sets the standalone property (if the menu should have button (for a
     * toolbar) or is a menu independent.
     * 
     * @param standalone
     *            the new standalone
     */
    public void setStandalone(final boolean standalone) {
        putValue(MENU_STANDALONE, standalone);
    }

    public void setText(final String text) {
        putValue(Action.NAME, text);
    }

    /**
     * Show the menu near the Element object specified
     * 
     * @param object
     *            the element to show menu near of it
     */
    public void show(final Object object) {
        putValue(MENU_SHOW_NEAR_TO, object);
        putValue(MENU_SHOW, !((Boolean) getValue(MENU_SHOW)));
    }

    /**
     * Show the menu near the position specified
     * 
     * @param position
     *            the position to show menu near of it
     */
    public void show(final Position position) {
        putValue(MENU_SHOW_NEAR_TO, position);
        putValue(MENU_SHOW, !((Boolean) getValue(MENU_SHOW)));
    }

    /**
     * Show the menu near the Element id specified
     * 
     * @param id
     *            the element id to show menu near of it
     */
    public void show(final String id) {
        putValue(MENU_SHOW_NEAR_TO, id);
        putValue(MENU_SHOW, !((Boolean) getValue(MENU_SHOW)));
    }
}