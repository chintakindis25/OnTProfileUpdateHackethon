package com.ont.profiles;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class EmpProfile 
{
	/**
	 * for Profile Repository
	 */
	@Id	
	@Column(name="soeid")
	String soeid;
	
	@Column(name="full_name")
	String fullName;

	@Column(name="current_role")
	String currentRole;
	
	@Column(name="self_intro")
	String selfIntro;
	
	@Column(name="current_dept")
	String currentDept;
	
	@Column(name="mastery_on")
	String masteryOn;
	
	@Column(name="other_skills")
	String otherSkills;
	
	@Column(name="upskill_needs")
	String upskillNeeds;
	
	@Column(name="ontacademy_training_certifications")
	List<String> onTAcademyTrainingCertifications;
	
	@Column(name="interested_to_contribute_in")
	String interestedToContributeIn;
	
	@Column(name="other_areas_willing_to_contribute")
	String otherAreasWillingToContribute;
	
	@Column(name="open_to_work")
	String openToWork;
	
	@Column(name="next1to3years")
	String next1to3Years;
	
	public String getSoeid() {
		return soeid;
	}
	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}
	public String getSelfIntro() {
		return selfIntro;
	}
	public void setSelfIntro(String selfIntro) {
		this.selfIntro = selfIntro;
	}
	public String getCurrentDept() {
		return currentDept;
	}
	public void setCurrentDept(String currentDept) {
		this.currentDept = currentDept;
	}
	public String getMasteryOn() {
		return masteryOn;
	}
	public void setMasteryOn(String masteryOn) {
		this.masteryOn = masteryOn;
	}
	public String getOtherSkills() {
		return otherSkills;
	}
	public void setOtherSkills(String otherSkills) {
		this.otherSkills = otherSkills;
	}
	public String getUpskillNeeds() {
		return upskillNeeds;
	}
	public void setUpskillNeeds(String upskillNeeds) {
		this.upskillNeeds = upskillNeeds;
	}
	
	public List<String> getOnTAcademyTrainingCertifications() {
		return onTAcademyTrainingCertifications;
	}
	public void setOnTAcademyTrainingCertifications(List<String> onTAcademyTrainingCertifications) {
		this.onTAcademyTrainingCertifications = onTAcademyTrainingCertifications;
	}
	public String getInterestedToContributeIn() {
		return interestedToContributeIn;
	}
	public void setInterestedToContributeIn(String interestedToContributeIn) {
		this.interestedToContributeIn = interestedToContributeIn;
	}
	public String getOtherAreasWillingToContribute() {
		return otherAreasWillingToContribute;
	}
	public void setOtherAreasWillingToContribute(String otherAreasWillingToContribute) {
		this.otherAreasWillingToContribute = otherAreasWillingToContribute;
	}
	public String getOpenToWork() {
		return openToWork;
	}
	public void setOpenToWork(String openToWork) {
		this.openToWork = openToWork;
	}
	public String getNext1to3Years() {
		return next1to3Years;
	}
	public void setNext1to3Years(String next1to3Years) {
		this.next1to3Years = next1to3Years;
	}
	
	public EmpProfile() {
		super();
	}
	public EmpProfile(EmpProfile empProfile) {
		// TODO Auto-generated constructor stub
		this.soeid = empProfile.getSoeid();
		this.fullName = empProfile.getFullName();
		this.currentDept = empProfile.getCurrentDept();
		this.currentRole = empProfile.getCurrentRole();
		this.interestedToContributeIn = empProfile.getInterestedToContributeIn();
		this.masteryOn = empProfile.getMasteryOn();
		this.next1to3Years = empProfile.getNext1to3Years();
		this.onTAcademyTrainingCertifications = empProfile.getOnTAcademyTrainingCertifications();
		this.openToWork = empProfile.getOpenToWork();
		this.otherAreasWillingToContribute = empProfile.getOtherAreasWillingToContribute();
		this.otherSkills = empProfile.getOtherSkills();
		this.selfIntro = empProfile.getSelfIntro();
		this.upskillNeeds= empProfile.getUpskillNeeds();
	}
	
	@Override
	public String toString() {
		return "EmpProfile ["
				+ "soeid=" + soeid + ", fullName=" + fullName + ", currentRole="
				+ currentRole + ", selfIntro=" + selfIntro + ", currentDept=" + currentDept + ", masteryOn=" + masteryOn
				+ ", otherSkills=" + otherSkills + ", upskillNeeds=" + upskillNeeds
				+ ", onTAcademyTrainingCertifications=" + onTAcademyTrainingCertifications
				+ ", interestedToContributeIn=" + interestedToContributeIn + ", otherAreasWillingToContribute="
				+ otherAreasWillingToContribute + ", openToWork=" + openToWork + ", next1to3Years=" + next1to3Years
				+ "]";
	}
}
