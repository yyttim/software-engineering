# SpringBoot-based Medical Management System

**Description:**  
This project was initially hosted on Gitee during the early stages of development and debugging for convenience. After the development was completed, all the code has now been migrated to this public GitHub repository to allow more users to use and provide feedback. The program has implemented most of the features and is deployed on an Alibaba Cloud server, accessible online via the IP address. It can also be deployed locally by following the provided tutorial. Further development of the program is ongoing, and feedback submissions are welcome to help us optimize and improve the system.

## Online Access and Login Details
*Note:* The server bandwidth is limited; if the IP loading time is long, please be patient and wait for several seconds.

### IP Address
http://8.130.95.239/

### Domain Name
http://se.yuntianyang.com/

### Test Accounts (initial password: 123456)
- Patient: `2000`  
- Doctor: `1000`  
- Admin: `202401`

## Instructions for Local Deployment

### Database Configuration
#### Database File
`DB_Hospital.sql`

#### Database Username and Password
- Username: `root`  
- Password: `123456`

### Backend Deployment
#### Environment Setup
- Required: JDK, IntelliJ IDEA, Maven, MySQL, Navicat

#### Startup Steps
1. Open IntelliJ IDEA, select "Open" and navigate to the `hospital-backend` project directory.  
2. Configure IntelliJ IDEA with `JDK 1.8` and `Maven`, then refresh and wait for the compilation to complete.  
3. Use Navicat to import the database file `DB_Hospital.sql`.  
4. Configure the database settings in `application.yml`.  
5. Start the SpringBoot backend project.  
6. In `Run/Debug Configurations`, select `Application`.  
7. Under `Build and Run`, ensure `Java 1.8` is selected, and set `com.shanzhu.hospital.BackendApplication` as the main class.

### Frontend Deployment
#### Environment Setup
- Required: Node.js version 16.13.2 or higher (ensure compatibility to avoid compilation issues).

#### Startup Steps
1. Open the `hospital-frontend` directory with IntelliJ IDEA.  
2. In the terminal, execute the following command:  
   ```bash
   npm config set registry https://registry.npmmirror.com
3. Then run:
   npm run dev  
4. Once the startup is complete, it will display the relevant login URL.

## Local Access Address
http://localhost:9282/#/login
