# **Kotcharat Sukkasem Individual Project**

Java-based web application for build the funds from my photography skill

# **Problem Statement**
Hiring a photographer is very costly, especially for people who need professional photographs. This can cost more than $50. I am not kidding! 

When I was thinking about ideas for Enterprise java class, I looked at my camera for ideas as it is one of my favorite hobbies. The idea I had is a pop up. This pop up is something fun and builds the funds others that are in need. The name of the project is "DoForFund". 

The admin(me) will create an event that every user can sign up for and join on the date. I will send them a picture via email after the event is done.

Then, a user can donate cash in the DoForFund box at the event or donate via the website. The users can donate either anonymously or can sign their name. 

After paying for web services at the end of each year, I will give all the fund to an organization. 

Users will be informed of the history of total funds, and the location where the funds are donated. 

**For future extension**

1. I want others be able to create the volunteer idea in many ways to help build the fund.   
2. I want others be able to create the campaign that need help.
3. Everybody can choose the way to donate the money either by volunteer event or donate to the campaign.


# **Project Technologies/Techniques**

* **Security/Authentication**
1. Tomcat's JDBC Realm Authentication
2. Admin role: create/read/update/delete (crud) of all data
3. User role: edit data they have entered previously
4. All: anyone can view information (no login)
* **Database**
1. MySQL
2. Store users and roles
3. Store all data for the picture
* **ORM Framework**
1. Hibernate 5
* **Dependency Management**
1. Maven
* **CSS**
1. Bootstrap or Materialize
* **Data Validation**
1. Bootstrap Validator for front end
2. Explore Hibernate's validation
* **Logging**
1. Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
* **Hosting**
1. AWS
* **Independent Research Topic/s**
1. CI tools in AWS
2. Materialize
3. Hibernate Validation
4. Hibernat Search
* **Project Lombok to eliminate boilerplate code like getters/setters/equals**
* **Unit Testing**
1. JUnit tests to achieve 80%+ code coverage
* **IDE: IntelliJ IDEA**

# **Design**

* [User Stories](https://github.com/skotcharat/doforfund/blob/master/DesignDocuments/userStories.md)

* [Screen Design](https://github.com/skotcharat/doforfund/blob/master/DesignDocuments/Screens.md)

* [Application Flow](https://github.com/skotcharat/doforfund/blob/master/DesignDocuments/applicationFlow.md)

* [Database Design](https://github.com/skotcharat/doforfund/blob/master/DesignDocuments/databaseDiagram.png)