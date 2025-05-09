<%-- include 到 testCore.jsp  --%>
<%
	pageContext.setAttribute("jim1", "<h3>Jim1-Test</h3>", PageContext.SESSION_SCOPE);
	pageContext.setAttribute("array", new int[]{1, 2, 4, 5}, PageContext.SESSION_SCOPE);
	pageContext.setAttribute("x", 11, PageContext.SESSION_SCOPE);
	pageContext.setAttribute("lang", "c,python,java,ruby,go",PageContext.PAGE_SCOPE);
%>