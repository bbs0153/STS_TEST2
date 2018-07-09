<%@page import="com.mongodb.DBCursor"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.Mongo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-color: #e1ddd9;
	font-size: 12px;
	font-family: Verdana, Arial, Helvetica, SunSans-Regular, Sans-Serif;
	color: #564b47;
	margin: 0px;
	text-align: center;
}

div#contentarea {
	text-align: left;
	vertical-align: middle;
	margin: 0px auto;
	padding: 0px;
	width: 550px;
	background-color: #ffffff;
	border: 1px #564b47;
}

div#innercontentarea {
	padding: 10px 50px;
}

div#innercontentarea form input[type=text] {
	width: 435px;
}

div#innercontentarea form textarea[name=content] {
	width: 435px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		DBCursor c = null;
		int pageSIZE = 5;
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int skip = (currentPage - 1) * pageSIZE;
		int totalCount = 0;
		int totalPage = 0;
		try {
			Mongo mongo = new Mongo();
			DB db = mongo.getDB("myblogdb");
			DBCollection collection = db.getCollection("articles");
			c = collection.find();

			totalCount = c.size();
			totalPage = (int) Math.ceil(totalCount / (double)pageSIZE);
			c.sort(new BasicDBObject().append("saved_at", -1)).skip(skip).limit(pageSIZE);
	%>
	<div id="contentarea">
		<div id="innercontentarea">
			<h1>Dashboard</h1>
			<table class="articles" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th width="55%">Title</th>
						<th width="27%">Created at</th>
						<th width="*">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
						while (c.hasNext()) {
								DBObject ob = c.next();
					%>
					<tr>
						<td><%=ob.get("title")%></td>
						<td><%=ob.get("saved_at")%></td>
						<td><a href="blogDetail.jsp?id=<%=ob.get("_id")%>">View</a></td>
						<td><a href="blogEdit.jsp?id=<%=ob.get("_id")%>">Edit</a></td>
					</tr>
					<%
						}
							mongo.close();
						} catch (Exception e) {
							System.out.println(e);
						}
					%>
				</tbody>
			</table>
		</div>


		<div id="navigation">
			<div class="prev">
				<%
					if (currentPage != 1) {
				%>
				<a href="dashBoard.jsp?page=<%=currentPage - 1%>">Prev</a>
				<%
					}
				%>
			</div>
			<div class="page-number">
				<%=currentPage%>
			</div>
			<div class="next">
				<%
					if (currentPage != totalPage) {
				%>
				<a href="dashBoard.jsp?page=<%=currentPage + 1%>">Next</a>
				<%
					}
				%>
			</div>
			<br class="clear" />
		</div>
	</div>
</body>
</html>