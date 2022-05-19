package com.team.three.chatting.entity;

import lombok.*;
import net.bytebuddy.utility.RandomString;

import java.util.Random;
import java.util.UUID;;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {

    private String roomId;
    private String roomName;

    public static ChatRoom create(String roomId) {
        ChatRoom room = new ChatRoom();
        room.roomId = roomId;
        room.roomName = roomId;
        return room;
    }
}