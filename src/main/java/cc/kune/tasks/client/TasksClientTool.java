/*
 *
 * Copyright (C) 2007-2009 The kune development team (see CREDITS for details)
 * This file is part of kune.
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
package cc.kune.tasks.client;

import static cc.kune.tasks.shared.TasksConstants.NAME;
import static cc.kune.tasks.shared.TasksConstants.ROOT_NAME;
import static cc.kune.tasks.shared.TasksConstants.TYPE_FOLDER;
import static cc.kune.tasks.shared.TasksConstants.TYPE_ROOT;
import static cc.kune.tasks.shared.TasksConstants.TYPE_TASK;
import cc.kune.core.client.registry.ContentCapabilitiesRegistry;
import cc.kune.core.client.resources.nav.NavResources;
import cc.kune.core.shared.i18n.I18nTranslationService;
import cc.kune.gspace.client.tool.FoldableAbstractClientTool;
import cc.kune.gspace.client.tool.selector.ToolSelector;

import com.google.inject.Inject;

public class TasksClientTool extends FoldableAbstractClientTool {

  @Inject
  public TasksClientTool(final I18nTranslationService i18n, final ToolSelector toolSelector,
      final ContentCapabilitiesRegistry cntCapRegistry, final NavResources navResources) {
    super(NAME, i18n.t(ROOT_NAME), toolSelector, cntCapRegistry, i18n, navResources);

    // registerAclEditableTypes();
    registerAuthorableTypes(TYPE_TASK);
    registerDragableTypes(TYPE_TASK, TYPE_FOLDER);
    registerDropableTypes(TYPE_ROOT, TYPE_FOLDER);
    registerPublishModerableTypes(TYPE_TASK);
    registerRateableTypes(TYPE_TASK);
    registerRenamableTypes(TYPE_FOLDER, TYPE_TASK);
    registerTageableTypes(TYPE_FOLDER, TYPE_TASK);
    // registerTranslatableTypes();
    registerIcons();
  }

  @Override
  public String getName() {
    return NAME;
  }

  private void registerIcons() {
    registerContentTypeIcon(TYPE_ROOT, navResources.folder());
    registerContentTypeIcon(TYPE_FOLDER, navResources.folder());
    registerContentTypeIcon(TYPE_TASK, navResources.task());
    final String noTask = i18n.t("There isn't any task, create one");
    registerEmptyMessages(TYPE_ROOT, noTask);
    registerEmptyMessages(TYPE_FOLDER, noTask);
  }

}