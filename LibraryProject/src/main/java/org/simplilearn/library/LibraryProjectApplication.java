package org.simplilearn.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import org.simplilearn.library.entities.Library;
import org.simplilearn.library.repositories.LibraryRepository;
import org.simplilearn.library.services.LibraryCountService;
import org.simplilearn.library.services.LibraryCreateService;
import org.simplilearn.library.services.LibraryDeleteService;
import org.simplilearn.library.services.LibraryExistService;
import org.simplilearn.library.services.LibraryExistsServiceImpl;
import org.simplilearn.library.services.LibraryReadService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LibraryProjectApplication{
	//private Logger logger=(Logger) LoggerFactory.getLogger(LibraryProjectApplication.class);
	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private LibraryDeleteService libraryDeleteService;
	@Autowired
	private LibraryCountService libraryCountService;
	@Autowired
	private LibraryCreateService libraryCreateService;
	@Autowired
	private LibraryExistService libraryExistService;
	@Autowired
	private LibraryReadService libraryReadService;
	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner()
	{
		CommandLineRunner runner=new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				initializeLibries();
				//existsServiceImplMethodsExecutor();
				//countServiceImplMethodsExecutor();
				//createServiceImplMethodsExecutor();
				readServiceImplMethodsExecutor();
				//readServiceImplMethodsExecutor();
			}
		};
		return runner;
	}
	private void initializeLibries()
	{
		Library l1=new Library();
		l1.setName("technology library");
		l1.setCommaSeperatedBookNames("learn java,laearn sacala,learn aws");
		libraryRepository.save(l1);
		Library l2=new Library();
		l2.setName("Space library");
		l2.setCommaSeperatedBookNames("Mars Red Planet,Tatan with Water");
		libraryRepository.save(l2);
		Library l3=new Library();
		l3.setName("animal library");
		l3.setCommaSeperatedBookNames("");
		libraryRepository.save(l3);
		Library l4=new Library();
		l4.setName("cloud library");
		l4.setCommaSeperatedBookNames("");
		libraryRepository.save(l4);
		Library l5=new Library();
		l5.setName("dogs library");
		l5.setCommaSeperatedBookNames("Lob Reader,Sheppard");
		libraryRepository.save(l5);
		Library l6=new Library();
		l6.setName("star library");
		l6.setCommaSeperatedBookNames("Yellow Sun,Red Sun,Red Start");
		libraryRepository.save(l6);
	}
	private void existsServiceImplMethodsExecutor()
	{
		log.info("Check if the library exists By Example->{}", libraryExistService.checkLibraryExistsByExample("Mars Red Planet,Tatan with Water"));
		log.info("Check if the library exists By id->{}", libraryExistService.checkLibraryExistsById(1));
	}
	private void countServiceImplMethodsExecutor()
	{
		log.info("count number of libraries with zero books->{}", libraryCountService.countLibrariesWithZeroBooks());
		log.info("counting number of libraries->{}", libraryCountService.countLibraries());
	}
	private void createServiceImplMethodsExecutor()
	{
		log.info("persist single library->{}", 
				libraryCreateService.addSingleLibrary(
						Library.builder().name("E-library")
				.commaSeperatedBookNames("java,.net,php").build()));
		List<Library> libraries=new ArrayList<>();
		libraries.add(Library.builder().name("A-Library")
				.commaSeperatedBookNames("xyz,'znc").build());
		libraries.add(Library.builder().name("B-Library")
				.commaSeperatedBookNames("xyz,'znc").build());
		log.info("Persist all libraries->{}",libraryCreateService.addAllLibraries(libraries));
	}
	private void readServiceImplMethodsExecutor()
	{
		log.info("Fetch all libraries->{}",libraryReadService.getAllLibraries());
		log.info("Fetch all libraries in page Format->{}",
				libraryReadService.getLibrariesCustomPaged(0, 2)
				.get().collect(Collectors.toList()));
		log.info("fetch records with latest added order->{}",libraryReadService.getLibrariesWithLatestAddedOrder());
	}
	

}
