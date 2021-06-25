package com.example.Omnirio.configuration.database;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.boot.model.source.spi.AttributeRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Omnirio.enitity.Category;
import com.example.Omnirio.enitity.Attribute;
import com.example.Omnirio.repositories.AttribueRepository;
import com.example.Omnirio.repositories.CategoryRepository;

@Configuration
public class LoadInMemoryDataBase {

	private static final Logger log = LoggerFactory.getLogger(LoadInMemoryDataBase.class);

	@Bean
	CommandLineRunner initDatabase(CategoryRepository repository,AttribueRepository repository1) {

		return args -> {
			
			Category cat1 = new Category("Shirt");
			
			Category cat2  = new Category("Pant");
			
			
			Set<Attribute> attAet = new HashSet();
			
			Attribute att1= new Attribute("Colour");
			attAet.add(att1);
		    cat1.setCategoryAttribute(attAet);;
			log.info("Preloading " + repository1.save(att1));
			log.info("Preloading " + repository1.save(new Attribute("Size")));
			log.info("Preloading " + repository.save(cat1));
			log.info("Preloading " + repository.save(cat2));
		};
	}
}
