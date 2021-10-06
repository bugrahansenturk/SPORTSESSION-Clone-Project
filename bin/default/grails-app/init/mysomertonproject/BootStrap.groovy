package mysomertonproject

class BootStrap {

    def init = { servletContext ->

        Sport yoga = new Sport(name:"Yoga",category:"Relaxing")
        Sport boxing = new Sport(name:"Boxing",category:"Power")

        new User(email:"bugrahansntrk@gmail.com",password:"123456",firstName:"Bugrahan",lastName:"Senturk",role:"client").save()
        new User(email:"client@client.com",password:"1234",firstName:"ClientFirst",lastName:"ClientLast",role:"client").save()

        User coach1 = new User(email:"coach1@coach.com",password:"1234",firstName:"Coach1FirstName",lastName:"CoachLastName",role:"coach",sport:yoga).save()
        User coach2 = new User(email:"coach2@coach.com",password:"1234",firstName:"Coach2FirstName",lastName:"CoachLastName",role:"coach",sport:yoga).save()
        User coach3 = new User(email:"coach3@coach.com",password:"1234",firstName:"Coach3FirstName",lastName:"CoachLastName",role:"coach",sport:yoga).save()
        User coach4 = new User(email:"coach4@coach.com",password:"1234",firstName:"Coach4FirstName",lastName:"CoachLastName",role:"coach",sport:boxing).save()
        User coach5 = new User(email:"coach5@coach.com",password:"1234",firstName:"Coach5FirstName",lastName:"CoachLastName",role:"coach",sport:boxing).save()
        User coach6 = new User(email:"coach6@coach.com",password:"1234",firstName:"Coach6FirstName",lastName:"CoachLastName",role:"coach",sport:boxing).save()
        User coach7 = new User(email:"coach7@coach.com",password:"1234",firstName:"Coach7FirstName",lastName:"CoachLastName",role:"coach",sport:yoga).save()
        User coach8 = new User(email:"coach8@coach.com",password:"1234",firstName:"Coach8FirstName",lastName:"CoachLastName",role:"coach",sport:yoga).save()
        User coach9 = new User(email:"coach9@coach.com",password:"1234",firstName:"Coach9FirstName",lastName:"CoachLastName",role:"coach",sport:yoga).save()



        new Session(title:"Yoga with Coach1", location:"Online",sport:yoga,user:coach1,type:"1to1", quota:1).save()
        new Session(title:"Yoga with Coach2", location:"London",sport:yoga,user:coach2,type:"1to1", quota:1).save()
        new Session(title:"Yoga with Coach3", location:"London",sport:yoga,user:coach3,type:"1to1", quota:1).save()


        new Session(title:"Boxing with Coach4", location:"Online",sport:boxing,user:coach4,type:"gruop", quota:6).save()
        new Session(title:"Boxing with Coach5", location:"London",sport:boxing,user:coach5,type:"gruop", quota:6).save()
        new Session(title:"Boxing with Coach6", location:"London",sport:boxing,user:coach6,type:"gruop", quota:6).save()


        new Session(title:"Yoga with Coach7", location:"Online",sport:yoga,user:coach7,type:"1to1", quota:1).save()
        new Session(title:"Yoga with Coach8", location:"Istanbul",sport:yoga,user:coach8,type:"gruop", quota:6).save()
        new Session(title:"Yoga with Coach9", location:"Istanbul",sport:yoga,user:coach9,type:"gruop", quota:6).save()


    }


    def destroy = {
    }
}
