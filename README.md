# EmployeeManagement
Employee Management System

Employee management has two tables
1.employee {fields:- EMPID,FIRSTNAME,MIDDLENAME,LASTNAME,EMAIL}
2.department {fields:- ID,EMPID,DEPTNO,DEPARTMENTNAME}
Employee and department has one to many relationship, department table has empid field(foreign key)

Swagger2 api used url:- http://localhost:8080/swagger-ui.html#

To access application baseurl/api/v1/{employee/department} (base url means--https://localhost:8080)

To Create Employee (method POST):- 
url:- http://localhost:8080/api/v1/employees

{
  "firstName":"Naveen",
  "middleName":"",
  "lastName":"M",
  "email":"abc@gmail.com"
  
 }

To Update Employee (method PUT):- 
url:- http://localhost:8080/api/v1/employees/3

{
"firstName": "Vivek",
"middleName": "Banahalli",
"lastName": "B C",
"email": "vivek@gmail.com"
}

To Read all and read by id {method GET} (http://localhost:8080/api/v1/employees/http://localhost:8080/api/v1/employees/1)
To delete an employee(method DELETE) :- http://localhost:8080/api/v1/employees/1

To Create Department (method POST):- 
url:- http://localhost:8080/api/v1/department
{
  "departmentName": "BPO",
  "deptNo": 40,
  "empId": {
    "email": "abc@gmail.com",
    "empId": 23,
    "firstName": "Naveen",
    "lastName": "M",
    "middleName": ""
  }
}

To Update Department (method PUT):- 
url:- http://localhost:8080/api/v1/employees/3

url:- http://localhost:8080/api/v1/department/3
{
  "empId":{
    "empId":20
  },
  "deptNo":20,
  "departmentName":"PEGG"
  
}

To Read all and read by id {method GET} (http://localhost:8080/api/v1/department/http://localhost:8080/api/v1/department/1)
To delete an department(method DELETE) :- http://localhost:8080/api/v1/department/1

To check internationalization(Spring messages)
baseurl/api/v1/internationalized

Spring profiles:-
I have used defualt dev profile where i have defined DB connections details, here i have used application.properties instead of java application (@Profile)

Here I have used Spring boot security with JWT in memory user that's why i have find sortage of time to change into data base and configure user DTO to userDetailservice and check roles.
Here multiple part didn't handle due above constraint.

JWT token :- 

JWT Secret key :-

jwt.secret=employeeManagement
jwt.get.token.uri=/authenticate

To authenticate to get Bearer token:-
http://localhost:8080/authenticate

username=admin or prakash
password= password

Regards,
Prakash M

