# PalevoBotAPI
Good URL examples
List of users:
GET http://localhost:8080/api/users
Single User by username:
GET http://localhost:8080/api/users/username
Add a user:
POST http://localhost:8080/api/users
Update info about some User by username:
PUT http://localhost:8080/api/users/{username}
BODY: 
{
"username": "updatedUserName"
}
Delete a user:
DELETE http://localhost:8080/api/users/{username}
