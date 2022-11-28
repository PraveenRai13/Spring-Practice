package org.simplilearn.library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.library.entities.Library;
import org.simplilearn.library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class LibraryCreateServiceImpl implements LibraryCreateService {
	private LibraryRepository libraryRepository;
	@Autowired
	public LibraryCreateServiceImpl(LibraryRepository libraryRepository) {
		super();
		this.libraryRepository = libraryRepository;
	}

	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "Library Added";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "All Libraries Saved";
	}

	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}

}
