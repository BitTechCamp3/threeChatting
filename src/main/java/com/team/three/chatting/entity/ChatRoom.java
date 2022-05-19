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
    private String sender;

    public static ChatRoom create(String name) {
        ChatRoom room = new ChatRoom();
        room.roomId = name;
        room.roomName = name;

        RandomString rs = new RandomString(10);
        room.sender = "익명" + rs.nextString();
        return room;
    }
}