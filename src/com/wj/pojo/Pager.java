package com.wj.pojo;
/**
 * ��ҳʵ����
 * @author ����
 * @@����ʱ�� 2020��4��3������4:35:30
 */

import java.util.List;

public class Pager {
      private int currPage=1;//��ǰҳ
      private int pageSize=3;//ÿҳ��ʾ����
      private int totalCount;//����������
      private int totalPages;//��ҳ��
      private List<Object> pageLists;//װ��ҳ�����ݵ�����
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		totalPages=totalCount % pageSize ==0 ? totalCount/pageSize : totalCount/pageSize +1;
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<Object> getPageLists() {
		return pageLists;
	}
	public void setPageLists(List<Object> pageLists) {
		this.pageLists = pageLists;
	}
      
}
