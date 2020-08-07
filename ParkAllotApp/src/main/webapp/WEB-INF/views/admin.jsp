<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html  lang="en" >
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href= 
"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
      
    <script src= 
"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> 
    </script> 
      
    <script src= 
"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"> 
    </script> 
      
    <script src= 
"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"> 
    </script> 
<title>Insert title here</title>
<style>
 
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
.cancelbtn {
     width: 100%;
  }
  
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}
#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

</head>
<body>
<div class="container"> 
          
       <hr>
          
        <h2 style="text-align:center;">Administrator Usage</h2> 
  			<hr>
               </div>
      
      
    
    <button type="button" class="cancelbtn" onclick="register()">Add User</button>
  

 <div>
 		<br>
 		<br>
 </div>
 
 
 
  <table id="customers">
   <thead>
    <tr>
     <th>Name</th>
     <th>Email</th>
     <th>Place</th>
     <th>Time</th>
      <th>Action</th>
    </tr>
   </thead>
   <tbody>
  <c:forEach var="row" items="${ulist}">
 <tr>
     <td>${row.name}</td>
     <td>${row.email}</td>
     <td>${row.place}</td>
      <td>${row.time}</td>
      <td><a onclick="return confirm('Are you want to delete this item?')" href="<%= request.getContextPath()%>/deleteUser/${row.id}" class="btn btn-danger"><i class="fa fa-trash"></i> Delete</a>
                                </td>
      <!--  td><form action="/deleteUser/${row.id}" ><button type="button" class="cancelbtn"> Delete</button></form></td>-->
    </tr>
    </c:forEach>
   </tbody>
  </table>
  
   <div>
      <hr>
      </div>
       <div style="text-align:center">  
    <button type="button" style="text-align:center;"  class="cancelbtn" onclick="logout()" >Logout</button>
   </div>

</body>
<script>
function register(){
	window.location.href="/newuser";
}

function logout(){
	window.location.href="/logout";
}
</script>
</html>