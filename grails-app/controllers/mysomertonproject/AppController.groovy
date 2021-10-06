package mysomertonproject

class AppController {

    def index() { 
        
        if(session.user != null){
            redirect(controller:"user")
        }
        else{
            render(view:"/index")
        }

    }
}
