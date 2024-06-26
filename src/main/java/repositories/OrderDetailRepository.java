package repositories;


import com.example.securityl.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrdersId(Long orderId);
    @Query("SELECT od.orders.orderDate AS orderDate, SUM(od.totalAmount) AS totalAmount " +
            "FROM OrderDetail od " +
            "GROUP BY od.orders.orderDate")
    List<Object[]> getTotalAmountSoldByDate();

    @Query("SELECT od.product, SUM(od.quantity) AS totalSold, od.orders.orderDate AS date " +
            "FROM OrderDetail od " +
            "GROUP BY od.product, od.orders.orderDate " +
            "ORDER BY totalSold DESC")
    List<Object[]> findMostSoldProductsByDate();

    @Query("SELECT od.product, SUM(od.quantity) AS totalQuantitySold, SUM(od.orders.totalAmount) AS totalAmountSold " +
            "FROM OrderDetail od " +
            "GROUP BY od.product " +
            "ORDER BY totalQuantitySold DESC")
    List<Object[]> findTop5BestSellingProducts();


    @Query("SELECT COUNT(od) FROM OrderDetail od WHERE od.product.id = :productId")
    Integer countOrderByProductId(@Param("productId") Long productId);

    @Query("SELECT SUM(o.totalAmount) FROM Order o JOIN o.orderDetails od WHERE od.product.id = :productId")
    Optional<Double> findTotalRevenueByProductId(@Param("productId") Long productId);
}
