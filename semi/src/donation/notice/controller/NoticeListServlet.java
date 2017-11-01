package donation.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.notice.model.service.NoticeService;
import donation.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/nlist")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NoticeListServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ ó����
				int currentPage = 1;
				//�� �������� ����� ������ ���� ����
				int limit = 10;
				
				//������ ���ڰ� ������ ���� ���
				if(request.getParameter("page") != null)
					currentPage = Integer.parseInt(request.getParameter("page"));
				
				NoticeService nservice = new NoticeService();
				
				//��ü ��� ���� ��ȸ��
				int listCount = nservice.getListCount();
				System.out.println("listCount : " + listCount);
				
				//�ش� �������� ��� ��ȸ
				ArrayList<Notice> list = nservice.selectList(currentPage, limit);
				
				//�� ������ �� ��� : ����� �ּ� 1���� ���� �� �������� ó����
				//������ 1�� �Ƿ��� = ��� 0.1 �� + 0.9 ���ǰ� ��
				int maxPage = (int)((double)listCount / limit + 0.9);
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
					view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
					
					request.setAttribute("list", list);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("maxPage", maxPage);
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("listCount", listCount);
					
					view.forward(request, response);
				}else{
					view = request.getRequestDispatcher("views/notice/noticeError.jsp");
					request.setAttribute("message", "������ ����Ʈ ��ȸ ����!");
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
