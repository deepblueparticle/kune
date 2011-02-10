/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
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
package cc.kune.core.client.ui.dialogs;

import cc.kune.common.client.ui.IconLabel;
import cc.kune.common.client.utils.TextUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.InsertPanel.ForIsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class BasicDialog extends Composite implements BasicDialogView {

    interface BasicDialogUiBinder extends UiBinder<Widget, BasicDialog> {
    }
    private static BasicDialogUiBinder uiBinder = GWT.create(BasicDialogUiBinder.class);
    @UiField
    VerticalPanel bottomPanel;
    @UiField
    FlowPanel btnPanel;
    @UiField
    Button firstBtn;
    @UiField
    Button secondBtn;
    @UiField
    IconLabel title;
    @UiField
    VerticalPanel vp;

    public BasicDialog() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void ensureDebugIdFirstBtn(final String id) {
        if (id != null && id.length() > 0) {
            firstBtn.ensureDebugId(id);
        }
    }

    public void ensureDebugIdSecondBtn(final String id) {
        if (id != null && id.length() > 0) {
            secondBtn.ensureDebugId(id);
        }
    }

    @Override
    public ForIsWidget getBottomPanel() {
        return bottomPanel;
    }

    @Override
    public HasClickHandlers getFirstBtn() {
        return firstBtn;
    }

    @Override
    public HasText getFirstBtnText() {
        return firstBtn;
    }

    @Override
    public ForIsWidget getInnerPanel() {
        return vp;
    }

    @Override
    public HasClickHandlers getSecondBtn() {
        return secondBtn;
    }

    @Override
    public HasText getSecondBtnText() {
        return secondBtn;
    }

    @Override
    public HasDirectionalText getTitleText() {
        return title;
    }

    public void setFirstBtnId(final String id) {
        firstBtn.ensureDebugId(id);
    }

    public void setFirstBtnTabIndex(final int index) {
        firstBtn.setTabIndex(index);
    }

    @Override
    public void setFirstBtnTitle(final String title) {
        firstBtn.setTitle(title);
    }

    @Override
    public void setFirstBtnVisible(final boolean visible) {
        firstBtn.setVisible(visible);
    }

    public void setSecondBtnId(final String id) {
        secondBtn.ensureDebugId(id);
    }

    public void setSecondBtnTabIndex(final int index) {
        secondBtn.setTabIndex(index);
    }

    @Override
    public void setSecondBtnTitle(final String title) {
        secondBtn.setTitle(title);
    }

    @Override
    public void setSecondBtnVisible(final boolean visible) {
        secondBtn.setVisible(visible);
    }

    public void setTitleIcon(final String icon) {
        if (TextUtils.notEmpty(icon)) {
            title.setIcon(icon);
        }
    }

    public void setTitleId(final String id) {
        title.ensureDebugId(id);
    }

}
