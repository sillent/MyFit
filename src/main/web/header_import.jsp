<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
  <style type="text/css">
    body {
      /*background-image: url("/titul.jpg");*/
      background-color: #aaffee;
      color: #627d1b;
    }
    th, td {
      background-color: #dddddd;
      width: 150em;
    }

    table.center {
      margin-left:auto;
      margin-right:auto;
    }
  </style>
  <link rel="stylesheet" type="text/css" href="/codebase/dhtmlxcalendar.css"/>
  <script src="/codebase/dhtmlxcalendar.js"></script>
  <script>
    var myCalendar;
    function doOnLoad() {
      myCalendar = new dhtmlXCalendarObject(["calendar"]);
    }
  </script>



