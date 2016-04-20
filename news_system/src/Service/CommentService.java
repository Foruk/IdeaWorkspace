package Service;

import Entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface CommentService {
    public Boolean saveComment(Comment comment);
    public List<Comment> getCommentByNewsId(int newsid, int currentrow);
}
