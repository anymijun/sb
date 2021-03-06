package com.lottery.model;
// default package

// Generated 2015-9-13 13:41:05 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Systeminfo generated by hbm2java
 */
@Entity
@Table(name = "systeminfo", catalog = "lottery")
public class Systeminfo implements java.io.Serializable {

	private Integer id;
	private String keyWord;
	private String des;
	private String notice;
	private Integer drawTime;
	private Integer betTime;
	private Integer betState;
	private Integer defect;

	public Systeminfo() {
	}

	public Systeminfo(String keyWord, String des, String notice, Integer drawTime, Integer betTime, Integer betState,
			Integer defect) {
		this.keyWord = keyWord;
		this.des = des;
		this.notice = notice;
		this.drawTime = drawTime;
		this.betTime = betTime;
		this.betState = betState;
		this.defect = defect;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "keyWord", length = 512)
	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Column(name = "des", length = 512)
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Column(name = "notice", length = 512)
	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Column(name = "drawTime")
	public Integer getDrawTime() {
		return this.drawTime;
	}

	public void setDrawTime(Integer drawTime) {
		this.drawTime = drawTime;
	}

	@Column(name = "betTime")
	public Integer getBetTime() {
		return this.betTime;
	}

	public void setBetTime(Integer betTime) {
		this.betTime = betTime;
	}

	@Column(name = "betState")
	public Integer getBetState() {
		return this.betState;
	}

	public void setBetState(Integer betState) {
		this.betState = betState;
	}

	@Column(name = "defect")
	public Integer getDefect() {
		return this.defect;
	}

	public void setDefect(Integer defect) {
		this.defect = defect;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
	}
}
