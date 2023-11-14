package com.mkyong.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY )
		private Integer id;
		@Column(name = "username")
		private String emailadmin;
		@Column(name = "password")
		private String password;
		
		public Admin() {
			// TODO Auto-generated constructor stub
		}

		public Admin(Integer id, String emailadmin, String password) {
			super();
			this.id = id;
			this.emailadmin = emailadmin;
			this.password = password;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getEmailadmin() {
			return emailadmin;
		}

		public void setEmailadmin(String emailadmin) {
			this.emailadmin = emailadmin;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
}
