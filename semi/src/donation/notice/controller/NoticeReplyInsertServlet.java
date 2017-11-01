package donation.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import donation.freeBoard.model.service.FreeBoardService;
import donation.freeBoard.model.vo.CommentBoard;
import donation.freeBoard.model.vo.FreeBoard;
import donation.notice.model.service.NoticeService;
import donation.notice.model.vo.CommentNotice;

/**
 * Servlet implementation class FreeBoardReplyInsertServlet
 */
@WebServlet("/nreInsert")
public class NoticeReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");  //JSON 객체로 내보낼때는 text/html 아님
		
		String content = request.getParameter("content");	
		String writer = request.getParameter("writer");	
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));

		CommentNotice cnotice = new CommentNotice(noticeNum, writer, content );
		
		
		NoticeService nservice = new NoticeService();
		int result = nservice.insertReplyNotice(cnotice);
		
		System.out.println("result : " + result);
		 
		

		ArrayList<CommentNotice> list = nservice.selectReplyNoticeList(noticeNum);
		
		
		
		if(result > 0) {
	         RequestDispatcher view = request.getRequestDispatcher("/nreList");
	        // nto = noticeNum;
	        request.setAttribute("no", noticeNum);
	        // System.out.println("---------------------------");
	        // flag =1;
	       //  System.out.println(noticeNum);
	         view.forward(request, response);
	         
	      }else {
	         RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeError.jsp");
	         request.setAttribute("message", "공지글 댓글 달기 실패");
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
