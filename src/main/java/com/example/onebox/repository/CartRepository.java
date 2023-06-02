package com.example.onebox.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.onebox.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	Optional<Cart> findByUuid(String uuid);
	
	@Query("SELECT c FROM Cart c JOIN FETCH c.products WHERE c.uuid = :uuid")
    Optional<Cart> findByIdWithProducts(@Param("uuid") String uuid);
	
	@Query("SELECT c FROM Cart c WHERE c.lastActiveTime < :tenMinutesAgo")
	List<Cart> findByLastActiveTimeBefore(@Param("tenMinutesAgo") LocalDateTime tenMinutesAgo);
}
