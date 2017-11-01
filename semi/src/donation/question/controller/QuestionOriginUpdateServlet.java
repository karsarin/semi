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
 * Servlet implementation class QuestionOriginUpdateServlet
 */
@WebServlet("/qupdate0")
public class QuestionOriginUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionOriginUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� ���� ó���� ��Ʈ�ѷ�
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
		String savePath = root + "uploadfiles/" + "quploadfiles";
		//web/buploadfiles �� ������
		
		//request �� MultipartRequest ��ü�� ��ȯ��
		//�ڵ� ������ ��ο� ���� �����
		MultipartRequest mrequest = new MultipartRequest(request, savePath,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String title = mrequest.getParameter("title");
		String content = mrequest.getParameter("content");
		int no = Integer.parseInt(mrequest.getParameter("no"));
		int currentPage = Integer.parseInt(mrequest.getParameter("page"));
		String oImageName = mrequest.getParameter("ofile");
		String rImageName = mrequest.getParameter("rfile");
		
		String originalImageName = mrequest.getFilesystemName("file");
		Question b = null;
		if(originalImageName != null && 
				!oImageName.equals(originalImageName)){
			//���ε�� ������ ���� ���, ���ϸ��� "����Ͻú���.Ȯ����"�� ������
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyyMMddHHmmss");
			String renameImageName = sdf.format(
					new java.sql.Date(System.currentTimeMillis())) + "."
					+ originalImageName.substring(
							originalImageName.lastIndexOf(".") + 1);
			
			//���ε�Ǿ� �ִ� ���� ������ �̸��� �� �̸����� �ٲٱ�
			File originalImage = new File(savePath + "\\" + originalImageName);
			File renameImage = new File(savePath + "\\" + renameImageName);
			
			//�����̸� �ٲٱ� ���� >> ���н� ���� �ٲٱ���
			//�� ���� �����, ���� ������ ���� �о ���� ����ϰ�
			//�� ���� ������
			if(!originalImage.renameTo(renameImage)){
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(originalImage);
				FileOutputStream fout = new FileOutputStream(renameImage);
				
				while((read = fin.read(buf, 0, buf.length)) != -1)
					fout.write(buf, 0, read);
				
				fin.close();
				fout.close();
				originalImage.delete();
				new File(savePath + "/" + rImageName).delete();
			}
			b = new Question(no ,title, content, originalImageName, renameImageName);
		}else  //÷�� ������ ���ų�, ÷�� ������ ������� �ʾҴٸ�
			b = new Question(no, title, content, oImageName, rImageName);
				
		//ó������� ���� �� ������
		if(new QuestionService().updateQuestion(b) > 0){
			response.sendRedirect("/semi/qlist?page=" + currentPage);
		}else{
			view = request.getRequestDispatcher("views/question/questionError.jsp");
			request.setAttribute("message", "QA ���� ���� ����");
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
