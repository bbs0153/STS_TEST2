package com.bit.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.MemberManager;

@Repository
public class MemberDao {

	public int isMember(Map map) {
		return MemberManager.isMember(map);
	}
}
