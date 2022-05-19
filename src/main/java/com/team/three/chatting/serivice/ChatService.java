package com.team.three.chatting.serivice;

import com.team.three.chatting.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String roomId) {
        ChatRoom chatRoom = ChatRoom.create(roomId);
        chatRooms.put(roomId, chatRoom);
        return chatRooms.get(roomId);
    }

    //채팅방 생성
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRooms.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

    //채팅방 생성 및 생성되어 있다면 입장.
    public ChatRoom createOrEnterRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        if(null == chatRooms.getOrDefault("name", null)) {
            chatRooms.put(chatRoom.getRoomId(), chatRoom);
        }
        return chatRoom;
    }
}


