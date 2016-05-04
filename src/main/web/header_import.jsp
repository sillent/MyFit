<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
  <style type="text/css">
    body {
      /*background-image: url("/titul.jpg");*/
      background-color: #909090;
      color: #34404b;
    }
    th, td {
      background-color: #dddddd;
      width: 150em;
    }

    table.center {
      margin-left:auto;
      margin-right:auto;
    }
    img {
      position: absolute;
      margin: auto;
      /*top:0;*/
      left:0;
      right: 0;
      /*bottom: 0;*/
    }
  </style>
  <link rel="stylesheet" type="text/css" href="/codebase/dhtmlxcalendar.css"/>
  <script src="/codebase/dhtmlxcalendar.js"></script>
  <script>
    var myCalendar;
    var myCalendar2;
    function doOnLoad() {
      myCalendar = new dhtmlXCalendarObject(["calendar"]);
      myCalendar2=new dhtmlXCalendarObject(["calendar2"]);
    }
  </script>



