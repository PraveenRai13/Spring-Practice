package org.simplilearn.library.services;

import java.util.List;

import org.simplilearn.library.entities.Library;

public interface LibraryDeleteService {
	String deleteOneLibrary(Library library);
	String pruneTable();
	String deleteAllThese(List<Library> libraries);
	String deleteAllInBatch();
	String deleteLibraryById(int id);
	String deleteAllTheseInBatch(List<Library> libraries);
}
