<!DOCTYPE html>
<html>
    <head>
    <style type="text/css">

div {
    padding-top:10px
}
#sport-div {
    display: none;
}
label{
float:left;
}
</style>
        <meta name="layout" content="main" />
    </head>
    <body>

        <div class="nav" role="navigation" style="padding-left:20px">

        <div>
        <p>Details about: ${user.firstName +" "+user.lastName}<br>

        Email: ${user.email}<br>

        Location: ${user.location} <br>

        Change Location:
        </p> 
        <g:form controller= "user" action ="update" id="${user.id}">

        <select name="location" id="location">
                        <option value="" disabled selected class="hidden">Select</option>
                        <option value="London">London</option>
                        <option value="Istanbul">Istanbul</option>
        </select>

        <label></label><input type="submit" value="Change"/>

        </g:form>

        </div>



<div style="padding-top:0px;padding-left:50px">

<h2> Change Profile Picture: </h2>
        <img src= "${user.picture}" style="width:150px">

<g:uploadForm name="file" action="update" id="${user.id}">
    <input type="file" name="file" />
        <input class="save" type="submit" value="Upload" />
</g:uploadForm>

</div>
        




    </body>
</html>