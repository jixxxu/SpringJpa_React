package su.boot.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import su.boot.react.entity.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer>{

}
