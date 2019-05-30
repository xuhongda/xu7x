package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongda on 2019/5/30
 * pojo
 * xu7x
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    /**
     * 作者
     */
    private String author;
    /**
     * 发布时间
     */
    private Date date;
    /**
     *  历史修改时间
     */
    private List<Date> modifyDates;
    /**
     * 文章标题
     */
    private String title;
    /**
     *  段落内容
     */
    private Map<Integer,String> content;
}
