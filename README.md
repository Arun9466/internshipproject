# internshipproject
My internship Project

# Professional Networking Platform

This repository contains the frontend code for a Professional Networking Platform, built using React.js. The platform facilitates building and expanding professional networks, sharing insights, and managing professional information. The backend is built using Spring Boot and MySQL.


The Professional Networking Platform is designed to help users build and expand their professional networks, share insights, and manage their professional information. The project is divided into two main parts:

- **Frontend**: Developed using React.js
- **Backend**: Developed using Spring Boot and MySQL

## Frontend Setup

### Prerequisites

- Node.js (v12.x or later)
- npm (Node Package Manager) or yarn

### Getting Started

1. **Clone the Repository**

    ```bash
    git clone https://github.com/yourusername/internshipfrontend.git
    cd internshipfrontend
    ```

2. **Install Dependencies**

    Using npm:

    ```bash
    npm install
    ```

    Using yarn:

    ```bash
    yarn install
    ```

3. **Configuration**

    Create a `.env` file in the root directory and add the necessary environment variables. Example:

    ```
    REACT_APP_API_URL=http://localhost:8080/api
    ```

4. **Running the Application**

    Using npm:

    ```bash
    npm start
    ```

    Using yarn:

    ```bash
    yarn start
    ```

    The development server will start at `http://localhost:3000`.

5. **Building the Application**

    Using npm:

    ```bash
    npm run build
    ```

    Using yarn:

    ```bash
    yarn build
    ```

    This will generate the optimized and minified files in the `build` directory.

## Backend Setup

### Prerequisites

- Java 11 or later
- Maven
- MySQL

### Getting Started

1. **Clone the Repository**

    Since you are unable to upload the backend due to its large size, ensure the backend code is available locally.

2. **Create a MySQL Database**

    Create a new MySQL database for the project.

    ```sql
    CREATE DATABASE freshconnect;
    ```

3. **Update Configuration**

    Update the `application.properties` file with your MySQL credentials.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/freshconnect
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

4. **Build and Run the Application**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    The backend will start at `http://localhost:8080`.

## Project Workflow

### User Registration and Authentication

1. **User Registration**: Users can register on the platform by providing their details such as username, email, and password. The registration information is sent to the backend API (`POST /api/auth/register`), which creates a new user in the database.

2. **User Login**: Registered users can log in by providing their credentials. The login information is sent to the backend API (`POST /api/auth/login`), which authenticates the user and returns a JWT token for subsequent authenticated requests.

### User Profile Management

1. **View Profile**: Users can view their profile information. The frontend sends a request to the backend API (`GET /api/users/{id}`) to fetch the user details.
   
2. **Edit Profile**: Users can update their profile information such as name, profile picture, etc. The updated information is sent to the backend API (`PUT /api/users/{id}`).

### Posts and Comments

1. **Create Post**: Authenticated users can create new posts to share insights. The post data is sent to the backend API (`POST /api/posts`), which saves the post in the database.

2. **View Posts**: Users can view all posts. The frontend sends a request to the backend API (`GET /api/posts`) to fetch the list of posts.

3. **View Post Details**: Users can view details of a specific post, including comments. The frontend sends a request to the backend API (`GET /api/posts/{id}`).

4. **Add Comment**: Authenticated users can add comments to posts. The comment data is sent to the backend API (`POST /api/posts/{id}/comments`).

### Database Schema

The MySQL database includes several tables to manage users, roles, posts, and comments. When the Spring Boot application starts, it initializes the database schema based on the entities defined in the application.

### Services and API

The backend exposes RESTful APIs for all the major functionalities such as user authentication, profile management, post creation, and commenting. The APIs follow REST principles and return JSON responses.

### Frontend Integration

The React.js frontend interacts with the backend services using Axios for making HTTP requests. The frontend uses React Router for navigation and state management libraries like Redux for handling the application state.

## Contributing

Contributions are welcome! Please create a pull request and explain your changes.


## Contact

If you have any questions or need further assistance, please contact [arunhegdears@gmail.com] .
