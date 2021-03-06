package donation.suggest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.suggest.model.service.SuggestService;
import donation.suggest.model.vo.Suggest;

/**
 * Servlet implementation class SuggestSendListServlet
 */
@WebServlet("/sugslist")
public class SuggestSendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestSendListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//보낸 쪽지함 전체 조회 처리용 컨트롤러
				response.setContentType("text/html; charset=utf-8");
				
				
				String suggestWriter = request.getParameter("writer");
				
				ArrayList<Suggest> list = new SuggestService().selectSendList(suggestWriter);
				
				RequestDispatcher view = null;	
				if(list != null){
					view = request.getRequestDispatcher("views/suggest/suggestListView.jsp");
					request.setAttribute("list", list);
					view.forward(request, response);
				}else{
					view = request.getRequestDispatcher("views/suggest/suggestError.jsp");
					request.setAttribute("message", "쪽지함 전체 조회 실패!");
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
