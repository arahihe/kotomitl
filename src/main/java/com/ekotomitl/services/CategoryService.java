package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.Category;
import com.ekotomitl.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	// GET ALL
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	// GET ONE
	public Optional<Category> findCategoryById(Long id) {
		return categoryRepository.findById(id);
	}
	
	// POST
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	// PUT
	public Category replaceCategory(Category newCategory, Long id) {
		return categoryRepository.findById(id)
			      .map(category -> {
			    	  category.setCategory_name(newCategory.getCategory_name());
			    	  return categoryRepository.save(category);
			      })
			      .orElseGet(() -> {
			    	  return categoryRepository.save(newCategory);
			      });
	}
	
	// DELETE
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}

}
