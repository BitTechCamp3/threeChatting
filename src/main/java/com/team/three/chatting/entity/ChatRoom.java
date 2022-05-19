package com.team.three.chatting.entity;

import lombok.*;
import java.util.UUID;;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {

    private String roomId;
    private String roomName;

    public static ChatRoom create(String name) {
        ChatRoom room = new ChatRoom();
        room.roomId = name;
        room.roomName = name;
        return room;
    }
}