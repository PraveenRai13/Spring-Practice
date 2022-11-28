package org.simplilearn.library.services;

import org.simplilearn.library.entities.Library;
import org.simplilearn.library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

@Service
public class LibraryExistsServiceImpl implements LibraryExistService{
	private LibraryRepository libraryRepository;
	@Autowired
	public LibraryExistsServiceImpl(LibraryRepository libraryRepository) {
		super();
		this.libraryRepository = libraryRepository;
	}

	@Override
	public boolean checkLibraryExistsById(int id) {
		return libraryRepository.existsById(id);
	}

	@Override
	public boolean checkLibraryExistsByExample(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames",GenericPropertyMatchers.exact())
				.withIgnorePaths("name","id");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.exists(example);
	}

}
