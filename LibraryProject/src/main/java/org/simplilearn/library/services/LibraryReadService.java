package org.simplilearn.library.services;

import java.util.List;
import java.util.Optional;

import org.simplilearn.library.entities.Library;
import org.springframework.data.domain.Page;

public interface LibraryReadService {
	List<Library> getAllLibraries();
	List<Library> getAllLibrariesWithNoBooks();
	Page<Library> getAllLibrary();
	Page<Library> getLibrariesCustomPaged(int pageNumber,int noOfRecordsPerPage);
	List<Library> getLibrariesWithLatestAddedOrder();
	Page<Library> getLibrariesPagedAndSortedByNameWithTheseBooks(String commaSeperatedBookNames);
	Page<Library> getLibrariesCustomPagedandSortedWithDefaultOrderByNameAndWithTheseBooks(int pageNumber,int noOfPages,String commaSeperatedBookNames);
	List<Library> getLibrariesSortedByNameWithTheseBooks(String commaSeperatedBookNames);
	List<Library> getLibrariesByIds(List<Integer> ids);
	Optional<Library> getLibraryById(Integer id);
	Optional<Library> getLibraryWithTheseBooks(String commaSeperatedBookNames);
	
	
}
