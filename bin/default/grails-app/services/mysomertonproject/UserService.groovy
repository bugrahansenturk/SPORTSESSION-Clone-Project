package mysomertonproject


import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def get(id){
        User.get(id)
    }

    def list() {
        User.list()
    }

    def save(user){
        user.save()
    }
 
    def delete(id){
        User.get(id).delete()
    }


    def update(user, String location){
        def userInstance = User.get(user.id) //id is the primary key
            userInstance.location = location
            userInstance.save()
    }

    def update_picture(user,String picture){

        def userInstance = User.get(user.id) //id is the primary key
        userInstance.picture = picture.toString
        userInstance.save()
    }

}