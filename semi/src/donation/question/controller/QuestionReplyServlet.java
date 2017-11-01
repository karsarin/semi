package donation.question.controller;

import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.question.model.service.QuestionService;
import donation.question.model.vo.Question;

/**
 * Servlet implementation class QuestionReplyServlet
 */
@WebServlet("/qreply")
public class QuestionReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��� ��� ó���� ��Ʈ�ѷ�
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		
		QuestionService bservice = new QuestionService();
		
		//���� ��ȸ
		Question originQuestion = bservice.selectQuestion(no);
		
		//��� ��ü ����, �� ���
		Question replyQuestion = new Question();
		replyQuestion.setQuestionContent(content);
		replyQuestion.setQuestionTitle(title);
		replyQuestion.setQuestionWriter(writer);
		replyQuestion.setQuestionLevel(originQuestion.getQuestionLevel() + 1); //���� ���� ���� level�� �Ǿ�� �������� ��� ��ȣ��
		replyQuestion.setQuestionRef(originQuestion.getQuestionRef()); //������ȣ�� ����� ������� �˷��ִϱ� ���۹�ȣ �״�� �������
		if(replyQuestion.getQuestionLevel() == 2 ) { //����� ����̸�
			replyQuestion.setQuestionReplyRef(originQuestion.getQuestionNum());		
		}
		replyQuestion.setQuestionReplySeq(1);
		
		//���� ������ ���� ����� seq 1���� ó����
		bservice.updateReplySeq(replyQuestion);
		
		//��� ��� ó��
		int result = bservice.insertQuestionReply(originQuestion, replyQuestion);
		
		if(result>0){
			int result2 = bservice.updateOriginQAnswer(originQuestion);
			if(result2>0) response.sendRedirect("/semi/qlist?page=" + currentPage);
			else {
				RequestDispatcher view = request.getRequestDispatcher("views/question/questionError.jsp");
				request.setAttribute("message", "���� �亯�Ϸ� ���·� ������Ʈ ����");
				view.forward(request, response);
			}
		}
		else{
			RequestDispatcher view = request.getRequestDispatcher("views/question/questionError.jsp");
			request.setAttribute("message", "QA ��� �ޱ� ����");
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
