package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActionForward {
  private String path;         // 어디로 갈 것인가?
  private boolean isRedirect;  // redirect는 true, forward는 false
}