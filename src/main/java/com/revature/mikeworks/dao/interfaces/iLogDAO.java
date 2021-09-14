package com.revature.mikeworks.dao.interfaces;

public interface iLogDAO {
    public void createLogEntry(Long nWho, Integer nWhat, Long nWhere, Long nOther, Double nAmount, String nNotes);
    public void createLogEntry(Long nWho, Integer nWhat, Long nWhere, Long nOther, Double nAmount);
    public void createLogEntry(Long nWho, Integer nWhat, Long nWhere, Double nAmount);
}
