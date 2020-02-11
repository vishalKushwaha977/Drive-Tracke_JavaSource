package com.drive.dao;

public class Constantdb {
	public static String createDrive = "insert into drive(COMPANY_NAME , NO_OF_RSRCS   ,  EXP_REQ   ,  CTC ,  JOIN_CRT    , POSITION  ,  EDU_CRT , FOLLOWUP   ,   BOND ,GST) values(? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
	public static String deleteDrive = "delete from drive where DID=?";
	public static String updateDrive = "update drive set  COMPANY_NAME =? ,    NO_OF_RSRCS=?   ,   EXP_REQ=? ,  CTC=? ,  JOIN_CRT=?    , POSITION=?,  EDU_CRT =?  ,  FOLLOWUP=?  ,   BOND =? , GST = ? where DID=?";
	public static String viewDrive = "select * from drive";
	public static String register = "insert into tpo (TPO_NAME,TPO_EMAIL,TPO_PASSWORD,CREATION_DATE,ROLE) values(?,?,?,?,?)";
	public static String login = "select * from tpo";
}
