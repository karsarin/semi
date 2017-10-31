package donation.suggest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.member.model.service.MemberService;
import donation.member.model.vo.Member;
import donation.suggest.model.vo.Suggest;

/**
 * Servlet implementation class SuggestWriteViewServlet
 */
@WebServlet("/swrite")
public class SuggestWriteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestWriteViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String sender = request.getParameter("sender");
		boolean send = false;
		if(sender!=null && (new MemberService().memberInformation(sender).getMgrChat().equals("Y"))) send = true;
		
		if(send) {
			String reciver = request.getParameter("reciver");
			Member member = new MemberService().memberInformation(reciver);
			
			String suggestStrTmp = request.getParameter("suggest");
			Suggest suggest = null;
			if(suggestStrTmp!=null) {
				suggest = new Suggest();
				String suggestStr[] = suggestStrTmp.split(",");
				suggest.setSuggestTitle(suggestStr[1]);
				suggest.setSuggestPreoid(suggestStr[2]);
				suggest.setSuggestContent(suggestStr[3]);
			}		
		
			RequestDispatcher view = null;
			if(member != null){
				view = request.getRequestDispatcher("views/suggest/suggestWriteForm.jsp");
				request.setAttribute("reciver", reciver);
				if(suggest!=null) request.setAttribute("suggest", suggest);
				view.forward(request, response);
			}else{
				view = request.getRequestDispatcher("views/suggest/suggestError.jsp");
				request.setAttribute("message", reciver+"님은 존재하지않는 회원, 쪽지 보낼 수 없음");
				view.forward(request, response);
			}
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/suggest/suggestError.jsp");
			request.setAttribute("message", sender+"님은 현재 채팅 및 쪽지 보내기가 제한되었습니다.");
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
