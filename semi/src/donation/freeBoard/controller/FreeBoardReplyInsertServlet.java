package donation.freeBoard.controller;

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

/**
 * Servlet implementation class FreeBoardReplyInsertServlet
 */
@WebServlet("/reInsert")
public class FreeBoardReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");  //JSON ��ü�� ���������� text/html �ƴ�
		
		String content = request.getParameter("content");	
		String writer = request.getParameter("writer");	
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

		CommentBoard cboard = new CommentBoard(boardNum, writer, content );
		
		
		FreeBoardService fservice = new FreeBoardService();
		int result = fservice.insertReplyBoard(cboard);
		
		System.out.println("result : " + result);
		 
		

		ArrayList<CommentBoard> list = fservice.selectReplyBoardList(boardNum);
		
		/*
		System.out.println(list);
		
		///�������°� json ��ü �ϳ��� ������ �� ����
		//�׷��� json �迭�� json ��ü�� ������
		//������ json ��ü ����
		JSONObject job = new JSONObject();
		//list �Űܴ���  json �迭 ����
		JSONArray jarr = new JSONArray();
		
		for(CommentBoard comment : list){
			//user ��ü �� ���� ������ json ��ü ����
			JSONObject j = new JSONObject();
			j.put("commentNum", comment.getCommentNum());
			j.put("boardNum", comment.getBoardNum());
			j.put("writer", URLEncoder.encode(comment.getWriter(), "UTF-8"));
			//j.put("date", comment.getDate());
			j.put("date",  comment.getDateString());
			j.put("content", URLEncoder.encode(comment.getContent(), "UTF-8"));
			
			jarr.add(j);
		}		
		//
		job.put("list", jarr);
		System.out.println("comment job : " + job.toJSONString());
		PrintWriter pw = response.getWriter();
		//PrintWriter�� ���� ��Ʈ���̱⶧���� object�� ���� �� ����. 
		//���� ��Ʈ���̹Ƿ� ��ü�� ���ڿ������� �ٲ㼭 �������� ��
		pw.print(job.toJSONString());
		pw.flush();
		pw.close();
		*/
		
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
	         request.setAttribute("message", "�����Խ��� ��� �ޱ� ����");
	         view.forward(request, response);
	      }
		
		
		System.out.println("���� ���� �Ϸ�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
