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
import donation.freeBoard.model.vo.CommentBoard;
import donation.freeBoard.model.vo.FreeBoard;
import donation.notice.model.service.NoticeService;
import donation.notice.model.vo.Notice;

/**
 * Servlet implementation class FreeBoardDetailServlet
 */
@WebServlet("/fdetail")
public class FreeBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// a �±׷� ��û�°� doGet()�� ���� 
				//������ �� ��ȸ ó���� ��Ʈ�ѷ�
				response.setContentType("text/html; charset=utf-8");
				//CommentBoardDeleteServlet cbd = new CommentBoardDeleteServlet();
				int no = Integer.parseInt(request.getParameter("no"));	           
				
				
				FreeBoardService fservice  = new FreeBoardService();
				//��ȸ�� 1 ���� ó��(DB�� count���� update�ؾ���)
				fservice.addReadCount(no); //public void - ���ϾȽ�Ű�� �׳� ���� ������
				FreeBoard fboard = fservice.selectFreeBoard(no);

				
				
				RequestDispatcher view = null;
				if(fboard != null){			
					
					view = request.getRequestDispatcher("views/freeBoard/freeBoardDetailView.jsp");
					request.setAttribute("fboard", fboard);
					view.forward(request, response);
					
				}else{
					view = request.getRequestDispatcher("views/freeboard/freeBoardError.jsp");
					request.setAttribute("message", "���� �Խ��� �� ��ȸ ����!");
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
