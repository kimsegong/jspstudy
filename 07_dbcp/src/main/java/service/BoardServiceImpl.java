package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.BoardDto;
import repository.BoardDao;

public class BoardServiceImpl implements BoardService {

  // 모든 서비스가 공동으로 사용하는 BoardDao 객체 가져오기
  private BoardDao dao = BoardDao.getDao();
  
  @Override
  public ActionForward register(HttpServletRequest request) {
    
    // 등록할 제목과 내용
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    // 제목 + 내용 -> BoardDto 객체
    BoardDto dto = BoardDto.builder()
                     .title(title)
                     .content(content)
                     .build();
    
    // BoardDao의 register 메서드 호출
    int registerResult =  dao.register(dto);
    
    // 등록 성공(registerResult == 1), 등록 실패(registerResult == 0)
    String path = null;
    if(registerResult == 1) {
      path = "/board/list.jsp";
    } else if(registerResult == 0) {
      path = "/index.jsp";
    }
    // 어디로 어떻게 이동하는지 반환 (insert 수행 후에는 반드시 redirect 이동한다.)
    return new ActionForward(path, true);
  }

}
