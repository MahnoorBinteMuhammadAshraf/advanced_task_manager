package com.advancedtaskmanager.repository;

import com.advancedtaskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, Integer>
{
    List<Task> findByScheduledDate(LocalDate scheduledDate);

    List<Task> findAllByCategory_Id(Integer id);

    @Query(value = "select * from Task where priority != null order by priority", nativeQuery = true)
    List<Task> findAllByPriority();

    @Query(value = "select * from Task where title in (:titles)",nativeQuery = true)
    Set<Task> findAllTaskByTitle(@Param("titles") List<String> titles);
}
