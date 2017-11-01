package donation.question.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import donation.question.model.service.QuestionService;
import donation.question.model.vo.Question;

/**
 * Servlet implementation class QuestionInsertServlet
 */
@WebServlet("/qinsert")
public class QuestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �Խñ� ���� ��� ó���� ��Ʈ�ѷ�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//���ε��� ������ �뷮 ���� : 10Mbyte �� �����Ѵٸ�
		int maxSize = 1024 * 1024 * 10;
		
		//enctype="multipart/form-data" �� ���۵Ǿ����� Ȯ��
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)){
			view = request.getRequestDispatcher("views/question/questionError.jsp");
			request.setAttribute("message", "form enctype �Ӽ� ��� �� ��!");
			view.forward(request, response);
		}
		
		//�ش� �����̳ʿ��� �������� �� ���ø����̼��� ��Ʈ ��� �˾Ƴ�
		String root = request.getSession().getServletContext().getRealPath("/");
		//���ε�Ǵ� ������ ����� ������� ��Ʈ ��� ���� ó��
		String savePath = root  + "uploadfiles/" + "quploadfiles";
		//web/buploadfiles �� ������
		
		//request �� MultipartRequest ��ü�� ��ȯ��
		//�ڵ� ������ ��ο� ���� �����
		MultipartRequest mrequest = new MultipartRequest(request, savePath,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String title = mrequest.getParameter("title");
		String writer = mrequest.getParameter("writer");
		String content = mrequest.getParameter("content");
		
		String originalFileName = mrequest.getFilesystemName("file");
		
		
		
		Question q = null;
		if(originalFileName != null){
			//���ε�� ������ ���� ���, ���ϸ��� "����Ͻú���.Ȯ����"�� ������
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyyMMddHHmmss");
			String renameFileName = sdf.format(
					new java.sql.Date(System.currentTimeMillis())) + "."
					+ originalFileName.substring(
							originalFileName.lastIndexOf(".") + 1);
			
			//���ε�Ǿ� �ִ� ���� ������ �̸��� �� �̸����� �ٲٱ�
			File originalFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath + "\\" + renameFileName);
			
			//�����̸� �ٲٱ� ���� >> ���н� ���� �ٲٱ���
			//�� ���� �����, ���� ������ ���� �о ���� ����ϰ�
			//�� ���� ������
			if(!originalFile.renameTo(renameFile)){
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(originalFile);
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1)
					fout.write(buf, 0, read);
				
				fin.close();
				fout.close();
				originalFile.delete();
			}
			q = new Question(title, writer, content, originalFileName, renameFileName, 3);
		}else  //÷�� ������ ���� ��
			q = new Question(title, writer, content, null, null, 3);
		
		//ó������� ���� �� ������
		if(new QuestionService().insertQuestion(q) > 0){
			response.sendRedirect("/semi/qlist?page=1");
		}else{
			view = request.getRequestDispatcher("views/question/questionError.jsp");
			request.setAttribute("message", "QNA �Խñ� ��� ����");
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







