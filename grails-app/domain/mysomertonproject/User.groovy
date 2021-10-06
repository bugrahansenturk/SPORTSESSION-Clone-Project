package mysomertonproject

class User {

    String email
    String password
    String firstName
    String lastName
    String role
    String picture  = "https://www.mysomerton.com/assets/ssc-logo.png"
    String location

    Sport sport
    
    Date registerDate = new Date()


    static constraints = {

        email(email:true, nullable:false,blank:false)
        password(blank:false, nullable: false)
        firstName(blank:false, nullable: false)
        lastName(blank:false, nullable: false)
        role(blank:false, nullable: false)
        picture(blank:false, nullable: false)

        sport nullable:true, validator: { val,obj ->
            if(obj.role == "coach" && !val) return["sport.required"]
        }
        location(nullable:true, blank:true)


    }


    String toString(){
        return firstName;
    }
}
