package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.GoodsDTO;
import com.dto.GoodsPageDTO;
import com.dto.MemberDTO;
import com.dto.MyPageBoardPageDTO;
import com.dto.OrderInfoDTO;
import com.dto.OrderInfoPageDTO;
import com.dto.SalesStatusDTO;
import com.sun.javafx.collections.MappingChange.Map;

public class MyPageDAO {
	// ...("com.mybatis.OrderMapper.orderDone",para)...

	public MemberDTO myPageUserInfo(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.mybatis.MyPageMapper.mypageuserinfo", userid);
		return dto;
	}

	public int updateuserinfo(SqlSession session, MemberDTO updto) {
		int n = session.update("com.mybatis.MyPageMapper.updateuserinfo", updto);
		return n;
	}

	public List<BoardDTO> myPageBoardList(SqlSession session, String userid) {
		List<BoardDTO> bdto = session.selectList("com.mybatis.MyPageMapper.myPageBoardList", userid);
		return bdto;
	}

	public BoardDTO myPageBoardRetrieve(SqlSession session, int bnum) {
		BoardDTO bdto = session.selectOne("com.mybatis.MyPageMapper.myPageBoardRetrieve", bnum);
		return bdto;
	}

	public MyPageBoardPageDTO boardpage(SqlSession session, HashMap<String, String> map, int curPage) {
		// TODO Auto-generated method stub

		MyPageBoardPageDTO pagedto = new MyPageBoardPageDTO();

		int sIndex = (curPage - 1) * MyPageBoardPageDTO.getPerPage();
		int length = MyPageBoardPageDTO.getPerPage();

		List<BoardDTO> list = session.selectList("com.mybatis.MyPageMapper.myPageBoardsearch", map,
				new RowBounds(sIndex, length));
		System.out.println(list + "dao list");
		System.out.println(pagedto.getBlist());
		// pagedto에 저장하기
		int totalPage = 0;
		pagedto.setBlist(list);
		pagedto.setCurPage(curPage);
		if (map.get("searchValue") == null) {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.totalPage", map.get("userId"));
		} else {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.searchPage", map);
		}

		pagedto.setTotalPage(totalPage);
		pagedto.setSearchName(map.get("searchName"));
		pagedto.setSearchValue(map.get("searchValue"));

		return pagedto;
	}

	public int myPageboardupdate(SqlSession session, HashMap<String, Object> map) {
		int n = session.update("myPageboardupdate", map);
		return n;
	}

	public List<OrderInfoDTO> myPageOrderInfo(SqlSession session, String userid) {
		List<OrderInfoDTO> orderdto = session.selectList("myPageOrderInfo", userid);
		return orderdto;
	}

	public OrderInfoDTO orderinforetrieve(SqlSession session, int num) {
		OrderInfoDTO orderdto = session.selectOne("orderinforetrieve", num);
		return orderdto;
	}

	public OrderInfoPageDTO myPageOrderInfoPage(SqlSession session, HashMap<String, String> map, int curPage) {
		// TODO Auto-generated method stub

		OrderInfoPageDTO pagedto = new OrderInfoPageDTO();

		int sIndex = (curPage - 1) * OrderInfoPageDTO.getPerPage();
		int length = OrderInfoPageDTO.getPerPage();

		List<OrderInfoDTO> list = session.selectList("com.mybatis.MyPageMapper.myPageOrderInfoPage", map,
				new RowBounds(sIndex, length));
		System.out.println(list + "dao list");
		System.out.println(pagedto.getOlist());
		// pagedto에 저장하기
		int totalPage = 0;
		pagedto.setOlist(list);
		pagedto.setCurPage(curPage);
		if (map.get("startdate") == null) {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.totalorderPage", map.get("userId"));
		} else {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.searchorderPage", map);
		}

		pagedto.setTotalPage(totalPage);
		pagedto.setStartdate(map.get("startdate"));
		pagedto.setFinaldate(map.get("finaldate"));

		return pagedto;
	}
	
	public GoodsPageDTO goodsinfo(SqlSession session, HashMap<String, String> map, int curPage) {
		// TODO Auto-generated method stub

		GoodsPageDTO pagedto = new GoodsPageDTO();

		int sIndex = (curPage - 1) * GoodsPageDTO.getPerPage();
		int length = GoodsPageDTO.getPerPage();

		List<GoodsDTO> list = session.selectList("com.mybatis.MyPageMapper.goodsinfo", map,new RowBounds(sIndex, length));
		System.out.println(list + "dao list");
		System.out.println(pagedto.getGlist());
		// pagedto에 저장하기
		int totalPage = 0;
		pagedto.setGlist(list);
		pagedto.setCurPage(curPage);
		if (map.get("searchName") == null) {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.totalgoodsinfo", map.get("userId"));
		} else {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.searchgoodsinfo", map);
		}

		pagedto.setTotalPage(totalPage);
		pagedto.setSearchName(map.get("searchName"));
		pagedto.setSearchValue(map.get("searchValue"));

		return pagedto;
	}
	
	
	public GoodsDTO goodsretrieve(SqlSession session,String gCode) {
		GoodsDTO dto = session.selectOne("goodsretrieve",gCode);
		return dto;
		
	}
	
	public int goodsdelete(SqlSession session, String gCode) {
		int n = session.delete("goodsdelete",gCode);
		return n;
	}
	
	public int goodsupdate(SqlSession session, HashMap<String, Object> map) {
		int n = session.update("goodsupdate",map);
		return n;
	}
	
	public List<SalesStatusDTO> sellinfo(SqlSession session, String userid) {
		List<SalesStatusDTO> sdto = session.selectList("sellinfo",userid);
		System.out.println(sdto);
		return sdto;
	}
	
	
	
}
