/**
 * 
 */
package com.worm.dif.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 * @author MOATEZ
 *
 */
public class Dif {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	private int score;
	public Dif() {
		super();
	}
	public Dif(String content, int score, Couple couple) {
		super();
		this.content = content;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}
