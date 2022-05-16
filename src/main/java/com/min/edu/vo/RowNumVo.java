package com.min.edu.vo;

import java.io.Serializable;

public class RowNumVo implements Serializable {

	private static final long serialVersionUID = -7518380847273610327L;
	
	// 출력할 페이지의 번호 갯수
	private int pageList;
	
	// 출력할 페이지의 번호
	private int index;
	
	// 출력할 페이지의 시작 번호
	private int pageNum;
	
	// 출력할 리스트의 갯수
	private int listNum;
	
	// 전체 리스트의 갯수
	private int total;
	
	{
		pageList = 5;
		index = 0;
		pageNum= 1;
		listNum = 5;
	}
	
	public RowNumVo() {
	}
	/**
	 * 화면에서 변경되는 값의 처리 / null 은 첫페이지 호출시 값이 없음을 판단하기 쉬움
	 */
	public RowNumVo(String index, String pageNum, String listNum) {
		if(index != null) {
			this.index = Integer.parseInt(index) ;
		}
		if(pageNum != null) {
			this.pageNum = Integer.parseInt(pageNum);
		}
		if(listNum != null) {
			this.listNum = Integer.parseInt(listNum);
		}
	}
	
	
	@Override
	public String toString() {
		return "RowNumVo [pageList=" + pageList + ", index=" + index + ", pageNum=" + pageNum + ", listNum=" + listNum
				+ ", total=" + total + "]";
	}
	/**
	 * 쿼리문에서 글의 시작 ROWNUM 번호를 만들어 낸다.
	 * 1 PAGE 라면 1 
	 */
	// 시작 번호
	public int getStart() {
		return index * listNum + 1 ;
	}
	
	/**
	 * 쿼리문에서 글의 끝 ROWNUM 번호를 만들어 낸다.
	 * ~ 5 
	 */
	// 끝 번호
	public int getLast() {
		return (index + 1) * listNum;
		// return (index * listNum) + listNum;
	}
	
	public int getCount() {
		int count = 0;
		int temp = total - listNum*(pageNum-1); // ex) 35 - 5*(6-1) = 10 남은 그룹의 총 글의 갯수
		int min = temp/listNum;   // ex) 10 / 5 = 2 남아있는 그룹의 index 갯수
		
		if(temp%listNum != 0) {
			min++;
		}
		
		if(temp <= listNum) { // 남아있는 글의 갯수가 1페이지이다
			count = pageNum;
		}else if(min <= pageList) {
			count = min + pageNum - 1;
		}else {
			count = pageList + pageNum - 1;
		}
		System.out.println("count(index 그룹의 끝 번호) : " + count);
//		count = (int)Math.ceil(total/listNum);
		return count;
	}
	
	public int getPageList() {
		return pageList;
	}
	public void setPageList(int pageList) {
		this.pageList = pageList;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getListNum() {
		return listNum;
	}
	public void setListNum(int listNum) {
		this.listNum = listNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
