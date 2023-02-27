package com.coriolis.demo.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		  info = @Info(
		  title = "Student Registration API Docs",
		  description = "" +
		    "Student Course registration application",
		  contact = @Contact(
		    name = "KEDAR", 
		    url = "", 
		    email = ""
		  ),
		  license = @License(
		    name = "", 
		    url = "")),
		  servers = @Server(url = "http://localhost:8020")
		)
		class OpenAPIConfiguration {
		}
