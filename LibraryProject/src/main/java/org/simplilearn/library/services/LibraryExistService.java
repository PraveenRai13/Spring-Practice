package org.simplilearn.library.services;

public interface LibraryExistService {
	boolean checkLibraryExistsById(int id);
	boolean checkLibraryExistsByExample(String commaSeperatedBookNames);
}
