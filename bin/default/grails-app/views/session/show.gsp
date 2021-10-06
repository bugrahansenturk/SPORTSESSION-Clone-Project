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
        <p>Details about: ${session.title}<br>

        Location: ${session.location} <br>




<g:if test = "${user.role == "client" && session.available}">

  <g:form controller="session" action ="attend" id="${session.id}">

        <label></label><input type="submit" value="Attend Session"/>

        </g:form>
</g:if>



<g:if test="${user.id == session.user.id}">
   

    </p> 

        
        <g:form action ="update" id="${session.id}">


        <label>Title:</label> <input type="text" name="title"/>


        <div>
        <label>Location:</label>
        <select name="location" id="location">
                        <option value="" disabled selected class="hidden">Select</option>
                        <option value="London">London</option>
                        <option value="Istanbul">Istanbul</option>
                        <option value="Online">Online</option>
        </select>

        </div>




    <div>
    <label> Availibity </label>
        <select name="available" id="available">
                        <option value="" disabled selected class="hidden">Select</option>
                        <option value="1">Yes</option>
                        <option value="0">No</option>

                    
            </select>
</div>
    
        <label></label><input type="submit" value="Edit"/>


        </g:form>

        </div>



<div style="padding-top:0px;padding-left:50px">

<h2> Change Picture: </h2>
        <img src= "${session.picture}" style="width:150px">

<g:uploadForm name="file" action="update" id = "${session.id}">
    <input type="file" name="file" />
        <input class="save" type="submit" value="Upload" />
</g:uploadForm>

</div>
        
</g:if>
     




    </body>
</html>