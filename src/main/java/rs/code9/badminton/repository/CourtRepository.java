package rs.code9.badminton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.code9.badminton.model.Court;

/**
 * Repository interface for Courts.
 *
 * @author p.stanic
 */
@Repository
public interface CourtRepository extends JpaRepository <Court, Long> {
}
