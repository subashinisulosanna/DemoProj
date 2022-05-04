<%@ page import="org.example.HelloWorldAction" %>
<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Index</title>
	<s:head />
</head>
<body>
	<s:form>
		<s:textfield label="Enter your name  " name="name"  id="name"/>
		<s:textfield label="Enter your password " name="password" id="password"/>
		<s:textfield label="Enter your email " name="email" id="email"/>
		<p id="result"></p>
		<s:submit id="submit"><a href="success.jsp"></a></s:submit>


	</s:form>
	<p id="result"></p>
	<br/><br/>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		var res="";
		function printValues(obj) {
			for(var k in obj) {
				if(obj[k] instanceof Object) {
					alert(k);
					printValues(obj[k]);

				} else {
					res+=obj[k];
				}
			}

		};
		$(document).ready(function () {
			$("#submit").click(function () {
				// get inputs
				var userName = $('#name').val();
				var userPass= $('#password').val();
				var email=$('#email').val();
				if (userName === "" || userPass=== "" || email==="") {
					event.preventDefault();
					alert("All Fields Are Mandatory.");
				} else
				{
					var test = {
						"user":{
							"name": userName,
							"password": userPass,
							"email":email
						}

					};
					var myVar = JSON.stringify(test);


					alert(myVar);
					$.ajax({
						url: 'helloWorld',

						type: 'post',
						data:myVar,
						contentType: 'application/json',
						dataType: 'json',
						async:true,
						//mimeType: 'application/json',

						success: function (data) {
							//just for printing purpose
							var json = JSON.stringify(data);
							json=JSON.parse(json);
							alert(json.name+"-----");

							printValues(json);
							$("#result").html(res);

						}
						,

					});
				}
			});
		});
	</script>

<p>Already have an account ? </p><a href="login.jsp">Login</a>

</body>


</html>
