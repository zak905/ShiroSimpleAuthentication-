/* This project is done by Zakaria Amine for a Scheduling Manager Application 
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
  */

package com.mymanager.security;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 *
 * @author zakaria
 */
public class MyDataSource extends BoneCPDataSource {
    /** Data source class for retrieving authentication information **/
    public MyDataSource() {
	super();
	this.setDriverClass("org.sqlite.JDBC");
	this.setJdbcUrl("jdbc:sqlite:mymanagerdb");
	this.setUsername("");
	this.setPassword("");
	this.setDefaultAutoCommit(true);
    }

    /**
     * @param config
     */
    public MyDataSource(BoneCPConfig config) {
	super(config);
    }

}
