<%@page import="com.model.Product,com.dao.ProductDao" %>
<html>
<head>

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
<center>
<h2 > Product form</h2>
<hr>
<form action="ProductServlet" method="post">
<table>

<tr>
	<td align="right">Id :</td>
	<td><input type="text" name="pid"></td>
</tr>
<tr>
	<td align="right">Name :</td>
	<td><input type="text" name="pname"></td>
</tr>


<tr>
	<td align="right">Product Type:</td>
	<td><select name="ptype">
			<option value="Food">Food</option>
			<option value="Fashion">Fashion</option>
			<option value="Computer & Hardware">Computer & Hardware</option>
			<option  value="Mobile & Smartphone">Mobile & Smartphone</option>
	    </select>
	</td>
</tr>

<tr>
	<td align="right">Description :</td>
	<td><input type="text" name="pdesc" style="height:65px;"></td>
</tr>
<tr>
	<td align="right">Price :</td>
	<td><input type="text" name="pprice"></td>
</tr>


</table><br><br>
<button name="b1" type="submit" value="Add">ADD</button>
<button name="b1" type="submit" value="Delete"> DELETE</button>
<button name="b1" type="submit" value="Display"> DISPLAY</button>
</form>
<hr>
<h2>Product List</h2>
<hr>
<div class="displayall">
<table border="3">
<th>ID</th>
<th>Name</th>
<th>Type</th>
<th>Description</th>
<th>Price</th>
<th>Options</th>

<% 
int count=0;
double total=0;
for(Product p:new ProductDao().DisplayAll())
{ count++;%>

<tr>  
<td><%=p.getPid() %></td>
<td><%=p.getPname() %></td>
<td><%=p.getPtype() %></td>
<td><%=p.getPdesc() %></td>
<td><%=p.getPprice() %></td>
<%total+=p.getPprice();%>

<td>
<a href="ProductServlet?b1=Delete&pid=<%=p.getPid()%>">Delete</a>
<a href="ProductServlet?b1=Display&pid=<%=p.getPid()%>">Display</a>

</td>
</tr>
	<%}
%>
<tr>
<td colspan="5" align="right">total of(<%=count %>)products:<%=total %></td>
</tr>

</table>
</div>
</center>

</body>
</html>