/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.46
 * Generated at: 2017-10-31 02:40:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.freeBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import donation.freeBoard.model.vo.FreeBoard;
import donation.member.model.vo.Member;
import donation.member.model.vo.Member;

public final class freeBoardListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/views/freeBoard/../../rightList.jsp", Long.valueOf(1509417596504L));
    _jspx_dependants.put("/views/freeBoard/../../../views/manager/managerHeader.jsp", Long.valueOf(1509413753179L));
    _jspx_dependants.put("/views/freeBoard/../../header.jsp", Long.valueOf(1509413753976L));
    _jspx_dependants.put("/views/freeBoard/../../headerbar.jsp", Long.valueOf(1509413753976L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("donation.freeBoard.model.vo.FreeBoard");
    _jspx_imports_classes.add("donation.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	ArrayList<FreeBoard> list = (ArrayList<FreeBoard>) request.getAttribute("list");
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>boardListView</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction insertPage() {\r\n");
      out.write("\t\tlocation.href = \"views/freeBoard/freeBoardWriteForm.jsp\";\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 카테고리  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("\thref='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/font-awesome.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/animate.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/templatemo_misc.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/templatemo_style.css\">\r\n");
      out.write("<script src=\"js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("ul#navi {\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("\ttext-indent: 10px;\r\n");
      out.write("\tbackground-color: lightgray;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#navi, ul#navi ul {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li.group {\r\n");
      out.write("\tmargin-bottom: 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li.group div.title {\r\n");
      out.write("\theight: 35px;\r\n");
      out.write("\tline-height: 35px;\r\n");
      out.write("\tbackground: lightblue;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li {\r\n");
      out.write("\tmargin-bottom: 2px;\r\n");
      out.write("\theight: 35px;\r\n");
      out.write("\tline-height: 35px;\r\n");
      out.write("\tbackground: #f4f4f4;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li a {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li:hover {\r\n");
      out.write("\tbackground: aliceblue;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--세로목록 끝 -->\r\n");
      out.write("#table {\r\n");
      out.write("\twidth: 66vw;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#table #type {\r\n");
      out.write("\twidth: 4vw;\r\n");
      out.write("text-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#table #title {\r\n");
      out.write("\twidth: 40vw;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#table #writer {\r\n");
      out.write("\twidth: 7vw;\r\n");
      out.write("text-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#table #date {\r\n");
      out.write("\twidth: 7vw;\r\n");
      out.write("text-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("#table #readCount {\r\n");
      out.write("\twidth: 7vw;\r\n");
      out.write("text-align:center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#firstTr {\r\n");
      out.write("\tbackground-color: lightblue;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#searchInput{\r\n");
      out.write("\twidth:10vw;\r\n");
      out.write("\theight:22px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("#searchButton{\r\n");
      out.write("\twidth:3vw;\r\n");
      out.write("\theight:36px;\r\n");
      out.write("}\r\n");
      out.write("#typeSelect{\r\n");
      out.write("\twidth:5vw;\r\n");
      out.write("}\r\n");
      out.write("#writeButton{\r\n");
      out.write("\t\r\n");
      out.write("\theight:36px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>header</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font-awesome.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/animate.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/templatemo_misc.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/templatemo_style.css\">\r\n");
      out.write("<script src=\"js/vendor/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.0.min.js\"><\\/script>')</script>\r\n");
      out.write("<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("<script src=\"js/plugins.js\"></script>\r\n");
      out.write("<script src=\"js/main.js\"></script>\r\n");
      out.write("<script src=\"js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("        function goBoardPage() { location.href=\"/semi/nlist\"; }\r\n");
      out.write("        function goHomePage() { location.href=\"/semi/index.jsp\"; }        \r\n");
      out.write("        function goCategoryPage(){location.href=\"/semi/clist\";}\r\n");
      out.write("       \tfunction insertCategory(){location.href=\"/semi/views/category/categoryInsertView.jsp\";}\r\n");
      out.write("       \tfunction loginView(){location.href=\"/semi/views/member/Login.jsp\"}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
 Member member = (Member)session.getAttribute("member"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>header</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("div#loginbar{\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tmargin-right:50px;\r\n");
      out.write("\tmargin-top:5px;\r\n");
      out.write("\tfont-size:10pt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=loginbar>\r\n");
 if(member ==null){ 
      out.write("\r\n");
      out.write("\t<a href=\"/semi/views/member/Login.jsp\">로그인</a>\r\n");
      out.write("\t<a href=\"/semi/views/member/Insert.jsp\" style=\"margin-left:10px;\">회원가입</a>\r\n");
 }else{ 
      out.write("\r\n");
      out.write("\t<a href=\"/semi/minfor?userid=");
      out.print(member.getMemberId());
      out.write('"');
      out.write('>');
      out.print(member.getMemberNik() );
      out.write("</a>님 환영합니다.\r\n");
      out.write("\t<a href=\"/semi/logout?userid=");
      out.print(member.getMemberId() );
      out.write("\" style=\"margin-left:10px;\">로그아웃</a>\r\n");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write('	');
if(member!=null&&member.getMemberId().equals("admin")) { 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=UTF-8\">\r\n");
      out.write("\t<meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<title>Talent Donation - Manager</title>\t\r\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/font-awesome.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/animate.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/templatemo_misc.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/templatemo_style.css\">\r\n");
      out.write("    <script src=\"/semi/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("    <script src=\"/semi/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<br><br><br>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div id=\"menu-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"logo-wrapper col-md-4 col-sm-2\">\r\n");
      out.write("\t\t\t\t\t<a style=\"text-shadow:1px 1px 1px gray;\">다재다능</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-8 col-sm-10 main-menu text-right\">\r\n");
      out.write("\t\t\t\t\t<div class=\"toggle-menu visible-sm visible-xs\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-bars\"></i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<ul class=\"menu-first\">\r\n");
      out.write("\t\t\t\t\t\t<li id=\"home\"><a href=\"/semi/mgrmain\">Home_관리자</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"minfo\"><a href=\"/semi/mgrmember\">회원정보</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"category\"><a href=\"/semi/clist\">카테고리</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"board\"><a href=\"/semi/nlist\">게시판</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write('	');
 } else { 
      out.write(" \r\n");
      out.write("\t<br><br><hr style=\"border-style:none\">\r\n");
      out.write("\t<div class=\"main-header\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div id=\"menu-wrapper\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"logo-wrapper col-md-4 col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t<a style=\"text-shadow:1px 1px 1px gray;\">다재다능</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /.logo-wrapper -->\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-8 col-sm-10 main-menu text-right\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"toggle-menu visible-sm visible-xs\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-bars\"></i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"menu-first\">\r\n");
      out.write("\t\t\t\t\t\t\t<li style=\"margin-right:30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<form action=\"/semi/tsearch\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"search\" name=\"keyword\" autocomplete style=\"width:200px; height:auto;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"search\" style=\"height:auto; background:white;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li id=\"home\"><a href=\"javascript:goHomePage()\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li id=\"category\"><a href=\"javascript:goCategoryPage()\">카테고리</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li id=\"board\"><a href=\"javascript:goBoardPage()\">게시판</a></li>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t");
 if(member!=null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li id=\"insertc\"><a href=\"javascript:insertCategory()\">재능 등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\" onclick=\"loginView();\">재능 등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
 } 
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- /.main-menu -->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /#menu-wrapper -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.container -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.main-header -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.site-header -->\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t<script src=\"js/vendor/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("\t<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.0.min.js\"><\\/script>')</script>\r\n");
      out.write("\t<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("\t<script src=\"js/plugins.js\"></script>\r\n");
      out.write("\t<script src=\"js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=UTF-8\">\r\n");
      out.write("<title>sideMenu</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/rightMenu.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--  오른쪽 메뉴바 -->\r\n");
      out.write("\t<div class=\"right_menu\" style=\"margin-top:180px;\">\r\n");
      out.write("\t\t<ul align=\"center\">\r\n");
      out.write("\t\t\t<li id=\"rtitle\">\r\n");
      out.write("\t\t\t\t<p>다재<br>다능</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\"\tonclick=\"window.open('/semi/views/usage/usage.html','usage','resizable=no ,width=650,left=500,top=100, height=650');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m1.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>이용방법</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m2\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" onclick=\"window.open('/semi/views/usage/usage2.html','usage1','resizable=no ,width=650,left=500,top=100, height=400');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m2.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>이용방법<br>동영상</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m3\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" onclick=\"window.open('/semi/views/usage/usage3.html','usage2','resizable=no ,width=450,left=500,top=100, height=450');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m3.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>필수사항</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m4\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" onclick=\"window.open('/semi/views/usage/usage4.html','usage3','resizable=no ,width=500,left=500,top=100, height=400');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m4.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>이벤트</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
if(member!=null && member.getMemberId().equals("admin")) {
      out.write("\r\n");
      out.write("<div class=\"row\" style=\"margin-top:150px;\">\r\n");
} else {
      out.write("\r\n");
      out.write("<div class=\"row\" style=\"margin-top:200px;\">\r\n");
}
      out.write("\r\n");
      out.write("\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"margin-left: 30px; width: 230px; height: 300px; float: left;\">\r\n");
      out.write("\t\t\t\t<ul id=\"navi\">\r\n");
      out.write("\t\t\t\t\t<li class=\"group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title\">카테고리</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sub\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/semi/nlist\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/semi/flist\">자유 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"/semi/qlist\">QnA게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t$(function() {\r\n");
      out.write("\t\t\t\t\t\t\t$\r\n");
      out.write("\t\t\t\t\t\t\t\t\t.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\turl : \"/semi/ftop3\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar json = JSON.parse(JSON\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.stringify(data));\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar values = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar rank = 0;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfor ( var i in json.list) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t/* \t\tvalues += \"<tr><td><a href='/first/bdetail?bnum=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ json.list[i].bnum\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"&page=1'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ decodeURIComponent(json.list[i].btitle)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</a></td></tr>\"; */\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\trank += 1;\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalues += \"<li><a href='/semi/fdetail?no=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ json.list[i].bnum\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"&page=1'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t/* + decodeURIComponent(json.list[i].btitle) */\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"<img src=\\\"/semi/uploadfiles/top3Images/\" + rank + \".jpg\\\" width=\\\"200px\\\" height=\\\"70px\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</a></li>\"; \t \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$('#toplist').html(values);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("\t\t\t<li class=\"group\">\r\n");
      out.write("\t\t\t<div class=\"title\">후기 인기 순위</div>\r\n");
      out.write("\t\t\t\t<ul id=\"toplist\">\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"col-md-8\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--  게시판 -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table class=\"table table-hover\" id=\"table\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr id=\"firstTr\">\r\n");
      out.write("\t\t\t\t\t<!-- <th id=\"type\" >분류</th> \t-->\r\n");
      out.write("\t\t\t\t\t<th id=\"type\"><select class=\"form-control\" onchange=\"chageLangSelect(this.value)\" id=\"typeSelect\">\r\n");
      out.write("\t\t\t\t\t\t<option  value=\"전체\">전체</option>\r\n");
      out.write("\t\t\t\t\t\t<option  value=\"자유\">자유</option>\r\n");
      out.write("\t\t\t\t\t\t<option  value=\"후기\">후기</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t\tfunction chageLangSelect(type) {\r\n");
      out.write("\t\t\t\t\t\t\tlocation.href = \"/semi/fsearch?type=분류&keyword=\"+type; \r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t</script>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<th id=\"titlie\" >제목</th>\r\n");
      out.write("\t\t\t\t\t<th id=\"writer\">작성자</th>\r\n");
      out.write("\t\t\t\t\t<th id=\"date\">날짜</th>\r\n");
      out.write("\t\t\t\t\t<th id=\"readCount\">조회수</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");

					for (FreeBoard fboard : list) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"type\">");
      out.print(fboard.getBoardType());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");
if(member!=null) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"titlie\"><a href=\"/semi/fdetail?no=");
      out.print(fboard.getfreeBoardNo());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(fboard.getfreeBoardTitle());
      out.write("\r\n");
      out.write("\t\t\t\t\t</a></td>\r\n");
      out.write("\t\t\t\t\t");
 } else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"titlie\">");
      out.print(fboard.getfreeBoardTitle());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"writer\">");
      out.print(fboard.getfreeBoardWriter());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"date\">");
      out.print(fboard.getfreeBoardDate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"readCount\">");
      out.print(fboard.getReadCount());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--  table 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t\t<form action=\"/semi/fsearch\" method=\"post\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<select class=\"form-control\" name=\"type\"  id=\"searchType\">\r\n");
      out.write(" \t \t\t\t\t\t<option>분류</option>\r\n");
      out.write("  \t\t\t\t\t\t<option>제목</option>\r\n");
      out.write("  \t\t\t\t\t\t<option>작성자</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"search\" autocomlete class=\"form-control\" name=\"keyword\" id=\"searchInput\" length=\"50\"></td>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" class=\"form-control\" value=\"검색\" id=\"searchButton\" ></td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
if(member!=null) { 
      out.write("\t\r\n");
      out.write("\t\t\t\t\t<button onclick=\"return insertPage();\" class=\"form-control\" id=\"writeButton\">글쓰기</button>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");

					if (currentPage <= 1) {
				
      out.write("\r\n");
      out.write("\t\t\t\t[이전] &nbsp;\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/semi/flist?page=");
      out.print(currentPage - 1);
      out.write("\">[이전]</a>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");

					for (int p = startPage; p <= endPage; p++) {
							if (p == currentPage) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<b><font size=\"4\" color=\"red\">[");
      out.print(p);
      out.write("]\r\n");
      out.write("\t\t\t\t</font></b>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/semi/flist?page=");
      out.print(p);
      out.write('"');
      out.write('>');
      out.print(p);
      out.write("</a>\r\n");
      out.write("\t\t\t\t");

					}
						}
				
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");

					if (currentPage >= maxPage) {
				
      out.write("\r\n");
      out.write("\t\t\t\t[다음]\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/semi/flist?page=");
      out.print(currentPage + 1);
      out.write("\">[다음]</a>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=UTF-8\">\r\n");
      out.write("<title>sideMenu</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/rightMenu.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--  오른쪽 메뉴바 -->\r\n");
      out.write("\t<div class=\"right_menu\" style=\"margin-top:180px;\">\r\n");
      out.write("\t\t<ul align=\"center\">\r\n");
      out.write("\t\t\t<li id=\"rtitle\">\r\n");
      out.write("\t\t\t\t<p>다재<br>다능</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\"\tonclick=\"window.open('/semi/views/usage/usage.html','usage','resizable=no ,width=650,left=500,top=100, height=650');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m1.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>이용방법</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m2\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" onclick=\"window.open('/semi/views/usage/usage2.html','usage1','resizable=no ,width=650,left=500,top=100, height=400');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m2.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>이용방법<br>동영상</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m3\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" onclick=\"window.open('/semi/views/usage/usage3.html','usage2','resizable=no ,width=450,left=500,top=100, height=450');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m3.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>필수사항</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"m4\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" onclick=\"window.open('/semi/views/usage/usage4.html','usage3','resizable=no ,width=500,left=500,top=100, height=400');return false\">\r\n");
      out.write("\t\t\t\t\t<image src=\"/semi/images/rightmenu_m4.png\" align=\"center\" width=\"100px\" height=\"80px\"></image>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<p>이벤트</p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"footer\" style=\"clear: both;\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-8 col-xs-12 text-left\">\r\n");
      out.write("\t\t\t\t\t<span>Copyright &copy; 2014 Company Name</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.text-center -->\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4 hidden-xs text-right\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#top\" id=\"go-top\">Back to top</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.text-center -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.container -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /#footer -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
