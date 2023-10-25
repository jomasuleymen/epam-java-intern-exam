package com.epam.rd.java.basic.topic07.task01.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team {

	private int id;
		
	private String name;

	public static Team createTeam(String name){
		return new Team(0, name);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Team user = (Team) o;
		return name.equals(user.name);
	}

}