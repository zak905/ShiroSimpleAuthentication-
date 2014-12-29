/* This project is done by Zakaria Amine for a Scheduling Manager Application 
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
  */

package com.mymanager.security;

import org.apache.shiro.session.Session;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 *
 * @author zakaria
 */
public class Authenticator {
    
    private static final String AUTHENTICATION_QUERY = "SELECT password FROM users WHERE username=?";
    private static final String ROLES_QUERY = "SELECT access_designation FROM access_level,users WHERE access_level.id=users.access_level_id and users.username = ?" ;
    
    /*** Autenticates a user **/
    public Subject authenticate(String username, String pass) {

		Subject currentUser = null;
		try {
			

			Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
			org.apache.shiro.mgt.SecurityManager securityManager = factory
					.getInstance();
			// the key "jdbcRealm" must be the same in the shiro.ini file.
			JdbcRealm realm = (JdbcRealm) ((IniSecurityManagerFactory) factory)
					.getBeans().get("jdbcRealm");
			realm.setAuthenticationQuery(AUTHENTICATION_QUERY);
			realm.setUserRolesQuery(ROLES_QUERY);
			
			//realm.setPermissionsQuery("SELECT permission FROM role_permission,role WHERE role_permission.roleId=role.roleId AND role.name=?");
			//realm.setPermissionsLookupEnabled(false);
			SecurityUtils.setSecurityManager(securityManager);

			currentUser = SecurityUtils.getSubject();

		
			
				UsernamePasswordToken token = new UsernamePasswordToken(
						username, pass);
				
				currentUser.login(token);
				
				

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentUser;

	}

}
