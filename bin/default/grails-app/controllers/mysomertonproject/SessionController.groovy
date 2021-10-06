package mysomertonproject
import org.springframework.web.multipart.MultipartFile
import com.amazonaws.services.s3.model.ObjectListing
import com.amazonaws.services.s3.model.S3ObjectSummary
import grails.gorm.transactions.Transactional


class SessionController {

    def amazonS3Service

    def show(String id){
        render(view:"show", model:[session:Session.get(id as int), user:session.user])
    }


    @Transactional
    def attend(String id){
        def sessionInstance = Session.get(id as int)
            if( sessionInstance.quota > 0 && sessionInstance.available){

                sessionInstance.quota = sessionInstance.quota - 1
                if(sessionInstance.quota == 0){
                    sessionInstance.available = false
                }

            sessionInstance.save()
            redirect(controller:"user",params:[message:"success"]) 
            }else{
            redirect(controller: "user", params:[attend:"fail"])
        }
    }



    @Transactional
    def update(String id){

        def sessionInstance = Session.get(id as int)
        if(params.file != null){
            MultipartFile multipartFile = request.getFile('file')
            if(multipartFile && !multipartFile.empty) {
                try{
                    String fileLink = amazonS3Service.storeMultipartFile('bugrahandeveloperproject', "testupload/"+"sessionPicture/"+multipartFile.originalFilename, multipartFile) as String
                    
                    sessionInstance.picture = fileLink
                    sessionInstance.save()
                    redirect(controller:"session",action:"show",id:id, message:"success")        
                    return
                }catch(Exception ex){
                    redirect(controller:"session",action:"show",id:id, message:"fail")        
                }
            }
        }
        else{
            try{
                if(params.title != "" && params.title != null){
                    sessionInstance.title = params.title
                    sessionInstance.save()    
                }
                if(params.location != "" && params.location != null){
                    sessionInstance.location = params.location
                    sessionInstance.save()    
                }
                if(params.available != "" && params.available != null){
                    if(params.available == "0"){
                        sessionInstance.available = false
                    }else{
                        sessionInstance.available = true
                    }

                    sessionInstance.save()    
                }
                    redirect(controller:"session",action:"show",id:id, message:"success")        
                return
            }catch(Exception ex){
                    redirect(controller:"session",action:"show",id:id, message:"fail")        
                return
            }
        }
        
    }



    def add() {
        if(session.user == null || session.user.role == "client"){
            redirect(controller:"app")
            return
        }
        try{
            def quota = 6
            if(params.type == "1to1"){
                quota = 1
            }
            def creator = User.get(session.user.id)

            new Session(
                title:params.title,
                location:params.location,
                sport:creator.sport,
                picture:"https://www.mysomerton.com/assets/ssc-logo.png",
                user:creator,
                type:params.type,
                quota:quota).save(failOnError:true)

            redirect(controller:"user")

        }catch(Exception ex){
            render("Couldn't add session" + ex)
            return
        }
    }

}
