/*
 *
 * Copyright (C) 2007-2015 Licensed to the Comunes Association (CA) under
 * one or more contributor license agreements (see COPYRIGHT for details).
 * The CA licenses this file to you under the GNU Affero General Public
 * License version 3, (the "License"); you may not use this file except in
 * compliance with the License. This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package cc.kune.gspace.client.share.items.actions;

import cc.kune.common.shared.i18n.I18n;
import cc.kune.core.client.resources.iconic.IconicResources;
import cc.kune.core.client.rpcservices.ContentServiceHelper;
import cc.kune.gspace.client.share.items.ShareItemDescriptor;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class ContentEditableShareItemDescriptor extends ShareItemDescriptor {
  public static class MakeContentNoEditableAction extends AbstractMakeContentEditableAction {
    @Inject
    MakeContentNoEditableAction(final Provider<ContentServiceHelper> helper) {
      super(false, helper);
    }
  }

  @Singleton
  public static class MakeContentNoEditableMenuItem extends AbstractToggleShareMenuItem {
    @Inject
    public MakeContentNoEditableMenuItem(final MakeContentNoEditableAction action,
        final IconicResources icons) {
      super(action);
      withIcon(icons.noWorld()).withText(I18n.t("Don't allow edit by everyone"));
    }
  }

  @Inject
  public ContentEditableShareItemDescriptor(final IconicResources icons,
      final MakeContentNoEditableMenuItem makeListPublic) {
    super(icons.world(), I18n.tWithNT("Anyone", "with initial uppercase"), I18n.t("can edit"),
        makeListPublic);
  }
}