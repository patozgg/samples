**Springboot example using Camunda SPIN**

This is a Springboot example. It shows how you can use Camunda Spin to create a JSON object from a POJO, set it as a process variable
and then retrieve and print it. 

**How to Run:**

1.	Download project folder to your computer and import to your IDE "https://github.com/patozgg/samples/tree/master/example-camunda-springboot-plugin-serializer". 
2.	Run the CamundaApplication.java from your IDE. 
3.  Now go to http://localhost:8080/app/welcome/default/ and onto tasklist and start the process
4.  Check the IDE console to see a print of the retrieved JSON object. 



**To Know**

There are two delegate expression being used in the process. One creates the serialized JSON object and the other one retrieves the serialized object and prints it. 
