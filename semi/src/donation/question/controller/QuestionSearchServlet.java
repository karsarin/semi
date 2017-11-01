package donation.question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.question.model.service.QuestionService;
import donation.question.model.vo.Question;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/qsearch")
public class QuestionSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	//������ ��� ���� �˻� ó���� ��Ʈ�ѷ�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String keyword = request.getParameter("keyword");
		
		ArrayList<Notice> list = new NoticeService().selectSearch(keyword);
				

		System.out.println(list.toString());
		
		RequestDispatcher  view = null;
		if(list != null){
			view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
			
		}else{
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", "������ ���� �˻� ����!");
			view.forward(request, response);
		}
	*/
		
		
		/////////////////////
		//������ ó����
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html; charset=utf-8");
		
		
		int currentPage = 1;
		//�� �������� ����� ������ ���� ����
		int limit = 10;
		
		//������ ���ڰ� ������ ���� ���
		if(request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		//�ش� �������� ��� ��ȸ
		String keyword = request.getParameter("keyword");
		
		
		QuestionService qservice = new QuestionService();
		
	
		//��ü ��� ���� ��ȸ��
		//int listCount = nservice.getListCount();
		int listSearchCount = qservice.getSearchListCount(keyword);
		
		System.out.println("currentPage : " + currentPage);
		
	
		
		ArrayList<Question> list = new QuestionService().selectSearch(keyword, currentPage, limit);
		//�� ������ �� ��� : ����� �ּ� 1���� ���� �� �������� ó����
		//������ 1�� �Ƿ��� = ��� 0.1 �� + 0.9 ���ǰ� ��
		int maxPage = (int)((double)listSearchCount / limit + 0.9);
		//���� �������� 13�̸� ȭ�鿡 ������ ���� �������� 11�� ����
		//(1, 11, 21, 31, .......)
		int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		//����, ��� �Ʒ��� ������ ������ ������ 10���̸�
		//���� �������� 13�̸� �� ���������� 20�������� �Ǿ�� ��
		int endPage = startPage + limit - 1;
		if(maxPage < endPage)
			endPage = maxPage;
		
		RequestDispatcher view = null;
		if(list != null){
			view = request.getRequestDispatcher("views/question/questionSearchListView.jsp");
			
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listSearchCount", listSearchCount);
			request.setAttribute("keyword", keyword);
			
			
			
			view.forward(request, response);
	}else{
		view = request.getRequestDispatcher("views/question/questionError.jsp");
		request.setAttribute("message", "�Խñ� �˻� ��ȸ ����!");
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
