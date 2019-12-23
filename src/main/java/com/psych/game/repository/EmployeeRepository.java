package com.psych.game.repository;

import com.psych.game.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long  > {
}
