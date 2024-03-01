package me.networkhub.networkhubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class NetworkhubapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(NetworkhubapiApplication.class, args);

	}

}
