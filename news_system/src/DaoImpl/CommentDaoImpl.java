package DaoImpl;

import Action.CommentAction;
import Dao.CommentDao;
import Entity.Comment;
import PagerUtil.Pager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {
    @Override
    public void saveComment(Comment comment) {
        getHibernateTemplate().save(comment);
    }

    @Override
    public List<Comment> getCommentByNewsId(final String hql,final int currentrow,final int pagesize) {
        List<Comment> list = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery(hql);
                query.setFirstResult(currentrow);
                query.setMaxResults(pagesize);
                List<Comment> list = query.list();
                return list;
            }
        });
        return list;
    }

    @Override
    public List<Comment> getCommentByNewsId(int newsid,int currentrow) {
        String hql="from Comment where newsid='"+newsid+"' order by createTime desc";
        return getCommentByNewsId(hql,currentrow, CommentAction.PageSize);
    }
}
