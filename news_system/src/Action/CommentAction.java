package Action;

import Entity.Comment;
import Service.CommentService;
import Service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public class CommentAction {
    private CommentService commentService;
    private Comment comment;
    private List<Comment> commentList;
    private UserService userService;
    /*
    发表评论
     */
    private String newsid;

    /*
    分页参数
     */
    public static int PageSize = 5;
    private int commentLength;

    private String message;

    public static int getPageSize() {
        return PageSize;
    }

    public static void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getCommentLength() {
        return commentLength;
    }

    public void setCommentLength(int commentLength) {
        this.commentLength = commentLength;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public void publish() throws Exception
    {
        int userid= Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute("userid").toString());
        comment.setUserId(userid);
        comment.setNewsId(Integer.parseInt(newsid));
        SimpleDateFormat sdft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setCreateTime(sdft.parse(sdft.format(new Date())));

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter print= response.getWriter();
        if(commentService.saveComment(comment)==true)
            print.print("{\"msg\":\"success\"}");
        else
            print.print("{\"msg\":\"fail\"}");
        print.flush();
    }
    public void loadComment() throws Exception
    {
        commentList=commentService.getCommentByNewsId(Integer.parseInt(newsid),commentLength);

        //将评论数组通过json返回给客户端
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter print= response.getWriter();

        JSONArray jsonArray=new JSONArray();
        for (Comment c:commentList) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("userName",userService.getUserById(String.valueOf(c.getUserId())).getNickname());
            jsonObject.put("message",c.getMessage());
            jsonObject.put("time",getIntervalString(c.getCreateTime()));
            jsonArray.element(jsonObject);
        }

        if (commentList==null||commentList.size()==0)
        {
            JSONObject object=new JSONObject();
            object.put("isSucc","F");
            object.element("result","暂无更多评论");
            print.print(object);
            print.flush();
        }
        else {
            JSONObject object = new JSONObject();
            object.put("isSucc", "T");
            object.element("result", jsonArray);
            print.print(object);
            print.flush();
        }
    }

    public String getIntervalString(Date date)
    {
        Date now=new Date();
        long interval =(now.getTime()-date.getTime())/1000;//获得相差多少秒
        String timeString="";
        if (interval<=60)//一分钟内
            timeString="1分钟";
        else if(interval<60*60)//一小时内
            timeString=interval/60+"分钟";
        else if(interval<60*60*24)//一天内
            timeString=interval/60/60+"小时";
        else if(interval<60*60*24*30)//一个月内
        {
            timeString = interval / 60 / 60 / 24+"天";
        }
        else if(interval<60*60*24*30*12)//一年内
            timeString=interval/60/60/24/30+"月";
        else
            timeString=interval/60/60/24/30/12+"年";
        timeString+="前";
        return timeString;
    }

    public void pagefunc(List<Comment> list)
    {

    }
}
