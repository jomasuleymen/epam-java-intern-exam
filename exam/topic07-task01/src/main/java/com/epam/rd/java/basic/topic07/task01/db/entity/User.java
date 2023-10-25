package com.epam.rd.java.basic.topic07.task01.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

	private int id;

	private String login;

	public static User createUser(String login){
		return new User(0, login);
	}

	@Override
	public String toString() {
		return login;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return login.equals(user.login);
	}
}