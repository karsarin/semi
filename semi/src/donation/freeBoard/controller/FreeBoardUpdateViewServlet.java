package donation.freeBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import donation.freeBoard.model.service.FreeBoardService;
import donation.freeBoard.model.vo.FreeBoard;

/**
 * Servlet implementation class NoticeUpdateViewServlet
 */
@WebServlet("/fupview")
public class FreeBoardUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ ���������� ��� ó���� ��Ʈ�ѷ�		
		//������ notice ���� db���� �ٽ� �ҷ��ͼ� �����ؾ� ��Ȯ��
		response.setContentType("text/html charset=utf-8");
		
		FreeBoard fboard = new FreeBoardService().selectFreeBoard(Integer.parseInt(request.getParameter("no")));
		//���⼭ DB�� �ִ� �Խñ� ���� �̹� �ҷ���
		
		
		
		RequestDispatcher view = null;
		if(fboard != null){
			view = request.getRequestDispatcher("views/freeBoard/freeBoardUpdateView.jsp");
			request.setAttribute("fboard", fboard);
			view.forward(request, response);
		}else{

			view = request.getRequestDispatcher("views/freeBoard/freeBoardError.jsp");
			request.setAttribute("message", "���� �Խñ� ���� ������ ��� ó�� ����");
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
