package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {
  private int article_no;
  private String title;
  private String content;
  private String editor;
  private int hit;
  private Date lastModified;
  private Date created;
  
  
}
