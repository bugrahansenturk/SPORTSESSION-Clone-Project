<!DOCTYPE html>
<html>
    <head>
      <style type="text/css">

span {
    padding-left:50px;
    padding-right:50px
}
#sport-div {
    display: none;
}
label{
}
</style>
        <meta name="layout" content="main" />
    </head>
    <body>

     <g:if test="${ params.message == "success"}">
        <div class="toast-body">
        Successfully attend to session!
        </div>
        </g:if>
        <g:if test="${ params.message == "fail" }">
        <div class="toast-body">
        <p style="color:red">Couldn't attend to the session</p>
        </div>
        </g:if>
    
        <div class="nav" role="navigation" style="padding-left:20px;padding-bottom:30px">
        
       


        <p>Welcome, ${user.firstName}</p>

            <div style="padding-left:10px">
            <g:if test="${ user.role == "client" }">
               <g:form controller="user" style="padding-left:10px">

                <label for="location">Choose the City:</label>


                    <select name="location" id="location">
                        <option selected = "selected" value="all">-All-</option>
                        <option value="London">London</option>
                        <option value="Istanbul">Istanbul</option>
                        <option value="Online">Online</option>
                    </select>


                <label for="type">Choose the Sport:</label>
                    <select name="type" id="type">
                        <option selected="selected" value="all">-All-</option>
                        <option value="1">Yoga</option>
                        <option value="2">Boxing</option>
                    </select>

                <input type="submit" value="Filter">
            </g:form>
            </g:if>

            </div>
            <div style= padding-left:200px>
                        <g:form controller="user" action="logout">
                        <input type="submit" value="Logout"/>

                        </g:form>
                        </div>

            
            <div style= padding-left:200px>
            <g:form controller="user" action="show" id= "${user.id}">
            <input type="submit" value="Edit User"/>

            </g:form>
            </div>

        </div>

        <div style="padding-left:50px"> 
             <span>Title
            </span>
            <span>
                Sport
            </span>
            <span>
            location
            </span>
            <span>
            type
            </span>
            <span>
            quota
            </span>
            <span>Image
            </span>
</div>
            <g:each in="${sessionList}" var="p">
            <li>

            <span>
            <a href="/session/show/${p.id}">${p.title}</a>
            </span>
            <span>
            ${p.sport}  
            </span>
            <span>
            ${p.location}
            </span>
            <span>
            ${p.type}
            </span>
            <span>
            ${p.quota}
            </span>
            <span>
            <img src = "${p.picture}" style="width:100px;height:100px">
            </span>
            </li>
            </g:each>



<g:if test="${ user.role == "coach" }">
   
        <div style="padding-left:50px">
            <h2> Add Course </h2>
            <g:form controller="session" action ="add">
            <label>Course Title:</label>
            <input type="text" name="title" required/>


            <label>Course location:</label>
            <select name="location" id="location">
                <option value="London">London</option>
                <option value="Istanbul">Istanbul</option>
                <option value="Online">Online</option>
            </select>

            <label>Course Type:</label>
             <select name="type" id="type">
                <option value="1to1">1 To 1</option>
                <option value="group">Group</option>
            </select>


    
            <input type="submit" value="Add"/>
            </div>
            </g:form>

        </div>
</g:if>






    </body>
</html>