# CPMIS - Company Project Management and Information System
Spring Web Project(Maven - Spring MVC/Security - Hibernate - JSP)
	
	Preparer : Yunus Bagriyanik - Software Developer

About the project

	I've created full working Spring MVC Hibernate application that connects to a database. 
  Via the web page we will send information to database. This project provides reporting of project management and project 
  information of any company. It’s a web based project. In other words, it can be called project management automation. 
  Access to the website is belongs for company employees only. In total, three roles to enter the page have been identified. 
  These are leader, admin and employee. Within the page takes place projects to be developed by the company. 
  The manager in the Leader role shares the project information to be developed in the project section of the page. 
  Access to project sharing only belongs to the manager of the leader role. The director of the project opens the project 
  in the system and enters the project details into the system. In the project details, employee responsible for the project is
  assigned to the project. Then the responsible employee and his staff can enter the system detailed information 
  about the development stages of the project. Any information entered is saved on the page. 
  In this way, the history of the project information can be followed.

Technologies used within the scope of the project.

    • Maven
    • Hibernate
    • Spring
    • Spring MVC
    • Spring Security
    • JSP
    • Spring REST(Under development)

Spring Framework
	It is an application development framework that facilitates and accelerates the development of enterprise java applications.

Spring MVC
	Spring MVC is a Web infrastructure system within the Spring ecosystem. Based on the MVC design model, it is a software architecture design pattern.
  It provides a solution for layering an application by separating three images; business, presentation, and control flow.

MVC Architecture
	Model - View - Controller is a web application architecture. It enables the application to be performed by dividing 
  it into layers in terms of interface, data, work-processing. In this way, layers can be used and updated independently of each other. 
  This makes it easier to manage the application.

    • Model: The layer responsible for the application data. We can say that is object definitions required for our application.
    • View: The layer responsible for presenting the model data as an interface to the user.
    • Controller:  This layer responsible for evaluating the user requests and updating the relevant model.
    
    Spring Security
	Two basic security needs of enterprise applications is in question.
1. Authentication
2. Authorization
Spring Security is a framework that provides authentication and authorization services for enterprise Java applications. 
Provided the security of the application with spring security. 

Maven
	Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM),
  Maven can manage a project's build, 
  reporting and documentation from a central piece of information. Maven is a tool that enables us to set a standard 
  in the project while simplifying the development process, 
  effectively creating our documentation, eliminating library dependency and IDE dependency in our project.

JavaServer Pages – JSP
	It’s a Java Technology that allows us to create dynamic web pages using Java Language in web pages. JSP is the Servlet extension. 
  JSP codes that we write in HTML are converted to Servlets on the server.

Servlet: Servlet is a Java classes that uses Java Technology to generate dynamic web output. 

     How does the servlet work?
    • The request is sent from the user to the Server
    • The Servlet belonging to this request is determined on the Server. Request and all information is sent to this servlet. 
    • The Servlet receive this information and generates the results it needs to generate. And sends the result to the web server.

Hibernate
	In this project, we realized the relationship with our database by using hibernate. Hibernate is an ORM library develop for java developers. 
  Hibernate provides the relationship with database to the object oriented models, facilitates the operations on database, also strengthens the established structure. 
ORM: The concept called ORM or Object Relational Mapping is actually a bridge between our code blocks and database.

Packages & Layers in Encoding
	
Data Access Object (DAO)

Data Access Object (DAO) design template usage; access to the preferred database reduces the dependency of other layers to the database 
  by further abstracting the data storage and data retrieval process. The classes that simplify JDBC technology used to transaction in the database are found in DAO.

Layers created in the software architecture must have little dependency on each other, and other layers should not be affected if a layer needs to be replaced.
  At this point it gives us many advantages. Depending on this, interdepartmental dependency is achieved through interface classes.

Concept of Interface

The interface class allows us to determine what jobs the class does without the need to define how the methods are implemented. 
  Signature of method is released into the interfaces classes. Classes, after class definition can include interfaces which you wanted to use with implements keyword.

If summarize; 
(Quotation/The Java™ Tutorials)Implementing an interface allows a class to become more formal about the behavior it promises to provide. Interfaces form a contract between the class and the outside world.

Service Package(Service Facade Design Pattern)
	Indicates that a class is a "Service" that is not an encapsulated state, defined as a process that is presented as a stand-alone interface in the model. In other words, the intermediate layer for the specific business logic (Business Service Front). Integrates data from multiple sources.
