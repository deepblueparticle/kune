package org.gwtbootstrap3.client.ui.base.button;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.gwtbootstrap3.client.ui.constants.IconType;

import cc.kune.common.shared.res.KuneIcon;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;

/**
 * Button based on {@code <button>} element with different types and sizes.
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 *
 * <pre>
 * {@code
 *     <b:Button type="PRIMARY">Save</b:Button>
 *     <b:Button type="DANGER">Delete</b:Button>
 *     <b:Button type="INFO" block="true>I'm a block level button</b:Button>
 * }
 * </pre>
 *
 * @author Sven Jacobs
 * @see org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton
 */
public class CustomButton extends CustomAbstractToggleButton {

  /**
   * Creates button with DEFAULT type.
   */
  public CustomButton() {
  }

  /**
   * Creates button with specified text
   *
   * @param text
   *          Text contents of button
   */
  public CustomButton(final String text) {
    setText(text);
  }

  public CustomButton(final String text, final ClickHandler handler) {
    this(text);
    super.addClickHandler(handler);
  }

  public CustomButton(final String text, final IconType iconType, final ClickHandler clickHandler) {
    this(text, clickHandler);
    setIcon(iconType);
  }

  @Override
  protected Element createElement() {
    return Document.get().createPushButtonElement().cast();
  }

  @Override
  public void setIcon(final KuneIcon icon) {
    super.setIcon(icon);
  }

  @Override
  public void setIconBackColor(final String backgroundColor) {
    super.setIconBackColor(backgroundColor);
  }

  @Override
  public void setIconResource(final ImageResource icon) {
    super.setIconResource(icon);
  }

  @Override
  public void setIconRightResource(final ImageResource icon) {
    super.setIconRightResource(icon);
  }

  @Override
  public void setIconStyle(final String style) {
    super.setIconStyle(style);
  }

  @Override
  public void setIconUrl(final String url) {
    super.setIconUrl(url);
  }
}