# MySomertonProject-BugrahanSenturk

## Versions

> | Grails Version: 4.0.12
| JVM Version: 15.0.1
| distributionUrl=https\://services.gradle.org/distributions/gradle-6.3-bin.zip 

**Plugins:**

>| com.github.agorapulse.grails-aws-sdk:aws-sdk-s3:2.4.14 

### Install Plugins:

In Build.gradle:

```java
repositories {
    maven { url 'https://jitpack.io' }
    maven { url "https://repo.grails.org/grails/core" }
}

dependencies {
		compile 'com.github.agorapulse.grails-aws-sdk:aws-sdk-s3:2.4.14'
}
```

After loading Plugin you need to implement S3 access and secret key's to application.yml file.

In conf/application.yml:

```java
grails:
    plugin:
            awssdk:
                accessKey: {ACCESS-KEY}
                secretKey: {SECRET-KEY}
                region: eu-central-1  
                s3:
                    bucket: bugrahandeveloperproject
```

> Please use accessKey and secretKey that provided you by email.
> 

After that application is ready to run.

In Terminal:

```bash
$grails

grails> run-app
```

[Cases & Assumptions](https://www.notion.so/15efe86915d9419fbbe11601944921a0)

---

## Database Model:

![Untitled](readme/Untitled.png)

# User Test

## Login as client:

After enter e-mail and password users are able to login.

![Ekran Resmi 2021-10-06 18.03.59.png](readme/Ekran_Resmi_2021-10-06_18.03.59.png)

Clients list all the Available Sessions.

![Ekran Resmi 2021-10-06 18.05.54.png](readme/Ekran_Resmi_2021-10-06_18.05.54.png)

Clients can Filter Sessions by Location and/or Sport in index page using Dropdown menu and filter button:

![Ekran Resmi 2021-10-06 18.25.15.png](readme/Ekran_Resmi_2021-10-06_18.25.15.png)

![Ekran Resmi 2021-10-06 18.25.44.png](readme/Ekran_Resmi_2021-10-06_18.25.44.png)

---

## Login as Coach:

![Ekran Resmi 2021-10-06 18.06.49.png](readme/Ekran_Resmi_2021-10-06_18.06.49.png)

Coaches see only their sessions. They see both available and unavailable sessions and can edit them.

![Ekran Resmi 2021-10-06 18.07.03.png](readme/Ekran_Resmi_2021-10-06_18.07.03.png)

Coaches Create new sessions from index page using inputs and dropdown menus. (program gets Session's sport type directly from User's attributes.)

![Ekran Resmi 2021-10-06 18.09.59.png](readme/Ekran_Resmi_2021-10-06_18.09.59.png)

![Ekran Resmi 2021-10-06 18.10.11.png](readme/Ekran_Resmi_2021-10-06_18.10.11.png)

---

## Register a Client or Coach

Users register from that page as Coach or Client. If user selects "coach" as account type  a new dropdown will open to get user's sport.

![Ekran Resmi 2021-10-06 18.08.08.png](readme/Ekran_Resmi_2021-10-06_18.08.08.png)

![Ekran Resmi 2021-10-06 18.28.36.png](readme/Ekran_Resmi_2021-10-06_18.28.36.png)

---

![Ekran Resmi 2021-10-06 18.08.55.png](readme/Ekran_Resmi_2021-10-06_18.08.55.png)

![Ekran Resmi 2021-10-06 18.09.20.png](readme/Ekran_Resmi_2021-10-06_18.09.20.png)

---

## Edit Sessions:

After clicking Session's title in index page;

You can upload a new image to AWS S3 with Select File and Upload buttons.

![Ekran Resmi 2021-10-06 18.16.57.png](readme/Ekran_Resmi_2021-10-06_18.16.57.png)

![Ekran Resmi 2021-10-06 18.17.13.png](readme/Ekran_Resmi_2021-10-06_18.17.13.png)

### Edit Attributes

You can edit Title, Location and Availibility of a session using dropdown menus and "Edit" button.

![Ekran Resmi 2021-10-06 18.18.00.png](readme/Ekran_Resmi_2021-10-06_18.18.00.png)

![Ekran Resmi 2021-10-06 18.18.54.png](readme/Ekran_Resmi_2021-10-06_18.18.54.png)

## Edit User

After clicking Edit User button in index page;

You can change profile Picture and Location.

![Ekran Resmi 2021-10-06 18.31.45.png](readme/Ekran_Resmi_2021-10-06_18.31.45.png)

## Attend to Session as client:

As a client, you can see all available sessions and with clicking the title;

You can see details about session and Attend Session . 

![Untitled](readme/Untitled%201.png)

![Ekran Resmi 2021-10-06 18.34.03.png](readme/Ekran_Resmi_2021-10-06_18.34.03.png)

Session's Quota was 1 so when client attend to session, It becomes unavailable and non of clients show the session.

![Ekran Resmi 2021-10-06 18.34.22.png](readme/Ekran_Resmi_2021-10-06_18.34.22.png)

Let's check a group session:

![Untitled](readme/Untitled%202.png)

![Untitled](readme/Untitled%203.png)
