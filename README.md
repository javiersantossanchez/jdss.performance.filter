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
TODO: Update the example with all the information
> 2019-07-16 17:02:19,230 INFO j.p.f.c.f.GeneralFilter [default task-107] Resource requested: /test/ ----- Time spend:  0  -----  Status:  200
 
In futures versions I want add more options to save the information, like save into a database, or send the information to server 


## The project structure
There are 2 main folders into that project.
      
> ### jdss.performance.filter.code
> This is the main folder, Inside you will find the source code related to the filter component and the unit test.   
    
    
> ### jdss.performance.filter.asppTest 
> Inside you will find teh source code of a very basic web app where you can check how integrate the filter 
to your applications 
