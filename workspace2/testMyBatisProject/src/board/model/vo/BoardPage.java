package board.model.vo;

public class BoardPage {
	private int currentPage;
	private int limit;
	private int startRow;
	private int endRow;
	
	public BoardPage(){}

	public BoardPage(int currentPage, int limit, int startRow, int endRow) {
		super();
		this.currentPage = currentPage;
		this.limit = limit;
		this.startRow = startRow;
		this.endRow = endRow;
	}



	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStartRow() {
		return  (currentPage -1) * limit + 1;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return startRow + limit - 1;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
}
