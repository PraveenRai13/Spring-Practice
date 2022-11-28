package org.simplilearn.library.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.simplilearn.library.entities.Library;
import org.simplilearn.library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryReadServiceImpl implements LibraryReadService{
	private LibraryRepository libraryRepository;
	@Autowired
	public LibraryReadServiceImpl(LibraryRepository libraryRepository) {
		super();
		this.libraryRepository = libraryRepository;
	}
	@Override
	public List<Library> getAllLibraries() {
		return libraryRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library library=new Library();
		library.setCommaSeperatedBookNames("");
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.findAll(example);
	}

	@Override
	public Page<Library> getAllLibrary() {
		Pageable pageable=PageRequest.of(0, 3);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int noOfRecordsPerPage) {
		Pageable pageable=PageRequest.of(pageNumber,noOfRecordsPerPage);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return libraryRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		Pageable pageable=PageRequest.of(0, 3, Sort.by("name"));
		return libraryRepository.findAll(example, pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomPagedandSortedWithDefaultOrderByNameAndWithTheseBooks(int pageNumber,
			int noOfPages, String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		Pageable pageable=PageRequest.of(pageNumber, noOfPages, Sort.by("name"));
		return libraryRepository.findAll(example, pageable);
	}

	@Override
	public List<Library> getLibrariesSortedByNameWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.findAll(example, Sort.by("name"));
	}

	@Override
	public List<Library> getLibrariesByIds(List<Integer> ids) {
		return libraryRepository.findAllById(ids);
	}

	@Override
	public Optional<Library> getLibraryById(Integer id) {
		
		return libraryRepository.findById(id);
	}

	@Override
	public Optional<Library> getLibraryWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.findOne(example);
	}

}
