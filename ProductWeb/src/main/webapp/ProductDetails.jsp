<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.model.Product,com.dao.ProductDao,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>

<style>
body{
background-color:#18191f;
}
input,select,button{
border: 1px solid black;
padding:10px;
border-style:inset;
border-radius:5px;
}
input{
background-color:light blue;
border:none;
}
table{
border:4px solid white;
padding:25px;
background-image: linear-gradient(#ADD8E6, white);
border-radius:15px;
color:black;
}
h2{
font-family:Trebuchet MS;
color:white;
}
.displayall td{
padding:20px;
}

.displayall th{
padding:20px;
}
button{
 background-color: black;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 1;
  transition: 0.3s;
}
button:hover{
opacity:0.6;
}
</style>
</head>
<body>

<%
Product p=(Product)request.getAttribute("p");

 %>
<center>
<h2 > Product Details</h2>
<hr>
<form action="ProductServlet" method="post">
<table>

<tr>
	<td align="right">Id :</td>
	<td><input type="text" name="pid" value="<%=p.getPid()%>" readonly="readonly"></td>
</tr>
<tr>
	<td align="right">Name :</td>
	<td><input type="text" name="pname" value="<%=p.getPname()%>"></td>
</tr>

<%
ArrayList<String> list=new ArrayList();
list.add("Food");
list.add("Fashion");
list.add("Computer & Hardware");
list.add("Mobile & Smartphone");
%>
<tr>
	<td align="right">Product Type:</td>
	<td><select name="ptype">
		<%
		for(String s:list)
		{
			if(p.getPtype().equals(s))
			{%>
				<option value="<%=s%>" selected><%=s%></option>
				
			<%}
			else
			{%>
			<option value="<%=s%>"><%=s%></option>
		<%}
		}%>
	    </select>
	</td>
</tr>

<tr>
	<td align="right">Description :</td>
	<td><input type="text" name="pdesc" style="height:65px;" value="<%=p.getPtype()%>"></td>
</tr>
<tr>
	<td align="right">Price :</td>
	<td><input type="text" name="pprice" value="<%=p.getPprice()%>"></td>
</tr>


</table><br><br>
<button name="b1" type="submit" value="Update">UPDATE</button>
</form>
</center>

</body>
</html>