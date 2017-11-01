package donation.freeBoard.controller;

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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import donation.freeBoard.model.service.FreeBoardService;
import donation.freeBoard.model.vo.FreeBoard;
import donation.notice.model.service.NoticeService;
import donation.notice.model.vo.Notice;

/**
 * Servlet implementation class FreeBoardInsertServlet
 */
@WebServlet("/finsert")
public class FreeBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ ��� ó���� ��Ʈ�ѷ�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
	
		
	
		RequestDispatcher view = null;
		FreeBoard fboard = null;
		if(!ServletFileUpload.isMultipartContent(request) ){ // request�� ������ ��û�� view�� form ��������  multipart ������� Ȯ����
															//ServletFileUpload �̰� cos.jar(���� ����� ���̺귯��)�� ������ 
			view = request.getRequestDispatcher("views/freeBoard/freeBoardError.jsp");
			request.setAttribute("message", "form �� enctype �Ӽ� ������!");
			view.forward(request, response);
		}
			//���ε� �� ������ �뷮 ���� : 10Mbyte �� �����Ѵٸ�
			int maxSize = 1024 * 1024  * 10;
			 
			//���ε�� ������ ���� ��ġ ����
			//�ش� �����̳�(��Ĺ) �������� �� ���ø����̼� ��Ʈ ����(content directory)�� ��θ� �˾Ƴ�
			//�׷��� ���� ��Ĺ���� �������� ���ø����̼��� ��θ� �˾Ƴ��� �� �����ȿ� ����ǰ� �ҽ��ڵ�� ��������
			//�̷��� �ϸ� ������ �ٲ��� �ҽ� ������ �ʿ����
			String root = request.getSession().getServletContext().getRealPath("/");
			//���ǰ�ü�� ���������  ���ø����̼�(context)   "/" �� root ������ �ǹ��� 
			//���ø����̼��� ��Ʈ������ �˾Ƴ���� �� 
			
			//���ε� �� ������ ������� ��Ʈ ���� ���� ó��
			String savePath = root + "uploadfiles/" + "fuploadfiles";
			// web/uploadfiles �� �������
			
			//request �� MultipartRequest ��ü�� ��ȯ��
			MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
			//MulitpartRequest ��� Ŭ����
			//new MultipartRequest(request��ü,  ���Ͼ��ε��ϴ� ������, ���ε� �� ������ �뷮, ���ڵ� ��, ����� ���� Ŭ����) 
			
			//new DefaultFileRenamePolicy()�� ������ ������ϴ°� �ƴ϶� �̸� �����ؼ�  �̸�(1).txt, �̸�(2)tx. �̷��� �����ؼ� ���� ���ε��ϴ� Ŭ����  
					
			
			
			//���� request�� mrequst�� �ٲ��� ������ mrequest���� getParameter() �ؾ��Ѵ�.
			String title = mrequest.getParameter("title");
			String writer = mrequest.getParameter("writer");
			String content = mrequest.getParameter("content");	
			String originalFileName = mrequest.getFilesystemName("file"); //���� �̸��� ����
			String boardType = mrequest.getParameter("type");
			
			//���ε�Ǿ� �ִ� ���ϸ��� '����Ͻú���.Ȯ����' �������� �ٲٱ� ó��
			if(originalFileName != null){
				//������ ���ϸ� ����� 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "." + 
				originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
				
				//���ϸ� �ٲٷ��� File ��ü�� renameTo() �޼ҵ� �����
				File originalFile = new File(savePath + "\\" + originalFileName); // �������� ��ξ� �� /�� ������ ���⼭�� "\\" ��� 
				File renameFile = new File(savePath + "\\" + renameFileName); //java.io.File import �ؾߵ�
				//�����ϸ� true , �����ϸ� false�� ���ϵ�
				if(!originalFile.renameTo(renameFile)){
					//�̸��ٲٱⰡ �����ߴٸ�  �� ������ ������ �о, ���纻 ���Ͽ� �Ű� ����ϰ� �������� �� ������ ������
					int read = -1;
					byte[] buf = new byte[1024];
					
					FileInputStream fin = new FileInputStream(originalFile);
					FileOutputStream fout = new FileOutputStream(renameFile);
					
					
					while((read = fin.read(buf, 0, buf.length)) != -1){  //read���� �о���� ����Ʈ ����� �������, �� ������ -1�� ��
						fout.write(buf, 0 , read);					
						//buf�� ���� ���� 0 ����Ʈ���� read�� ���� ��ŭ write�ض�						
					}
					fin.close();
					fout.close();
					
					
				
					//�������� �� ������ ������
					originalFile.delete();
				}
				//���ε� �� ������ ���� ���
				 fboard = new FreeBoard(0, title, writer, content, null, originalFileName, renameFileName, 0, boardType, 2); //�ҷ��� ������ notice��ü �ʱ�ȭ
				

			}
			else{
				// ���ε� �� ������ ���� ���(÷�������� ���� ���)
				fboard = new FreeBoard(0, title, writer, content, null, null, null, 0, boardType, 2); //�ҷ��� ������ notice��ü �ʱ�ȭ
			}		
		
		//���񽺷� �����ϰ� ����޾Ƽ� �� �����ؼ� �������� 
		if(new FreeBoardService().insertNotice(fboard) > 0){
			response.sendRedirect("/semi/flist");
		}else{
			view = request.getRequestDispatcher("views/freeBoard/freeBoardError.jsp");
			request.setAttribute("message", "���� �Խñ� ��� ����!");
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
