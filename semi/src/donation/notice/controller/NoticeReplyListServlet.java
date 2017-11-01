package donation.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

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
import donation.notice.model.vo.CommentNotice;

/**
 * Servlet implementation class FreeBoardReplyListServlet
 */
@WebServlet("/nreList")
public class NoticeReplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeReplyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");  //JSON ��ü�� ���������� text/html �ƴ�
		
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		//System.out.println(boardNum);
		NoticeService nservice = new NoticeService();		
		
		ArrayList<CommentNotice> list = nservice.selectReplyNoticeList(noticeNum);	
		
		//System.out.println(list);
		 
		///�������°� json ��ü �ϳ��� ������ �� ����
		//�׷��� json �迭�� json ��ü�� ������
		//������ json ��ü ����
		JSONObject job = new JSONObject();
		//list �Űܴ���  json �迭 ����
		JSONArray jarr = new JSONArray();
		
		for(CommentNotice comment : list){
			//user ��ü �� ���� ������ json ��ü ����
			JSONObject j = new JSONObject();
			j.put("commentNum", comment.getCommentNum());
			j.put("noticeNum", comment.getnoticeNum());
			j.put("writer", URLEncoder.encode(comment.getWriter(), "UTF-8"));
			//j.put("date", comment.getDate());
			j.put("date",  comment.getDateString());
			j.put("content", URLEncoder.encode(comment.getContent(), "UTF-8"));
			
			jarr.add(j);
		}		
		
		job.put("list", jarr);
	//	System.out.println("comment job : " + job.toJSONString());
		PrintWriter pw = response.getWriter();
		//PrintWriter�� ���� ��Ʈ���̱⶧���� object�� ���� �� ����. 
		//���� ��Ʈ���̹Ƿ� ��ü�� ���ڿ������� �ٲ㼭 �������� ��
		pw.print(job.toJSONString());
		pw.flush();
		pw.close();
		
	//	System.out.println("���� ���� �Ϸ�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
