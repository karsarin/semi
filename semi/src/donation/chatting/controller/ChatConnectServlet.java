package donation.chatting.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.chatting.model.service.ChattingService;

/**
 * Servlet implementation class ChatConnectServlet
 */
@WebServlet("/chatcon")
public class ChatConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//키테고리에서 채팅으로 넘어가게 함
		response.setContentType("text/html; charset=utf-8");

		String reciver = null;
		boolean rresult=false, reciverChatMgr=false;
		int insertChat = 0;
		if(new ChattingService().chatMgr(request.getParameter("rsender"))) {
			reciver = request.getParameter("reciver");
			if(reciver!=null) {
				rresult = new ChattingService().reciverConnectionSt(reciver);
				if(rresult) reciverChatMgr = new ChattingService().chatMgr(reciver);
			}
			if(reciverChatMgr)	insertChat = new ChattingService().insertChat(request.getParameter("rsender"), reciver);
		}
		
		String sender = request.getParameter("sender");
		String sresult = null;
		if(sender!=null) {
			sresult = new ChattingService().findReciver(sender);
			new ChattingService().deleteChat(sender);
		}
		
		RequestDispatcher view = null;
		if(insertChat>0 || sresult!=null){
			view = request.getRequestDispatcher("views/chatting/chat.jsp");
			if(insertChat>0) request.setAttribute("reciver", reciver);
			else if(sresult!=null) request.setAttribute("reciver", sresult);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/chatting/chattingError.jsp");
			if(reciver==null) request.setAttribute("message", request.getParameter("rsender")+"님은 현재 채팅이 제한되어있습니다."); 
			else if(!rresult) request.setAttribute("message", reciver+"님이 접속 중이 아닙니다.");
			else if(!reciverChatMgr) request.setAttribute("message", reciver+"님은 현재 채팅이 제한되어있습니다."); 
			if(sresult!=null) request.setAttribute("message", "채팅방을 열 수 없습니다.");
			
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
