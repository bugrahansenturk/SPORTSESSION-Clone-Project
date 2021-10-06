package mysomertonproject

import java.text.SimpleDateFormat

class Session {


    boolean available = true

    String title
    String location
    String picture = "https://www.mysomerton.com/assets/ssc-logo.png"
    String type // 1-1 or Group


    Date creationDate = new Date()
    Date sessionDate = new Date().plus(7)

    int quota
    int price

    Sport sport

    User user


    static constraints = {


        title(nullable:false, blank:false)
        location(nullable:false, blank:false)
        type(nullable:false,blank:false)
        creationDate(nullable:false,blank:false)
        sessionDate(nullable:false, blank:false)

        quota(min:0, nullable:false, blank:false)

        sport(nullable:false, blank:false)
        user(nullable:false, blank:false)

        available(nullable:false, blank:false)
        
    }

     String toString(){
        return title
    }



}
