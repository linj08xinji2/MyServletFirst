<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script type="text/javascript" src="/scripts/jquery-3.1.0.min.js"></script>
      <script type="text/javascript">
        $(document).ready(function(){
          alert("Hello world");
        });
      </script>
  </head>
  
  <body>
    11. <br>
  </body>
</html>
