package com.soldesk.festival.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void getSelect(Search s, HttpServletRequest req) {
		try {
			SearchMapper sm = ss.getMapper(SearchMapper.class);
			List<Search> searchs = sm.searchFestival(s);
			Searchs s2 = new Searchs(searchs);
			req.setAttribute("searchs", s2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void detailView(Search s, HttpServletRequest req){
		req.setAttribute("sr", ss.getMapper(SearchMapper.class).detailView(s));
	}
	
	public Searchs getSelect2(Search s, HttpServletRequest req) {
		try {
			SearchMapper sm = ss.getMapper(SearchMapper.class);
			List<Search> search = sm.searchFestival(s);
			Searchs s2 = new Searchs(search);
			return s2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
