package board.model.vo;

public class BoardPage {
	private int startRow;
	private int endRow;
	public BoardPage(){}
	public BoardPage(int currentPage, int limit){
		this.startRow = (currentPage -1) * limit + 1;
		this.endRow = startRow + limit - 1;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
}
