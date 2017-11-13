<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String s = "";
	try{
	int num1 = Integer.parseInt(request.getParameter("n1"));
	int num2 = Integer.parseInt(request.getParameter("n2"));
	String oper = request.getParameter("oper");

	if (oper.equals("add")) {
		s = String.format("%d+%d=%d", num1, num2, num1 + num2);
	} else if (oper.equals("sub")) {
		s = String.format("%d-%d=%d", num1, num2, num1 - num2);
	} else if (oper.equals("mul")) {
		s = String.format("%d*%d=%d", num1, num2, num1 * num2);
	} else if (oper.equals("div")) {
		s = String.format("%d/%d=%d", num1, num2, num1 / num2);
	}} catch(ArithmeticException e){
		s = "0으로는 나눌 수 없습니다.";
	} catch (NumberFormatException e){
		s = "계산 값이 숫자가 아닙니다.";
	}
%>

<b><%=s%></b>
