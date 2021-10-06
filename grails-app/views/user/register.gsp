<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


<head>
<meta name="Layout" content="main"/>
<title></title>
<style type="text/css">

div {
    padding-top:10px
}
#sport-div {
    display: none;
}
label{
float:left;
width:200px;
}
</style>

<script>

function showDiv(divId, element)
{
    document.getElementById(divId).style.display = element.value == "coach" ? 'block' : 'none';
}
</script>
</head>



<body>
<g:form controller="user" action ="register" style="padding-left:200px">

<div>
<h2>Register</h2>
<div>
<label>Email:</label> <input type="text" name="email" required=true/>
</div>
<div>
<label>Password:</label> <input type="password" name="password" required=true/>
</div>
<div>
<label>First Name:</label> <input type="text" name="firstName" required=true/>
</div>
<div>
<label>Last Name:</label> <input type="text" name="lastName" required=true/>
</div>
<label>Location: </label>
<select name="location" id="location" >
                        <option value=" " disabled selected class="hidden">Select</option>
                        <option value="London">London</option>
                        <option value="Istanbul">Istanbul</option>
</select>
                
<div>

<label>Select type of account:</label>
    
<select name="role" id="role" onchange="showDiv('sport-div', this)" >
                        <option value=" " disabled selected class="hidden">Select</option>
                        <option value="client">Client</option>
                        <option value="coach">Coach</option>
</select>
                
<div id="sport-div" style="padding-top:20px">
<label>Select type of Course you will teach:</label>
<select name="sport" id="sport">
                        <option value="0" disabled selected class="hidden">Select</option>
                        <option value="2">Boxing</option>
                        <option value="1">Yoga</option>
                    </select>
</div>

<div>

</div>

</div>

<div style= "padding-top:30px">
<label></label><input type="submit" value="Register Now"/>
</div>
</div>
</g:form>

</body>
</html>
