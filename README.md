# HfT-PVL-WS24

# Distributed Application Developement

In this lab, you will design and implement a modular shopping list application using Spring Boot and Thymeleaf. The application will follow the core principles of distributed systems and cloud-native development, ensuring that proper external configuration and the 12-factor methodology are applied.

# General Requirements

##	Application Setup
	Frameworks used: Spring Boot for backend, Thymeleaf for server-side rendering in the frontend.
	The application implements the provided REST_API.json specifications, focusing on backend functionality exposed through RESTful APIs.

##	Configuration and 12-Factor Compliance
	**Externalized Configuration:** All configurations (e.g., database URLs, backend API URLs) are externalized and stored in the application.properties file or environment variables (for Docker and Kubernetes).

	** 12-Factor Principles: ** The application adheres to 12-factor app methodology. Here’s how the principles are applied:
	- Codebase: The frontend and backend are part of a single codebase managed in a Git repository.
	- Dependencies: Dependencies are explicitly declared in the pom.xml files (Maven) for each module.
	- Config: All environment-specific configuration is externalized.
	- Backing Services: The backend is treated as a service, connected to a shared Docker network.
	- Build, Release, Run: Separation of build and runtime environments is ensured via Docker.
	- Processes: The frontend and backend are stateless and only manage data externally (e.g., via in-memory cache).
	- Concurrency: Multiple instances of frontend and backend services can be run via Docker Compose or Kubernetes.
	- Disposability: The application starts quickly and can be stopped and restarted gracefully using Docker containers.
	- Dev/Prod Parity: The application ensures consistency across local, staging, and production environments via Docker.
	- Logs: Application logs are output to the console and aggregated by Docker.
	- Admin Processes: Administrative tasks (e.g., database migration) can be handled using Spring Boot CLI or separate containers.

    ** Containerization: **
	Docker: A Dockerfile has been written for frontend and backend to containerize the application.
	Docker Compose: A docker-compose.yml file is set up to define and run multi-container Docker applications, ensuring the frontend and backend services can communicate.
	Kubernetes: Kubernetes manifests (deployment files) have been created for deployment in a Kubernetes environment.


## Frontend
    **Frontend Selection**
    The frontend is built using Thymeleaf, a templating engine that works seamlessly with Spring Boot for server-side rendering (SSR).

    **External Communication**
    The frontend communicates with the backend through Thymeleaf templates. Data from the backend is passed directly to the HTML templates during the rendering process. No client-side HTTP requests (e.g., using Axios) are necessary in this setup, as the backend is responsible for providing all the data that is rendered on the frontend.

    **Status Code Handling**
    The frontend handles HTTP status codes by rendering appropriate views for successful and unsuccessful requests. For example, if the backend responds with an error, the frontend will display an error page.


## How to Build, Containerize, and Test the Application

    1.	Build the Application
        - Use mvn clean package to build the backend.
    2.	Dockerize the Application
        - Build Docker images for both the backend and frontend using their respective Dockerfiles.
        - Use the following command to build the images: "docker-compose build"
    3.	Run with Docker Compose
        - Once the images are built, you can run the application using Docker Compose: "docker-compose up"
        - This will start the app on port 8080.
    4.	Testing the Application
        - After the application is running, access the frontend at http://localhost:8080/.
        - The shopping list interface should allow adding, updating, deleting, and searching items. The frontend is directly connected to the backend, which serves data via Thymeleaf templates.
        - The list of saved items is avalible on http://localhost:8080/api/items
