package mysomertonproject


import grails.gorm.transactions.Transactional

@Transactional
class SessionService {

    def get(id){
        Session.get(id)
    }

    def list() {
        Session.list()
    }

    def save(session){
        session.save()
    }
 
    def delete(id){
        Session.get(id).delete()
    }

}
