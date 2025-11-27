package com.first_mini_project.dataloder;


import com.first_mini_project.entity.CitizenPlane;
import com.first_mini_project.repo.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {

    @Autowired
    private CitizenRepo repo;

    @Bean
    public ApplicationRunner loadData() {
        return args -> {

            System.out.println("----- Data Loader Started -----");

            // Delete Old Records
            repo.deleteAll();

            // Create 15 sample objects
            List<CitizenPlane> plans = Arrays.asList(

                    new CitizenPlane(null, "Ravi Kumar", "M", "food", "approved",
                            Date.valueOf("2024-01-10"), Date.valueOf("2024-12-10"), "3500", null),

                    new CitizenPlane(null, "Sneha Reddy", "F", "travel", "denied",
                            Date.valueOf("2024-02-05"), Date.valueOf("2024-08-05"), null, "Docs Missing"),

                    new CitizenPlane(null, "Manoj Sharma", "M", "health", "approved",
                            Date.valueOf("2024-03-01"), Date.valueOf("2024-12-01"), "8200", null),

                    new CitizenPlane(null, "Priya Singh", "F", "food", "denied",
                            Date.valueOf("2024-01-15"), Date.valueOf("2024-05-15"), null, "Low Income"),

                    new CitizenPlane(null, "Arun Kumar", "M", "travel", "approved",
                            Date.valueOf("2024-02-20"), Date.valueOf("2024-11-20"), "5000", null),

                    new CitizenPlane(null, "Deepa Varma", "F", "health", "approved",
                            Date.valueOf("2024-04-10"), Date.valueOf("2024-12-10"), "9200", null),

                    new CitizenPlane(null, "Suresh Das", "M", "food", "denied",
                            Date.valueOf("2024-03-05"), Date.valueOf("2024-09-05"), null, "Form Error"),

                    new CitizenPlane(null, "Anita Rao", "F", "travel", "approved",
                            Date.valueOf("2024-01-22"), Date.valueOf("2024-12-22"), "6100", null),

                    new CitizenPlane(null, "Harish Patel", "M", "health", "denied",
                            Date.valueOf("2024-04-15"), Date.valueOf("2024-10-15"), null, "Not Eligible"),

                    new CitizenPlane(null, "Kavya Nair", "F", "food", "approved",
                            Date.valueOf("2024-02-01"), Date.valueOf("2024-08-01"), "2700", null),

                    new CitizenPlane(null, "Rohit Mehta", "M", "travel", "approved",
                            Date.valueOf("2024-05-10"), Date.valueOf("2024-12-10"), "7800", null),

                    new CitizenPlane(null, "Lakshmi Devi", "F", "health", "denied",
                            Date.valueOf("2024-03-02"), Date.valueOf("2024-07-02"), null, "Invalid Proof"),

                    new CitizenPlane(null, "Vijay Anand", "M", "food", "approved",
                            Date.valueOf("2024-06-05"), Date.valueOf("2024-12-05"), "4500", null),

                    new CitizenPlane(null, "Neha Kapoor", "F", "travel", "denied",
                            Date.valueOf("2024-02-17"), Date.valueOf("2024-09-17"), null, "Late Submission"),

                    new CitizenPlane(null, "Amit Jha", "M", "health", "approved",
                            Date.valueOf("2024-01-30"), Date.valueOf("2024-12-30"), "10000", null)
            );

            // Save All
            repo.saveAll(plans);

            System.out.println("----- Data Loaded Successfully -----");
        };
    }
}
