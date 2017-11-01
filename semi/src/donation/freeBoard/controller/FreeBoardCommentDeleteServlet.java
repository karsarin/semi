package donation.freeBoard.controller;

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

/**
 * Servlet implementation class CommentBoardDeleteServlet
 */
@WebServlet("/commentDelete")
public class FreeBoardCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int nto;
	   public static int flag;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardCommentDeleteServlet() {
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
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));


		
		FreeBoardService fservice = new FreeBoardService();
		
		int result = fservice.deleteCommentBoard(commentNum);
		
		System.out.println("≥ª≤® result : " + result   );
	
		
		System.out.println(result);
		System.out.println("boardNum" + boardNum);
		if(result > 0) {
	         RequestDispatcher view = request.getRequestDispatcher("/reList");
	        // nto = boardNum;
	        request.setAttribute("no", boardNum);
	        // System.out.println("---------------------------");
	        // flag =1;
	       //  System.out.println(boardNum);
	         view.forward(request, response);
	         
	      }else {
	         RequestDispatcher view = request.getRequestDispatcher("views/freeBoard/freeBoardError.jsp");
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
