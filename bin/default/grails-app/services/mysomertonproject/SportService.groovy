package mysomertonproject


import grails.gorm.transactions.Transactional

@Transactional
class SportService {


    def get(id){
        Sport.get(id)
    }

    def list() {
        Sport.list()
    }

    def save(sport){
        sport.save()
    }
 
    def delete(id){
        Sport.get(id).delete()
    }

}
