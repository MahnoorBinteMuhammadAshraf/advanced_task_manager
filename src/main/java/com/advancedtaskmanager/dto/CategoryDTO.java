package com.advancedtaskmanager.dto;

import com.advancedtaskmanager.entity.Task;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class CategoryDTO {
    String name;
    List<String> tasks;
}