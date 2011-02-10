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
 \*/
package org.ourproject.kune.workspace.client.upload;


import cc.kune.core.client.services.FileConstants;

import com.gwtext.client.core.UrlParam;

public class AbstractUploader {

    public UrlParam[] genUploadParams(final String userhash, final String currentStateToken, final String typeId) {
        // Warning take into account param[size]
        final UrlParam param[] = new UrlParam[3];
        param[0] = new UrlParam(FileConstants.HASH, userhash);
        param[1] = new UrlParam(FileConstants.TOKEN, currentStateToken);
        param[2] = new UrlParam(FileConstants.TYPE_ID, typeId);
        return param;
    }
}
