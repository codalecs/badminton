package rs.code9.badminton.service;

import java.util.List;

import rs.code9.badminton.model.Court;

/**
 * Service used for working with courts.
 *
 * @author p.stanic
 */
public interface CourtService {

	/**
	 * Retrieves Court based on ID.
	 *
	 * @param id
	 * @return The court with provided ID. 
	 */
	public Court get(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<Court> findAll();
}
