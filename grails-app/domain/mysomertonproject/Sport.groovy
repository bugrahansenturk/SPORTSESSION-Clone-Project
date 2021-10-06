package mysomertonproject

class Sport {

    String name
    String category
    String description

    static constraints = {
        name(nullable:false,blank:false)
        category(nullable:false,blank:false)
        description(nullable:true,blank:true)
    }
    String toString(){
        return name
    }
}