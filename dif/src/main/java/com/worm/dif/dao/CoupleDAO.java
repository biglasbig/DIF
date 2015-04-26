/**
 * 
 */
package com.worm.dif.dao;

import com.worm.dif.entity.Couple;

/**
 * @author MOATEZ
 *
 */
public interface CoupleDAO {

	public void insert(Couple couple);
	public Couple findByKeys(String key1, String key2);
}
