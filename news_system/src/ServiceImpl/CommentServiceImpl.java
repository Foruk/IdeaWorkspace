package ServiceImpl;

import Dao.CommentDao;
import Entity.Comment;
import Service.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao;

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Boolean saveComment(Comment comment) {
        if (comment==null)
            return false;
        commentDao.saveComment(comment);
        return true;
    }

    @Override
    public List<Comment> getCommentByNewsId(int newsid, int currentrow) {
        List<Comment> list=commentDao.getCommentByNewsId(newsid,currentrow);
        if (list==null)
            return null;
        else
            return list;
    }
}
