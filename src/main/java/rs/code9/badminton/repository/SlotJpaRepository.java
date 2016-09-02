package rs.code9.badminton.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.code9.badminton.model.Slot;

/**
 * Repository interface for Slots.
 *
 * @author p.stanic
 */
@Repository
public interface SlotJpaRepository extends JpaRepository<Slot, Long> {
	/**
	 * Returns <code>List</code> of reserved slots for a given court.
	 *
	 * @param courtId Court id for which the slots are retrieved.
	 * @param startDate Start date from which the slots are retrieved.
	 * @param endDate End date for which are slots retrieved.
	 * @return <code>List</code> of reserved slots for a given court (can be empty).
	 */
	@Query("select s from Slot s where s.court.id = :courtId and s.start between :startDate and :endDate")
	public List<Slot> findByCourt(@Param("courtId") Long courtId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	

	/**
	 * Returns <code>List</code> of reserved slots for a given user.
	 *
	 * @param user User for whom the slots are retrieved.
	 * @return <code>List</code> of reserved slots for a given user (can be empty).
	 */
	@Query("select s from Slot s where s.user.id = :userId and s.start between :startDate and :endDate")
	public List<Slot> findByUserIdAndDate(@Param("userId") Long userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
