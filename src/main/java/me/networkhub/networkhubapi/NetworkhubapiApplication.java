package me.networkhub.networkhubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

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

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.mariadb.jdbc.Driver");
		SpringApplication.run(NetworkhubapiApplication.class, args);
	}

}
