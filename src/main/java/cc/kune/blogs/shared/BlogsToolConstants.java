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
package cc.kune.blogs.shared;

import cc.kune.common.shared.res.KuneIcon;
import cc.kune.core.shared.ToolConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class BlogsToolConstants.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public final class BlogsToolConstants {

  /** The Constant ICON_TYPE_BLOG. */
  public static final KuneIcon ICON_TYPE_BLOG = KuneIcon.BLOGS;

  /** The Constant ICON_TYPE_POST. */
  public static final KuneIcon ICON_TYPE_POST = KuneIcon.BLOG_POST;

  /** The Constant ICON_TYPE_ROOT. */
  public static final KuneIcon ICON_TYPE_ROOT = KuneIcon.BLOGS;

  /** The Constant ROOT_NAME. */
  public static final String ROOT_NAME = "blogs";

  /** The Constant TOOL_NAME. */
  public static final String TOOL_NAME = "blogs";

  /** The Constant TYPE_BLOG. */
  public static final String TYPE_BLOG = TOOL_NAME + "." + "blog";

  /** The Constant TYPE_POST. */
  public static final String TYPE_POST = TOOL_NAME + "." + "post";

  /** The Constant TYPE_ROOT. */
  public static final String TYPE_ROOT = TOOL_NAME + "." + "root";

  /** The Constant TYPE_UPLOADEDFILE. */
  public static final String TYPE_UPLOADEDFILE = TOOL_NAME + "." + ToolConstants.UPLOADEDFILE_SUFFIX;

  /**
   * Instantiates a new blogs tool constants.
   */
  private BlogsToolConstants() {
  }
}
