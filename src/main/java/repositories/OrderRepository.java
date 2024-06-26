package repositories;


import com.example.securityl.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

    @Query("SELECT o FROM Order o WHERE o.active = true " +
            "AND (:keyword IS NULL OR :keyword = '' OR " +
            "o.fullName LIKE %:keyword% " +
            "OR o.address LIKE %:keyword% " +
            "OR o.notes LIKE %:keyword% " +
            "OR o.email LIKE %:keyword%) " +
            "AND (:paymentStatusId IS NULL OR o.paymentStatus.id = :paymentStatusId)")
    Page<Order> findByKeyword(
            @Param("keyword") String keyword,
            @Param("paymentStatusId") Long paymentStatusId,
            Pageable pageable);

    @Query("SELECT COUNT(o) FROM Order o")
    long countTotalOrders();

    @Query("SELECT COUNT(o) FROM Order o " +
            "WHERE FUNCTION('YEAR', o.orderDate) = FUNCTION('YEAR', CURRENT_DATE) " +
            "AND FUNCTION('MONTH', o.orderDate) = FUNCTION('MONTH', CURRENT_DATE)")
    long countOrdersThisMonth();

    @Query("SELECT COUNT(o) FROM Order o " +
            "WHERE FUNCTION('YEAR', o.orderDate) = FUNCTION('YEAR', CURRENT_DATE) " +
            "AND FUNCTION('MONTH', o.orderDate) = FUNCTION('MONTH', CURRENT_DATE) - 1")
    long countOrdersLastMonth();

    default double calculateOrderChange() {
        long currentMonthCount = countOrdersThisMonth();
        long lastMonthCount = countOrdersLastMonth();

        if (lastMonthCount == 0) {
            return 0; // To avoid division by zero
        }

        double percentageChange = ((double) (currentMonthCount - lastMonthCount) / lastMonthCount) * 100;
        return percentageChange;
    }

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE MONTH(o.orderDate) = MONTH(CURRENT_DATE())")
    Double findTotalRevenueCurrentMonth();

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE MONTH(o.orderDate) = MONTH(CURRENT_DATE()) - 1")
    Double findTotalRevenueLastMonth();

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.orderDate = CURRENT_DATE")
    Double getTotalAmountToday();









}
