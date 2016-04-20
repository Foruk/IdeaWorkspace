package Dao;

import Entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface CommentDao {
    public void saveComment(Comment comment);
    public List<Comment> getCommentByNewsId(final String hql, final int currentrow, final int pagesize);
    public List<Comment> getCommentByNewsId(int newsid,int currentrow);
}
