package donation.freeBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.freeBoard.model.service.FreeBoardService;
import donation.freeBoard.model.vo.FreeBoard;
import donation.notice.model.service.NoticeService;
import donation.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/fsearch")
public class FreeBoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		String type = request.getParameter("type");
		
		System.out.println(keyword);
		System.out.println(type);
		//System.out.println("���� searchType : " + searchType);
		
		
/*		String type = "";
		
		if(searchType.equals("�з�")) {
			type = "BOARDTYPE";
		}
		else if(searchType.equals("����")) {
			type = "FREEBOARD_TITLE";
		}
		else if(searchType.equals("�ۼ���")) {
			type = "FREEBOARD_WRITER";
		}
		else if(searchType.equals("����")) {
			type = "FREEBOARD_CONTENT";
		}
		*/
		
		System.out.println("type: " + type);
		FreeBoardService fservice = new FreeBoardService();
		
	
		//��ü ��� ���� ��ȸ��
		//int listCount = nservice.getListCount();
		int listSearchCount = fservice.getSearchListCount(type, keyword);
		System.out.println("listSearchCount : " + listSearchCount);
		
		System.out.println("currentPage : " + currentPage);
		
	
		
		ArrayList<FreeBoard> list = new FreeBoardService().selectSearch(type, keyword, currentPage, limit);
		
		System.out.println("list : " + list);
		
		
		
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
			view = request.getRequestDispatcher("views/freeBoard/freeBoardSearchListView.jsp");
			
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listSearchCount", listSearchCount);
			request.setAttribute("keyword", keyword);
			request.setAttribute("type", type);
			
			 
			view.forward(request, response);
	}else{
		view = request.getRequestDispatcher("views/freeBoard/freeBoardError.jsp");
		request.setAttribute("message", "�����Խñ� �˻�  ��ȸ ����!");
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
