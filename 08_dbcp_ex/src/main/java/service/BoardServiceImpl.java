package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.BoardDto;
import repository.BoardDao;
import util.PageVo;

public class BoardServiceImpl implements BoardService {

  // 모든 서비스가 공동으로 사용하는 BoardDao, PageVo 객체 가져오기
  private BoardDao dao = BoardDao.getDao();
  private PageVo pageVo = new PageVo();

  @Override
  public ActionForward addArticle(HttpServletRequest request) {
    
    // 등록할 제목과 내용
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    // 제목 + 내용 -> BoardDto 객체
    BoardDto dto = BoardDto.builder()
                      .title(title)
                      .content(content)
                      .build();
    
    // BoardDao의 register 메소드 호출
    int addArticleResult = dao.addArticle(dto);
    
    // 등록 성공(registerResult == 1), 등록 실패(registerResult == 0)
    String path = null;
    if(addArticleResult == 1) {
      path = request.getContextPath() + "/board/list.do";
    } else if(addArticleResult == 0) {
      path = request.getContextPath() + "/index.do";
    }
    
    // 어디로 어떻게 이동하는지 반환 (insert 수행 후에는 반드시 redirect 이동한다.)
    return new ActionForward(path, true);
    
  }

  @Override
  public ActionForward getBoardList(HttpServletRequest request) {
    
    /* page, total, display 정보가 있어야 목록을 가져올 수 있다. */
    
    // 전달된 페이지 번호 (페이지 번호의 전달이 없으면 1 페이지를 연다.)
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(opt.orElse("1"));
    
    int total = dao.getBoardCount();
    
    int display = 5;  // 고정 값 사용(원하면 파라미터로 받아 오는 것으로 변경도 가능함)
    
    // PageVo의 모든 정보 계산하기
    pageVo.setPaging(page, total, display);
    
    // 게시글 목록을 가져올 때 사용할 변수들을 Map으로 만듬
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("begin", pageVo.getBegin());
    map.put("end", pageVo.getEnd());
    
    // DB로부터 게시글 목록 가져오기
    List<BoardDto> boardList = dao.getBoardList(map);
    
    // 게시글 목록과 paging을 /board/list.jsp로 전달하기 위하여 request에 저장한 뒤 forward한다.
    request.setAttribute("boardList", boardList);
    request.setAttribute("paging", pageVo.getPaging(request.getContextPath() + "/board/list.do"));
    return new ActionForward("/board/list.jsp", false);
    
  }
  
  @Override
  public ActionForward getBoardByNo(HttpServletRequest request) {
    
    // 상세조회할 게시글 번호 
    Optional<String> opt = Optional.ofNullable(request.getParameter("article_no"));
    int article_no = Integer.parseInt(opt.orElse("0"));
    
    // DB로부터 게시글 가져오기
    BoardDto board = dao.getBoardByNo(article_no);
    
    // 게시글을 /board/detail.jsp에 전달하기 위해서 forward 처리
    request.setAttribute("board", board);
    
    return new ActionForward("/board/detail.jsp", false);
  }
  
  @Override
  public ActionForward editArticle(HttpServletRequest request) {


    
    // 편집할 게시글 번호 
    Optional<String> opt = Optional.ofNullable(request.getParameter("article_no"));
    int article_no = Integer.parseInt(opt.orElse("0"));
    
    // DB로부터 게시글 가져오기
    BoardDto board = dao.getBoardByNo(article_no);
    
    // 게시글을 /board/edit.jsp에 전달하기 위해서 forward 처리
    request.setAttribute("board", board);   
    return new ActionForward("/board/edit.jsp", false);
    
  }
  
  @Override
  public ActionForward modityArticle(HttpServletRequest request) {

    
    // 수정할 게시글 정보
   String title = request.getParameter("title");
   String content = request.getParameter("content");
   int article_no = Integer.parseInt(request.getParameter("article_no"));
    
   // 수정할 게시글 정보를 BoardDto 객체로 생성
   BoardDto dto = BoardDto.builder()
                   .title(title)
                   .content(content)
                   .article_no(article_no)
                   .build();
   
   // 수정하기
   int modifyResult = dao.modify(dto);
   
   // 수정 성공(modifyResult == 1), 수정 실패(modifyResult == 0)
   String path = null;
   if(modifyResult == 1) {
     path = request.getContextPath() + "/board/detail.do?article_no=" + article_no;
   } else {
     path = request.getContextPath() + "/index.do";
   }
   
   // update 이후에는 redirect 한다.
   return new ActionForward(path, true);
  }
  
  
  @Override
  public ActionForward deleteArticle(HttpServletRequest request) {

    // 삭제할 게시글 번호 
    Optional<String> opt = Optional.ofNullable(request.getParameter("article_no"));
    int article_no = Integer.parseInt(opt.orElse("0"));
    
    
    // 삭제하기
    int deleteResult = dao.delete(article_no);
    
    // 삭제 성공(deleteResult == 1), 삭제 실패(deleteResult == 0)
    String path = null;
    if(deleteResult == 1) {
      path = request.getContextPath() + "/board/list.do";
    } else if(deleteResult == 0) {
      path = request.getContextPath() + "/index.do";
    }
    
    // delete 이후에는 redirect 한다.
    return new ActionForward(path, true);
  }
  
  
  @Override
  public ActionForward plusHit(HttpServletRequest request) {


    return null;
  }
}