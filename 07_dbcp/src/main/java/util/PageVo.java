package util;

public class PageVo {

  private int page;    // 현재 페이지 번호(요청 파라미터로 받는다.)
  private int total;   // 전체 항목의 개수(DB에서 구한 뒤 받는다.)
  private int display; // 한 페이지에 표시할 항목의 갯수(요청 파라미터로 받는다.)
  private int begin;   // 한 페이지에 표시되는 항목의 시작 번호(계산한다.)
  private int end;     // 한 페이지에 표시되는 항목의 종료 번호(계산한다.)
  
  public void setPage(int page, int total, int display) {
    
    // 받은 정보 저장
    this.page = page;
    this.total = total;
    this.display = display;
    
    // 계산한 정보 저장
    begin = (page - 1) * display + 1;
    end = begin + display - 1 ;
  }
}
