package org.simplilearn.library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.library.entities.Library;
import org.simplilearn.library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryDeleteServiceImpl implements LibraryDeleteService{
	private LibraryRepository libraryRepository;
	@Autowired
	public LibraryDeleteServiceImpl(LibraryRepository libraryRepository) {
		super();
		this.libraryRepository = libraryRepository;
	}

	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepository.delete(library);
		return "Deleted Library "+library;
	}

	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "Prune Completed";
	}

	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "Delete All Completed";
	}

	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Delete All in Batch is completed";
	}

	@Override
	public String deleteLibraryById(int id) {
		libraryRepository.deleteById(id);
		return "Library with id "+id+" is deleted";
	}

	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteAllInBatch(libraries);
		return "Delete all the libraries in the list in batch mode";
	}

}
