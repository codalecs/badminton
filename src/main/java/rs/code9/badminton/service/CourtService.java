package rs.code9.badminton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.badminton.model.Court;
import rs.code9.badminton.repository.CourtJpaRepository;

/**
 * Implementation of court service.
 *
 * @see rs.code9.badminton.service.CourtService
 * @author p.stanic
 */
@Service
@Transactional(readOnly = true)
public class CourtService {

	/**
	 * Court dao.
	 */
	@Autowired
	private CourtJpaRepository courtRepository;

	/**
	 * Retrieves Court based on ID.
	 *
	 * @param id
	 * @return The court with provided ID.
	 */
	public Court get(Long id) {
		return courtRepository.findOne(id);
	}

	@Cacheable(cacheNames = "courts")
	public List<Court> findAll() {
		return courtRepository.findAll();
	}

	@CachePut(cacheNames = "courts")
	public Court create(Court court) {
		return courtRepository.saveAndFlush(court);
	}
}
