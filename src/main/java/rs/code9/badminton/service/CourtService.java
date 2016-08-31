package rs.code9.badminton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.badminton.model.Court;
import rs.code9.badminton.repository.CourtRepository;

/**
 * Implementation of court service.
 *
 * @see rs.code9.badminton.service.CourtService
 * @author p.stanic
 */
@Service
@Transactional(readOnly=true)
public class CourtService  {

	/**
	 * Court dao.
	 */
	@Autowired
	private CourtRepository courtRepository;

	/**
	 * Retrieves Court based on ID.
	 *
	 * @param id
	 * @return The court with provided ID. 
	 */
	public Court get(Long id) {
		return courtRepository.findOne(id);
	}

	public List<Court> findAll() {
		return courtRepository.findAll();
	}
}
