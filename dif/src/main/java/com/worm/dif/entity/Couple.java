/**
 * 
 */
package com.worm.dif.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


/**
 * @author MOATEZ
 *
 */
public class Couple {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String key1;
	private String key2;
	@OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="dif",  
    joinColumns={@JoinColumn(name="couple", referencedColumnName="id")})
	private List<Dif> difs;
	public Couple(String key1, String key2, List<Dif> difs) {
		super();
		this.key1 = key1;
		this.key2 = key2;
		this.difs = difs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public List<Dif> getDifs() {
		return difs;
	}
	public void setDifs(List<Dif> difs) {
		this.difs = difs;
	}
	
}
