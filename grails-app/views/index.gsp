<html>
<head>
<meta name="Layout" content="main"/>
<title></title>
<style type="text/css">
label{
float:left;
width:65px;
}

div{
    padding-top:10px
}

</style>
</head>
<body>
<g:form controller="user" action ="login" style="padding-left:200px">
<div style="width:200px">
<div>
<label>Email:</label> <input type="text" name="email" required=true/>
</div>
<div>
<label>Password:</label> <input type="password" name="password" required=true/>
</div>
<div>
<input type="submit" value="Login"/>
</g:form>
<g:form controller="user"action="register" style="float:right">
<input type="submit" value="Register"/>
</g:form>
</div>
</div>
</body>
</html>
