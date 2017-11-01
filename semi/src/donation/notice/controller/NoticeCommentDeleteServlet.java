package donation.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import donation.freeBoard.model.service.FreeBoardService;
import donation.freeBoard.model.vo.CommentBoard;
import donation.notice.model.service.NoticeService;

/**
 * Servlet implementation class CommentBoardDeleteServlet
 */
@WebServlet("/ncommentDelete")
public class NoticeCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int nto;
	   public static int flag;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		

		
		
		int commentNum = Integer.parseInt(request.getParameter("commentNum"));
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));


		
		NoticeService nservice = new NoticeService();
		
		int result = nservice.deleteCommentNotice(commentNum);
		
		System.out.println("≥ª≤® result : " + result   );
	
		
		System.out.println(result);
		System.out.println("noticeNum" + noticeNum);
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
	         request.setAttribute("message", "¥Ò±€ ªË¡¶ ø°∑Ø");
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
