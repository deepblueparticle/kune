/*******************************************************************************
 * Copyright (C) 2007, 2013 The kune development team (see CREDITS for details)
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
 *******************************************************************************/

package cc.kune.gspace.client.share;

import cc.kune.common.client.notify.NotifyUser;
import cc.kune.common.shared.i18n.I18n;
import cc.kune.core.client.i18n.I18nUITranslationService;
import cc.kune.core.client.sitebar.search.MultivalueSuggestBox;
import cc.kune.core.client.sitebar.search.OnEntitySelectedInSearch;
import cc.kune.core.client.sitebar.search.SearchBoxFactory;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class ShareToOthersPanel extends Composite {

  public static final String SEARCH_TEXTBOX_ID = "stop-textbox";

  @Inject
  public ShareToOthersPanel(final I18nUITranslationService i18n) {
    final FlowPanel flow = new FlowPanel();
    flow.addStyleName("k-share-others");
    final Label title = new Label(I18n.t("or drag and drop to add people or"));
    flow.add(title);

    final MultivalueSuggestBox multivalueSBox = SearchBoxFactory.create(i18n, true, true,
        SEARCH_TEXTBOX_ID, new OnEntitySelectedInSearch() {
          @Override
          public void onSeleted(final String shortName) {
            // TODO
            NotifyUser.info("Selected: " + shortName);
          }
        });
    // final SuggestBox suggestBox = multivalueSBox.getSuggestBox();
    // final TextBoxBase searchTextBox = suggestBox.getTextBox();
    flow.add(multivalueSBox);

    initWidget(flow);
  }
}
