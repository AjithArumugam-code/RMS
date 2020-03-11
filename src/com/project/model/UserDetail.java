package com.project.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetail implements UserDetails {
	  private static final long serialVersionUID = 1L;

	    private boolean enabled;

	    private boolean accountNonExpired = false;

	    private boolean credentialsNonExpired;

	    private boolean accountNonLocked = false;

	    private String name;

	    private String password;

	    private String userId;

	    private int id;

	    private Map<String,Object> detail = new HashMap<String,Object>();

	    private Collection<? extends GrantedAuthority> authorities;

	    private String currentServiceURI;
	    
	    private String serverName;


	    public UserDetail() {
	        id = 0;
	        name ="";
	        password = "";
	        userId = "";
	    }

	    public UserDetail(int id, String username, String password,
	            String name, boolean enabled,
	            boolean accountNonExpired, boolean credentialsNonExpired,
	            boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
	            throws IllegalArgumentException {
	        this.id = id;
	        this.userId = username;
	        this.name = name;
	        this.password = password;
	        this.enabled = enabled;
	        this.accountNonExpired = accountNonExpired;
	        this.credentialsNonExpired = credentialsNonExpired;
	        this.accountNonLocked = accountNonLocked;
	        this.authorities = authorities;
	    }

	    /**
	     * @return the id
	     */
	    public int getId() {
	        if (id == 0) {
	            id =0 ;
	            
	        }
	        return id;
	    }

	    /**
	     * @param id the id to set
	     */
	    public void setId(int id) {
	        this.id = id;
	    }

	    
	    /**
	     * @return the password
	     */
	    public String getPassword() {
	        return password;
	    }

	    /**
	     * @param password the password to set
	     */
	    public void setPassword(String password) {
	        this.password = password;
	    }

	    /**
	     * @return the userId
	     */
	    public String getUserId() {
	        return userId;
	    }

	    /**
	     * @param userId the userId to set
	     */
	    public void setUserId(String userId) {
	        this.userId = userId;
	    }


	    /**
	     * @param authorities the authorities to set
	     */
	    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	       this.authorities = authorities;
	    }

	    @Override
	    public String getUsername() {
	        // TODO Auto-generated method stub
	        return userId;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        // TODO Auto-generated method stub
	        return accountNonExpired;
	    }
	    /**
		 * @param accountNonExpired the accountNonExpired to set
		 */
		public void setAccountNonExpired(boolean accountNonExpired) {
			this.accountNonExpired = accountNonExpired;
		}



		@Override
	    public boolean isAccountNonLocked() {
	        // TODO Auto-generated method stub
	        return accountNonLocked;
	    }
	    /**
		 * @param accountNonLocked the accountNonLocked to set
		 */
		public void setAccountNonLocked(boolean accountNonLocked) {
			this.accountNonLocked = accountNonLocked;
		}

	    @Override
	    public boolean isCredentialsNonExpired() {
	        // TODO Auto-generated method stub
	        return credentialsNonExpired;
	    }


		/**
		 * @param credentialsNonExpired the credentialsNonExpired to set
		 */
		public void setCredentialsNonExpired(boolean credentialsNonExpired) {
			this.credentialsNonExpired = credentialsNonExpired;
		}
	    @Override
	    public boolean isEnabled() {
	        // TODO Auto-generated method stub
	        return enabled;
	    }
	    /**
		 * @param enabled the enabled to set
		 */
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}


	    /**
	     * @return the currentServiceURI
	     */
	    public String getCurrentServiceURI() {
	        return currentServiceURI;
	    }

	    /**
	     * @param currentServiceURI the currentServiceURI to set
	     */
	    public void setCurrentServiceURI(String currentServiceURI) {
	        this.currentServiceURI = currentServiceURI;
	    }

		/**
	     * @return the currentServiceURI
	     */
//	    public List<GrantedAuthority> getGrantedAuthorities() {
//	        return Arrays.asList(authorities);
//	    }


	    public Object getUserAttribute(String key){
	        return detail.get(key);
	    }

	    public void setUserAttribute(String key,Object value){
	        detail.put(key,value);
	    }

	    /**
	     * @return the detail
	     */
	    public Map<String,Object> getDetail(){
	        return detail;
	    }
	    

		/**
		 * @return the serverName
		 */
		public String getServerName() {
			return serverName;
		}

		/**
		 * @param serverName the serverName to set
		 */
		public void setServerName(String serverName) {
			this.serverName = serverName;
		}

		 @Override
		    public Collection<? extends GrantedAuthority> getAuthorities() {
		        // TODO Auto-generated method stub
		        return authorities;
		    }

	    
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

}
