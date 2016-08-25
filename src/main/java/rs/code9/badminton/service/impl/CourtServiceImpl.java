package rs.code9.badminton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.badminton.model.Court;
import rs.code9.badminton.repository.CourtRepository;
import rs.code9.badminton.service.CourtService;

/**
 * Implementation of court service.
 *
 * @see rs.code9.badminton.service.CourtService
 * @author p.stanic
 */
@Service
@Transactional(readOnly=true)
public final class CourtServiceImpl implements CourtService {

	/**
	 * Court dao.
	 */
	@Autowired
	private CourtRepository courtRepository;

	/**
	 * @see rs.code9.badminton.service.CourtService#get(java.lang.Long)
	 */
	public Court get(Long id) {
		return courtRepository.findOne(id);
	}

	public List<Court> findAll() {
		return courtRepository.findAll();
	}
}
