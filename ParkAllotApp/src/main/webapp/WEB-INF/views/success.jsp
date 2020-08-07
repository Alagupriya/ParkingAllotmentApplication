<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I</title>
<style>


button {
  background-color:#4CAF50;
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
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

</style>

</head>
<body>
<div> 

</div>  
         <h3 style="text-align:center;">Registration Successful </h3>
		<h3 style="text-align:center;">${msg} </h3>
      <h3 style="text-align:center;">Thank you ...</h3>
      <div>
      <hr>
      
      </div>
     
     <div style="text-align:center">  
  
    <button type="button" style="text-align:center;"  class="cancelbtn" onclick="logout()" >Logout</button>

     </div>
     

</body>
<script type="text/javascript">
function logout(){
	window.location.href="/logout";
}
</script>
</html>