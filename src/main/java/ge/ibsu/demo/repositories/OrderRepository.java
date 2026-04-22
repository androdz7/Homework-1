package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.OrderStatus;
import ge.ibsu.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE " +
            "LOWER(o.customerName) LIKE LOWER(CONCAT('%', :customerName, '%')) " +
            "AND o.status = :status " +
            "ORDER BY o.createdAt DESC")
    List<Order> searchOrders(@Param("customerName") String customerName, @Param("status") OrderStatus status);
}