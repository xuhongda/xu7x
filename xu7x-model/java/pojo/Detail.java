package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author xuhongda on 2019/6/24
 * pojo
 * xu7x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Detail {

    private Xu7xIndex xu7xIndex;

    private List<Xu7xContent> xu7xContents;
}
