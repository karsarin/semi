package donation.chatting.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//클라이언트에서 서버로 접속 할 주소로 지정
@ServerEndpoint("/broadcasting")
public class Servlet {

   private static Set<Session> clients = Collections
         .synchronizedSet(new HashSet<Session>());

   @OnMessage
   public void onMessage(String message, Session session) throws IOException {
      System.out.println(message);
      synchronized (clients) {
         // 클라이언트로 부터 메시지가 도착했을때
         // 연결된 세션을 반복하고 수신된 메시지를 브로드캐스트
         for (Session client : clients) {
            if (!client.equals(session)) {
               client.getBasicRemote().sendText(message);
            }
         }
      }
   }

   @OnOpen
   public void onOpen(Session session) {
      // 클라이언트에서 서버로 접속할 때
      System.out.println(session);
      clients.add(session);
   }

   @OnClose
   public void onClose(Session session) {
      // 접속이 끊겼을때
      clients.remove(session);
   }
}