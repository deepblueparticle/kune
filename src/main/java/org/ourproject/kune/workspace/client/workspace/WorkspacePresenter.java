/*
 *
 * Copyright (C) 2007 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * Kune is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kune is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.ourproject.kune.workspace.client.workspace;

import java.util.Iterator;

import org.ourproject.kune.platf.client.View;
import org.ourproject.kune.platf.client.dto.GroupDTO;
import org.ourproject.kune.platf.client.state.Session;
import org.ourproject.kune.platf.client.tool.ClientTool;
import org.ourproject.kune.workspace.client.component.WorkspaceComponent;
import org.ourproject.kune.workspace.client.i18n.I18nTranslatorComponent;
import org.ourproject.kune.workspace.client.i18n.LanguageSelectorComponent;
import org.ourproject.kune.workspace.client.license.LicenseComponent;

public class WorkspacePresenter implements Workspace {
    private WorkspaceView view;
    private WorkspaceComponent context;
    private WorkspaceComponent content;
    private WorkspaceUIComponents components;
    private final Session session;

    public WorkspacePresenter(final Session session) {
        this.session = session;
    }

    public void init(final WorkspaceView view) {
        this.view = view;
        this.components = new WorkspaceUIComponents(this);
        // FIXME: get components breaks test (because make calls to GWT)
        view.setContentTitle(components.getContentTitleComponent().getView());
        view.setContentSubTitle(components.getContentSubTitleComponent().getView());
        view.setContentToolBar(components.getContentToolBarComponent().getView());
        view.setContentBottomToolBar(components.getContentBottomToolBarComponent().getView());
        view.setBottom(components.getLicenseComponent().getView());
        view.setGroupMembers(components.getGroupMembersComponent().getView());
        view.setParticipation(components.getParticipationComponent().getView());
        view.setBuddiesPresence(components.getBuddiesPresenceComponent().getView());
        view.setTags(components.getTagsComponent().getView());
        view.setThemeMenuComponent(components.getThemeMenuComponent().getView());
        view.setUIExtensionPoints();
    }

    public void showError(final Throwable caught) {

    }

    public void showGroup(final GroupDTO group, final boolean isAdmin) {
        view.setGroupLogo(group.getLongName());
        view.setPutYourLogoVisible(isAdmin);
    }

    public void attachTools(final Iterator iterator) {
        ClientTool clientTool;
        while (iterator.hasNext()) {
            clientTool = (ClientTool) iterator.next();
            view.addTab(clientTool.getTrigger());
        }
    }

    public void setTool(final String toolName) {
        view.setTool(toolName);
    }

    public void setContext(final WorkspaceComponent contextComponent) {
        if (context != null) {
            context.detach();
        }
        context = contextComponent;
        context.attach();
        view.setContext(context.getView());
    }

    public void setContent(final WorkspaceComponent contentComponent) {
        if (content != null) {
            content.detach();
        }
        content = contentComponent;
        content.attach();
        view.setContent(content.getView());
    }

    public void adjustSize(final int windowWidth, final int clientHeight) {
        view.adjustSize(windowWidth, clientHeight);
    }

    public View getView() {
        return view;
    }

    public LicenseComponent getLicenseComponent() {
        return components.getLicenseComponent();
    }

    public ContentTitleComponent getContentTitleComponent() {
        return components.getContentTitleComponent();
    }

    public ContentSubTitleComponent getContentSubTitleComponent() {
        return components.getContentSubTitleComponent();
    }

    public GroupMembersComponent getGroupMembersComponent() {
        return components.getGroupMembersComponent();
    }

    public ParticipationComponent getParticipationComponent() {
        return components.getParticipationComponent();
    }

    public BuddiesPresenceComponent getBuddiesPresenceComponent() {
        return components.getBuddiesPresenceComponent();
    }

    public ThemeMenuComponent getThemeMenuComponent() {
        return components.getThemeMenuComponent();
    }

    public ContentBottomToolBarComponent getContentBottomToolBarComponent() {
        return components.getContentBottomToolBarComponent();
    }

    public TagsComponent getTagsComponent() {
        return components.getTagsComponent();
    }

    public GroupLiveSearchComponent getGroupLiveSearchComponent() {
        return components.getGroupLiveSearchComponent();
    }

    public I18nTranslatorComponent getI18nTranslatorComponent() {
        return components.getI18nTranslatorComponent(session);
    }

    public LanguageSelectorComponent getLanguageSelectorComponent() {
        return components.getLanguageSelectorComponent(session.getLanguagesArray());
    }

    public void setTheme(final String theme) {
        view.setTheme(theme);
    }

    public void setVisible(final boolean visible) {
        view.setVisible(visible);
    }

    public void attachToExtensionPoint(final String id, final View viewToAttach) {
        view.attachToExtensionPoint(id, viewToAttach);
    }

    public void detachFromExtensionPoint(final String id, final View viewToDetach) {
        view.detachFromExtensionPoint(id, viewToDetach);
    }

    public void clearExtensionPoint(final String id) {
        view.clearExtensionPoint(id);

    }
}
