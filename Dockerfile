# Use a base image with Java installed
FROM openjdk:21

# Set the working directory
WORKDIR C:/LabaProyects/Block 2/db_course_JavaProject/

# Copy the JAR file into the container
COPY ./target/db_course_JavaProject-1.0-SNAPSHOT.jar /app/


# Expose the port your application is running on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "db_course_JavaProject-1.0-SNAPSHOT.jar"]