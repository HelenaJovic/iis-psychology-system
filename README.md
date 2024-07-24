## Psychological Clinic Application

Welcome to the Psychological Clinic Application! This repository contains the source code for a comprehensive application designed to manage various aspects of a psychological clinic. The application is divided into four main subsystems:

1. **Sessions Management**
2. **Workshops Management**
3. **Fairs Organization**
4. **Internships Management**

## Technologies Used

### Backend
- **Java Spring Boot:** We utilized Spring Boot to develop the backend services, providing a robust and scalable architecture.
- **Graph Database (Neo4j):** Used for managing and analyzing internship data.
- **Columnar Database (Cassandra):** Employed for the analytical processing of workshop data.
- **Relational Database (PostgreSQL):** Used for managing relational data, particularly within the workshops subsystem.

### Frontend https://github.com/HelenaJovic/iis-frontend
- **Angular:** The frontend of the application is built using Angular, offering a dynamic and responsive user interface.

## Subsystems

### 1. Sessions Management
This subsystem handles the scheduling, tracking, and management of individual and group therapy sessions. Features include:
- Booking and rescheduling sessions
- Session reminders
- Session history and notes

### 2. Workshops Management
This subsystem manages the creation, scheduling, and analysis of various workshops. Features include:
- Workshop creation and management
- Participant registration and feedback collection
- Analytical reports on workshop effectiveness using Cassandra
- Management of relational data using PostgreSQL
- Integrated tests for participants to evaluate their learning and progress

### 3. Fairs Organization
This subsystem is responsible for organizing fairs and related events. Features include:
- Event scheduling and management
- Participant and exhibitor registration
- Real-time updates and notifications

### 4. Internships Management
This subsystem handles the management and analysis of internships offered through the clinic. Features include:
- Internship postings and applications
- Tracking intern progress and performance
- Data analysis using Neo4j for better insights and connections

## Installation

### Prerequisites
- Java 11 or higher
- Node.js and npm
- Angular CLI
- Neo4j
- Cassandra
- PostgreSQL

### Backend Setup
1. Clone the repository: 
   ```bash
   git clone https://github.com/your-repository-url.git
   ```
2. Navigate to the backend directory:
   ```bash
   cd backend
   ```
3. Install dependencies and build the project:
   ```bash
   mvn clean install
   ```
4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Run the Angular application:
   ```bash
   ng serve
   ```

## Configuration

### Database Configuration
Ensure that your Neo4j, Cassandra, and PostgreSQL databases are properly configured. Update the application.properties file in the backend directory with your database credentials and connection details.

### Environment Variables
Set up necessary environment variables for both backend and frontend configurations as required.

## Usage

Once the application is up and running, you can access the different subsystems through the web interface. Each subsystem has dedicated views and functionalities tailored to specific roles within the clinic (e.g., administrators, therapists, participants).

## Contribution

We welcome contributions to improve this project. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes and push them to your forked repository.
4. Submit a pull request with a detailed description of your changes.
