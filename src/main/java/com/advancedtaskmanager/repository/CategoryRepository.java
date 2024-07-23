package com.advancedtaskmanager.repository;

import com.advancedtaskmanager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{
     Optional<Category> findByName(final String name);
}
