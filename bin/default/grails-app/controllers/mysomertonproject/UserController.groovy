package mysomertonproject

import org.springframework.web.multipart.MultipartFile
import com.amazonaws.services.s3.model.ObjectListing
import com.amazonaws.services.s3.model.S3ObjectSummary
import grails.gorm.transactions.Transactional


class UserController {

def amazonS3Service

    def show(String id){
        render(view:"show", model:[user:User.get(id as int)])
    }


    def index() {
        if(session.user == null){
            redirect(controller:"app")
            return
        }
        def results
        def role

        if(session.user.role == "coach"){
            results = Session.findAllWhere(user:session.user)
        }else{
            if((params.location == null && params.type == null) || (params.location == "all" && params.type == "all")){ 
                    results = Session.findAllWhere(available:true)
            }else if(params.location == "all" && params.type != "all"){
                    def filterSport = Sport.get(params.type as int)
                    results = Session.findAllWhere(available:true,sport:filterSport)
            }else if(params.location != "all" && params.type == "all"){
                    results = Session.findAllWhere(available:true,location:params.location)
            }else{
                    def filterSport = Sport.get(params.type as int)
                    results = Session.findAllWhere(available:true, location:params.location,sport:filterSport)
            }
        }
        render(view:"index", model:[sessionList:results,user:session.user])
    }



    def register(){
        try{
            def newUser
            if(params.sport == null){
                newUser = new User(
                    email:params.email, 
                    password:params.password,
                    firstName:params.firstName,
                    lastName:params.lastName,
                    role:params.role,
                    profilePicture:"https://www.mysomerton.com/assets/ssc-logo.png").save(failOnError:true)          
            }else{
                def selectedSport = Sport.get(params.sport as int)
                newUser = new User(
                    email:params.email, 
                    password:params.password,
                    firstName:params.firstName,
                    lastName:params.lastName,
                    role:params.role,
                    profilePicture:"https://www.mysomerton.com/assets/ssc-logo.png",
                    sport:selectedSport).save(failOnError:true)      
            }
            if(newUser){
                session.user = newUser
                redirect(controller:"user")
                return
            }
            else{
                render(view:"register")
            }

        }catch(Exception ex){
            render(view:"register")
            println(ex)
        }
    }


    def login(){
        User loggingUser = User.find({email == params.email})
        if(!loggingUser){
            render("User not exist")
            return
        }
        if(!(loggingUser.password == params.password)){
            render("Wrong password")
            return
        }
        session.user = loggingUser

        if(session.user){
            redirect(controller: "user")
            return
        }
    }


    def logout(){
        if(session.user != null){
            session.user = null
        }else{
            println("User already logged out")
        }
        redirect(controller:"app")
        return
    }


    @Transactional
    def update(String id){
        def userInstance = User.get(id as int)
        if(params.file != null){
            MultipartFile multipartFile = request.getFile('file')
            if(multipartFile && !multipartFile.empty) {
                try{
                    String fileLink = amazonS3Service.storeMultipartFile('bugrahandeveloperproject', "testupload/"+"userPicture/"+multipartFile.originalFilename, multipartFile) as String
                    userInstance.picture = fileLink
                    userInstance.save()

                    redirect(controller:"user", action:"show",id:id)       
                    return
                }catch(Exception ex){
                    render("Couln't save file." + ex)
                    return
                }
            }
        }else{
            try{
                if(params.location != "" && params.location != null){
                    userInstance.location = params.location
                    userInstance.save()    
                }
            }catch(Exception ex){
                render("Couldnt update" + ex)
                return
            }
        }
        redirect(controller:"user", action:"show",id:id)       
        return

    }

}
