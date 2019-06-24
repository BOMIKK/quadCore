package com.cns.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cns.dao.NewsDAO;
import com.cns.dto.Criteria;
import com.cns.dto.NewsVO;
import com.cns.dto.TagVO;
import com.cns.dto.UserVO;

import lombok.Setter; 
@Service
public class NewsServiceImpl implements NewsService {
 

    @Setter(onMethod_ = @Autowired)
	private NewsDAO dao;
    
    @Override
    public List<NewsVO> selectNews() throws Exception {
 
        return dao.selectNews();
    }
    
    
    //카테고리
	@Override
	public List<NewsVO> selectPolitics(Criteria cri) throws Exception {
		return dao.selectPolitics(cri);
	}

	@Override
	public List<NewsVO> selectLiving(Criteria cri) throws Exception {
		return dao.selectLiving(cri);
	}

	@Override
	public List<NewsVO> selectIT(Criteria cri) throws Exception {
		return dao.selectIT(cri);
	}

	@Override
	public List<NewsVO> selectSociety(Criteria cri) throws Exception {
		return dao.selectSociety(cri);
	}

	@Override
	public List<NewsVO> selectEconomy(Criteria cri) throws Exception {
		return dao.selectEconomy(cri);
	}
	
	
	
	//신문사
	@Override
	public List<NewsVO> selectChosun() throws Exception {
		return dao.selectChosun();
	}

	@Override
	public List<NewsVO> selectDonga() throws Exception {
		return dao.selectDonga();
	}

	@Override
	public List<NewsVO> selectHankyoreh() throws Exception {
		return dao.selectHankyoreh();
	}

	@Override
	public List<NewsVO> selectJoongang() throws Exception {
		return dao.selectJoongang();
	}

	@Override
	public List<NewsVO> selectYonhap() throws Exception {
		return dao.selectYonhap();
	}


	@Override
	public NewsVO getNews(Long news_id) throws Exception {
		return dao.getNews(news_id);
	}


	@Override
	public List<TagVO> getTag(Long news_id) throws Exception {
		return dao.getTag(news_id);
	}


	@Override
	public List<NewsVO> getListWithPaging(Criteria cri) throws Exception {
		return dao.getListWithPaging(cri);
	}


	@Override
	public int getTotal(String category) throws Exception {
		return dao.getTotal(category);
	}
	
	@Override
	public int getTotalPress(String press) throws Exception {
		return dao.getTotalPress(press);
	}


	@Override
	public List<NewsVO> selectPress(Criteria cri) throws Exception {
		return dao.selectPress(cri);
	}


	@Override
	public int signUp(UserVO user) throws Exception {
		return dao.signUp(user);
		
	}
    
	
	  @Override 
	  public int login(UserVO user) throws Exception { 
		  String pw = dao.login(user.getEmail());
		 if(pw != null)
		 {
			 if(user.getPassword().contentEquals(pw)) {
				 return 100; //ok
			 }
			 else {
				 return 200; //pw일치 x
			 }
		 }
		 else
			 return 300; //emailx
	}


	@Override
	public List<TagVO> getUserTag(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		int user_id = dao.getUserId(user);
		return dao.getUserTag(user_id);
	}


	@Override
	public UserVO getUser(UserVO user) throws Exception  {
		// TODO Auto-generated method stub
		return dao.getUser(user);
	}


	@Override
	public List<NewsVO> getUserTagNews(UserVO user) throws Exception  {
		int user_id = dao.getUserId(user);
		return dao.getUserTagNews(user_id);
	}
	 
    
 
}

