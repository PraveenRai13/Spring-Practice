package org.simplilearn.library.services;

import javax.transaction.Transactional;

import org.simplilearn.library.entities.Library;
import org.simplilearn.library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryCountServiceImpl implements LibraryCountService{
	private LibraryRepository libraryRepository;
	@Autowired
	public LibraryCountServiceImpl(LibraryRepository libraryRepository) {
		super();
		this.libraryRepository = libraryRepository;
	}

	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}
	@Override
	public long countLibrariesWithZeroBooks() {
		Library library=new Library();
		library.setCommaSeperatedBookNames("");
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library,matcher);
		return libraryRepository.count(example);
	}

}
