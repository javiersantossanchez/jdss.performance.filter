# Filter to register all request received onto your application

An Open source component that provide a http java filter for register all request received by the java application,
in the current version the registration is saved on logger file. 

The information registered is:
*   The url requested 
*   The time spent by the application to response the request.
*   The http status 
*   The client ip
*   The user logged into the app
*   The request's size

This is an example of saved information :   
> 19-07-17 15:24:52,812 INFO Resource requested: /test/        Time spend:  1         Status:  200        IP client: 10.4.13.234        User : User1
 
In futures versions I want add more options to save the information, like save into a database, or send the information to server 


## The project structure
There are 2 main folders into that project.
      
> ### jdss.performance.filter.code
> This is the main folder, Inside you will find the source code related to the filter component and the unit test.   
    
    
> ### jdss.performance.filter.asppTest 
> Inside you will find teh source code of a very basic web app where you can check how integrate the filter 
to your applications 
