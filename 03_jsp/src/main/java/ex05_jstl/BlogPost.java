package ex05_jstl;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogPost {
  
  private int blogPostNo;
  private String title;
  private int hit;
  private LocalDate createdAt;
}
