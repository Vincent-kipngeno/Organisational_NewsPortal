# NEWS PORTAL API
#### AN API WHERE USERS CAN GIVE NEWS CONCERNING A CERTAIN DEPARTMENT AND VIEW THEM,  2020.7.21
#### By **Vincent Kipngeno**
## Description
This is a an api portal where department can be created and viewed. Employees can be added and associated to a department and employees details can also be viewed. Also general news can be reported and viewed and Department news can be created and associated to the respective department. Users and news of specific department can also be accessed and viewed.
## Setup/Installation Requirements
* Git configured in your machine and github account.
* Have gradle to download the dependencies required by the app
* Also set up a postgress database
* To study the database structure open create.sql file in the root folder of the project.
* To set up your database run the following command $ psql < create.sql
* In case you wish to change the database first drop current database by running $ psql < drop.sql 
* Then to effect changes made to create.sql run $ psql < create.sql
* Fork the repo then git clone
* Create another branch so that you can work on it: git branch ft-feature
* To run the app enter the command $ gradle run
* Check the app on local host server localhost://4567

## User Guide
#### Create New Department: 
* Method: POST:
* Route: /departments/new
* Sample Data: 
    {
        "name": "Science",
        "description": "Science Subjects"
    }
#### Create New User: 
* Method: POST:
* Route: /departments/:id/users/new
* Sample Data: 
    {
        "name": "Kevin",
        "role": "Teacher"
    }
#### Create general News: 
* Method: POST:
* Route: /news/new
* Sample Data: 
    {
        "content": "All syllabus should be covered by september",
        "author": "Mutali"
    }
#### Create department News: 
* Method: POST:
* Route: /departments/:id/news/new
* Sample Data: 
    {
        "content": "All syllabus should be covered by september",
        "author": "Mutali"
    }
#### View all departments: 
* Method: GET:
* Route: /departments
#### View individual department: 
* Method: GET:
* Route: /departments/:id
#### View all users:
* Method: GET: 
* Route: /users
#### View individual user: 
* Method: GET:
* Route: /users/:id
#### View all general news: 
* Method: GET:
* Route: /news
#### View news of a particular department: 
* Method: GET:
* Route: /departments/:id/news
#### View users and news of a particular department: 
* Method: GET:
* Route: /departments/:id/users/news

## Known Bugs
There are no known bugs yet but if you come across one feel free to help in contributing to solve the bug or you can reach out to me.
## Technologies Used
Used Java and spark and postgresql database in building this app and Heroku for deployment.
## Support and contact details
In case of any issue reach me via email kipngenovi2001@gmail.com. If you would wish to contribute in improving the code that is highly encouraged.
### License
*MIT*
Copyright (c) 2020 **Vincent Kipngeno**