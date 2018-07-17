

package com.bit.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.bit.db.BoardManager;
import com.bit.vo.BoardVO;

@Repository
public class BoardDAO {

	public List<BoardVO> listAll() {
		return BoardManager.listAll();
	}

}

