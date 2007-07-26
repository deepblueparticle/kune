/*
 * Copyright (C) 2007 The kune development team (see CREDITS for details)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 2 dated June, 1991.
 *
 * This package is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */
package org.ourproject.kune.client.ui.chat;


import java.util.HashMap;
import java.util.Map;

import org.ourproject.kune.client.KuneFactory;
import org.ourproject.kune.client.Session;
import org.ourproject.kune.client.ehub.EventSubscriber;
import org.ourproject.kune.client.ehub.EventSubscription;
import org.ourproject.kune.client.model.Event;
import org.ourproject.kune.client.rpc.XmppService;
import org.ourproject.kune.client.ui.desktop.SiteMessageDialog;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;

public class ConferenceRoomImpl implements ConferenceRoom {
    private ConferenceRoomDialog room = null;

    private EventSubscription subscription = null;

    private EventSubscription subscription2 = null;

    private EventSubscription subscription3 = null;

    private String roomName;

    private String nickName;

    public ConferenceRoomImpl(String roomName, String nickName) {
        this.roomName = roomName;
        this.nickName = nickName;
    }

    public void init(ConferenceRoomDialog room) {
        this.room = room;
        //FIXME: refactor this
        subscription = KuneFactory.get().getEventHub().subscribe("org.ourproject.kune.muc.room"
                + "." + roomName, new EventSubscriber() {
            public void onEvent(Event event) {
                processMessage(event.getPublisherData());
            }} );
        subscription2 = KuneFactory.get().getEventHub().subscribe("org.ourproject.kune.muc.room.server-msg"
                + "." + roomName, new EventSubscriber() {
            public void onEvent(Event event) {
                processServerMessage(event.getPublisherData());
            }} );
        subscription3 = KuneFactory.get().getEventHub().subscribe("org.ourproject.kune.muc.room.presence"
                + "." + roomName, new EventSubscriber() {
            public void onEvent(Event event) {
                processPresenceMessage(event.getPublisherData());
            }} );
    }

    public void onSend(String sentence) {
        room.enableSendButton(false);
        room.clearInputArea();
        sentence = sentence.replaceAll("&", "&amp;");
        sentence = sentence.replaceAll("\"", "&quot;");
        sentence = sentence.replaceAll("<", "&lt;");
        sentence = sentence.replaceAll(">", "&gt;");
        sentence = sentence.replaceAll("\n", "<br>\n");
        XmppService.App.getInstance().sendMessage(roomName, sentence, new AsyncCallback() {
            public void onSuccess(Object result) {
                // Do nothing
            }
            public void onFailure(Throwable exception) {
                SiteMessageDialog.get().setMessageError("Error sending message: " + exception.toString());
            }});
    }

    private void processMessage(Map message) {
        //FIXME
        room.addToConversation(Session.get().currentUser.getNickName(), new HTML((String) message.get("body")));
    }

    private void processServerMessage(Map message) {
        room.addSrvMsgToConversation(new HTML((String) message.get("server-msg")));
    }

    private void processPresenceMessage(Map message) {
        ChatroomUser user = new ChatroomUser((String) message.get("user"), false);

        if (message.get("status") == "joined") {
            room.addUser(user);
        } else if (message.get("status") == "left") {
            room.delUser(user);
        }
    }

    public void onMessage(String nick, String sentence) {
        room.addToConversation(nick, new HTML(sentence));
    }

    public void onClose() {
        KuneFactory.get().getEventHub().unSubscribe(subscription);
        KuneFactory.get().getEventHub().unSubscribe(subscription2);
        KuneFactory.get().getEventHub().unSubscribe(subscription3);
        subscription = null;
        subscription2 = null;
        subscription3 = null;
        XmppService.App.getInstance().leaveRoom(roomName, new AsyncCallback() {
            public void onSuccess(Object result) {
                // Do nothing
            }
            public void onFailure(Throwable exception) {
                SiteMessageDialog.get().setMessageError("Error leaving room: " + exception.toString());
            }});
    }

    public String getRoomName() {
        return roomName;
    }

    public String getNickName() {
        return nickName;
    }

}