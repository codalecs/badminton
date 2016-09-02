package rs.code9.badminton.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.code9.badminton.model.Court;
import rs.code9.badminton.model.Court.SurfaceType;

/**
 * Repository interface for Courts.
 *
 * @author p.stanic
 */
@Repository
public interface CourtJpaRepository extends JpaRepository <Court, Long> {
	
	public Page<Court> findAll(Pageable page);
	
	public List<Court> findByNameAndSurfaceType(String name, SurfaceType surfaceType);
}
