/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2017-11-01 07:00:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import donation.search.model.vo.Notice;
import donation.member.model.vo.Member;
import donation.member.model.vo.Member;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/views/search/../../../views/manager/managerHeader.jsp", Long.valueOf(1509511973792L));
    _jspx_dependants.put("/views/search/../../rightList.jsp", Long.valueOf(1509511996371L));
    _jspx_dependants.put("/views/search/../../headerbar.jsp", Long.valueOf(1509511996149L));
    _jspx_dependants.put("/views/search/../../header.jsp", Long.valueOf(1509511996142L));
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
    _jspx_imports_classes.add("donation.search.model.vo.Notice");
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

   ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
   int ccurrentPage = 1;
   int size = 0;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head><!-- ㅇㅁㄴㅇ -->\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<title>검색</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 더보기  -->\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"../../semi/css/reset.css\"media=\"screen\" >\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"../../semi/css/js-load.css\"media=\"screen\" >\r\n");
      out.write("<script type=\"text/javascript\"src=\"https://nanati.me/common/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(window).on('load', function () {\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("   ");
 if(list.size() < 13){   
      out.write("\r\n");
      out.write("   load('#js-load', '");
      out.print( list.size() );
      out.write("');\r\n");
      out.write("   ");
 }else{ 
      out.write("\r\n");
      out.write("   load('#js-load', '12');   \r\n");
      out.write("   ");
 } 
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   $(\"#js-btn-wrap .button\").on(\"click\", function () {\r\n");
      out.write("      load('#js-load', '1', '#js-btn-wrap');\r\n");
      out.write("   })\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function load(id, cnt, btn) {\r\n");
      out.write("   var girls_list = id + \" .js-load:not(.active)\";\r\n");
      out.write("   var girls_length = $(girls_list).length;\r\n");
      out.write("   var girls_total_cnt;\r\n");
      out.write("   if (cnt <= girls_length) {\r\n");
      out.write("      girls_total_cnt = cnt;\r\n");
      out.write("   } else {\r\n");
      out.write("      girls_total_cnt = girls_length;\r\n");
      out.write("      $(button).hide();\r\n");
      out.write("   }\r\n");
      out.write("   $(girls_list + \":lt(\" + girls_total_cnt + \")\").addClass(\"active\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".floating {  position: fixed; right: 50%; top: 310px;\r\n");
      out.write(" margin-right: -615px; text-align:center; width:70px;\r\n");
      out.write("  border-radius: 8px; -webkit-border-radius: 8px; } \r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("ul#navi {\r\n");
      out.write("   width: 200px;\r\n");
      out.write("   text-indent: 10px;\r\n");
      out.write("   background-color: lightgray;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#navi, ul#navi ul {\r\n");
      out.write("   margin: 0;\r\n");
      out.write("   padding: 0;\r\n");
      out.write("   list-style: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li.group {\r\n");
      out.write("   margin-bottom: 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li.group div.title {\r\n");
      out.write("   height: 35px;\r\n");
      out.write("   line-height: 35px;\r\n");
      out.write("   background: lightblue;\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li {\r\n");
      out.write("   margin-bottom: 2px;\r\n");
      out.write("   height: 35px;\r\n");
      out.write("   line-height: 35px;\r\n");
      out.write("   background: #f4f4f4;\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li a {\r\n");
      out.write("   display: block;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   text-decoration: none;\r\n");
      out.write("   color: #000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li:hover {\r\n");
      out.write("   background: lightblue;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<!-- 세로목록 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 그림 적용 -->\r\n");
      out.write("<link rel='stylesheet' href='../../semi/image_js/style.css'\r\n");
      out.write("   media='screen' />\r\n");
      out.write("<script\r\n");
      out.write("   src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"../../semi/image_js/blocksit.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("   $(document).ready(function() {\r\n");
      out.write("      //vendor script\r\n");
      out.write("      $('#header').css({\r\n");
      out.write("         'top' : -50\r\n");
      out.write("      }).delay(1000).animate({\r\n");
      out.write("         'top' : 0\r\n");
      out.write("      }, 800);\r\n");
      out.write("\r\n");
      out.write("      $('#footer').css({\r\n");
      out.write("         'bottom' : -15\r\n");
      out.write("      }).delay(1000).animate({\r\n");
      out.write("         'bottom' : 0\r\n");
      out.write("      }, 800);\r\n");
      out.write("\r\n");
      out.write("      //blocksit define\r\n");
      out.write("      $(window).load(function() {\r\n");
      out.write("         $('#container').BlocksIt({\r\n");
      out.write("            numOfCol : 5,\r\n");
      out.write("            offsetX : 8,\r\n");
      out.write("            offsetY : 8\r\n");
      out.write("         });\r\n");
      out.write("      });\r\n");
      out.write("\r\n");
      out.write("      //window resize\r\n");
      out.write("      var currentWidth = 1100;\r\n");
      out.write("      $(window).resize(function() {\r\n");
      out.write("         var winWidth = $(window).width();\r\n");
      out.write("         var conWidth;\r\n");
      out.write("         if (winWidth < 660) {\r\n");
      out.write("            conWidth = 440;\r\n");
      out.write("            col = 2\r\n");
      out.write("         } else if (winWidth < 880) {\r\n");
      out.write("            conWidth = 660;\r\n");
      out.write("            col = 3\r\n");
      out.write("         } else if (winWidth < 1100) {\r\n");
      out.write("            conWidth = 880;\r\n");
      out.write("            col = 4;\r\n");
      out.write("         } else {\r\n");
      out.write("            conWidth = 1100;\r\n");
      out.write("            col = 5;\r\n");
      out.write("         }\r\n");
      out.write("\r\n");
      out.write("         if (conWidth != currentWidth) {\r\n");
      out.write("            currentWidth = conWidth;\r\n");
      out.write("            $('#container').width(conWidth);\r\n");
      out.write("            $('#container').BlocksIt({\r\n");
      out.write("               numOfCol : col,\r\n");
      out.write("               offsetX : 8,\r\n");
      out.write("               offsetY : 8\r\n");
      out.write("            });\r\n");
      out.write("         }\r\n");
      out.write("      });\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\"\r\n");
      out.write("   href=\"http://www.inwebson.com/wp-content/themes/inwebson2/favicon.ico\" />\r\n");
      out.write("<link rel=\"canonical\"\r\n");
      out.write("   href=\"http://www.inwebson.com/demo/blocksit-js/demo2/\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 그림 끝 -->\r\n");
      out.write("\r\n");
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
      out.write("   ");
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
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/font-awesome.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/animate.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/templatemo_misc.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/semi/css/templatemo_style.css\">\r\n");
      out.write("<script src=\"js/vendor/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.0.min.js\"><\\/script>')</script>\r\n");
      out.write("<script src=\"/semi/js/bootstrap.js\"></script>\r\n");
      out.write("<script src=\"/semi/js/plugins.js\"></script>\r\n");
      out.write("<script src=\"/semi/js/main.js\"></script>\r\n");
      out.write("<script src=\"/semi/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("        function goBoardPage() { location.href=\"/semi/nlist\"; }\r\n");
      out.write("        function goHomePage() { location.href=\"/semi/index.jsp\"; }        \r\n");
      out.write("        function goCategoryPage(){location.href=\"/semi/clist\";}\r\n");
      out.write("       \tfunction insertCategory(){location.href=\"/semi/views/category/categoryInsertView.jsp\";}\r\n");
      out.write("       \tfunction loginView(){\r\n");
      out.write("       \t\talert(\"재능 등록을 위해선 로그인이 필요합니다. 로그인 화면으로 이동합니다.\");\r\n");
      out.write("       \t\tlocation.href=\"/semi/views/member/Login.jsp\"\r\n");
      out.write("       \t\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
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
      out.write("\t<a href=\"/semi/mlist\" style=\"margin-left:10px;\">회원가입</a>\r\n");
 }else{ 
      out.write("\r\n");
      out.write("\t<a href=\"/semi/minfor?userid=");
      out.print(member.getMemberId());
      out.write('"');
      out.write('>');
      out.print(member.getMemberNik() );
      out.write("</a>님 환영합니다.\r\n");
      out.write("\t<a href=\"#\" style=\"margin-left:10px;\" onclick=\"logout();\">로그아웃</a>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function logout(){\r\n");
      out.write("\tlocation.href = \"/semi/logout?userid=");
      out.print(member.getMemberId() );
      out.write("\" \r\n");
      out.write("\t\t\talert(\"로그아웃되었습니다.\");\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
      out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:loginView()\">재능 등록</a></li>\r\n");
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
      out.write("\t<script src=\"/semi/js/vendor/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("\t<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.0.min.js\"><\\/script>')</script>\r\n");
      out.write("\t<script src=\"/semi/js/bootstrap.js\"></script>\r\n");
      out.write("\t<script src=\"/semi/js/plugins.js\"></script>\r\n");
      out.write("\t<script src=\"/semi/js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <div style=\"margin-left: 30px; width: 230px; height: 500px; float: left; margin-top:200px\">\r\n");
      out.write("\r\n");
      out.write("      <ul id=\"navi\">\r\n");
      out.write("         <li class=\"group\">\r\n");
      out.write("            <div class=\"title\">카테고리</div>\r\n");
      out.write("            <ul class=\"sub\">\r\n");
      out.write("                     <li><a href=\"/semi/cfIT\">IT</a></li>\r\n");
      out.write("               <li><a href=\"/semi/cfdesign\">디자인</a></li>\r\n");
      out.write("               <li><a href=\"/semi/cfmarketing\">마케팅</a></li>\r\n");
      out.write("               <li><a href=\"/semi/cfmusic\">음악</a></li>\r\n");
      out.write("               <li><a href=\"/semi/cfknowhow\">노하우/상담</a></li>\r\n");
      out.write("               <li><a href=\"/semi/cftranslation\">번역</a></li>\r\n");
      out.write("               <li><a href=\"/semi/cfhealth\">건강</a></li>\r\n");
      out.write("               <li><a href=\"/semi/cfetc\">기타</a></li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("         </li>\r\n");
      out.write("\r\n");
      out.write("      </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("   <!-- 반복 끝 -->\r\n");
      out.write("<!--  오른쪽 메뉴바 -->\r\n");
      out.write("   ");
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
      out.write("\r\n");
      out.write("   <!--  그림 -->\r\n");
      out.write("   <div style=\"float:left; width: 1000px; margin-top:200px;\">\r\n");
      out.write("      <hgroup>\r\n");
      out.write("         <h1 style=\"font-size: 20pt\">[검색 결과]</h1>\r\n");
      out.write("         <p>검색된 갯수 : ");
      out.print( list.size() );
      out.write("</p>\r\n");
      out.write("      </hgroup>\r\n");
      out.write("      <br>\r\n");
      out.write("      <div id=\"container\">\r\n");
      out.write("         <!--  더보기 기능 -->\r\n");
      out.write("         <div style=\"clear:both; width: 1000px;\">\r\n");
      out.write("\r\n");
      out.write("            <div id=\"js-load\" class=\"main\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <div  style=\"width:1200px;\">\r\n");
      out.write("            ");
 for(Notice c : list){ 
      out.write("\r\n");
      out.write("             \r\n");
      out.write("      <div class=\"row\" style=\"float:left; width:300px; height:400px;\">\r\n");
      out.write("        <div class=\"col-md-4\" style=\"width:300px;\">\r\n");
      out.write("           <div class =\"lists__item js-load\">\r\n");
      out.write("           <div class=\"imgholder\">\r\n");
      out.write("      \r\n");
      out.write("            <a href=\"/semi/cdetail?cnum=");
      out.print(c.getCategoryNo() );
      out.write("&cpage=");
      out.print( ccurrentPage);
      out.write("\">\r\n");
      out.write("            <img src=\"cuploadfiles/");
      out.print(c.getRenameImage() );
      out.write("\" /> </a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <strong>");
      out.print(c.getCategoryTitle() );
      out.write("</strong>\r\n");
      out.write("            <p >by ");
      out.print(c.getUserId() );
      out.write(" <br>\r\n");
      out.write("            ");
      out.print(c.getCategoryDonation() );
      out.write("원 <br>★★★★ 후기 5건</p>\r\n");
      out.write("          </div> \r\n");
      out.write("                 </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      \r\n");
      out.write("         ");
} 
      out.write("\r\n");
      out.write("         \r\n");
      out.write("         </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- 더보기 끝 -->\r\n");
      out.write("            \r\n");
      out.write("         \r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      </div>\r\n");
      out.write("<!-- 그림 끝 -->\r\n");
      out.write("   \r\n");
      out.write("      \r\n");
      out.write("   </div>\r\n");
      out.write("      \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!--  더보기 -->\r\n");
      out.write("<div class=\"floating\">\r\n");
 if(list.size() > 12){ 
      out.write("\r\n");
      out.write("   <div id=\"js-btn-wrap\" class=\"btn-wrap\" style=\"\"> <a href=\"javascript:;\" class=\"button\">더보기</a> </div>\r\n");
      out.write("  </div>\r\n");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <div id=\"footer\" style=\"clear: both;\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("         <div class=\"row\">\r\n");
      out.write("         \r\n");
      out.write("            <div class=\"col-md-8 col-xs-12 text-left\">\r\n");
      out.write("               <span>Copyright &copy; 2017 다재다능</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.text-center -->\r\n");
      out.write("            <div class=\"col-md-4 hidden-xs text-right\">\r\n");
      out.write("               <a href=\"#top\" id=\"go-top\">Back to top</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <!-- /.text-center -->\r\n");
      out.write("         </div>\r\n");
      out.write("         <!-- /.row -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.container -->\r\n");
      out.write("      \r\n");
      out.write("   </div>\r\n");
      out.write("   <!-- /#footer -->\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
