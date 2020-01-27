package com.DrvieTracker.pojo;

import java.sql.Date;

public class CreateDrive {

	String companyname;
	int id;
	int resource;
	int exp;
	float ctc;
	int position;
	int joining;
	int education;
	Date followup;
	int bond;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public int getResource() {
		return resource;
	}

	public void setResource(int resource) {
		this.resource = resource;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public float getCtc() {
		return ctc;
	}

	public void setCtc(float ctc) {
		this.ctc = ctc;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getJoining() {
		return joining;
	}

	public void setJoining(int joining) {
		this.joining = joining;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public Date getFollowup() {
		return followup;
	}

	public void setFollowup(Date followup) {
		this.followup = followup;
	}

	public int getBond() {
		return bond;
	}

	public void setBond(int bond) {
		this.bond = bond;
	}

	@Override
	public String toString() {
		return "CreateDrive [companyname=" + companyname + ", id=" + id + ", resource=" + resource + ", exp=" + exp
				+ ", ctc=" + ctc + ", position=" + position + ", joining=" + joining + ", education=" + education
				+ ", followup=" + followup + ", bond=" + bond + "]";
	}

}
