package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.DepartmentInfoDTO;
import ge.ibsu.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT new ge.ibsu.demo.dto.DepartmentInfoDTO(" +
            "d.name, m.firstName, m.lastName, c.name, l.city, l.streetAddress) " +
            "FROM Department d " +
            "LEFT JOIN d.manager m " +
            "JOIN d.location l " +
            "JOIN l.country c " +
            "WHERE (:countryName IS NULL OR c.name LIKE %:countryName%) " +
            "AND (:cityName IS NULL OR l.city LIKE %:cityName%)")
    List<DepartmentInfoDTO> searchDepartments(@Param("countryName") String countryName,
                                              @Param("cityName") String cityName);

    @Query("SELECT d FROM Department d JOIN FETCH d.employees")
    List<Department> findAllWithEmployees();
}