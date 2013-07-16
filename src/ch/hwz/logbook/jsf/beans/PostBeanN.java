package ch.hwz.logbook.jsf.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

import ch.hwz.logbook.jsf.model.Post;


@ManagedBean(name="postBeanN")
@SessionScoped
public class PostBeanN implements Serializable{
 
	//resource injection
	@Resource(name="jdbc/HwzLogBook")
	private DataSource ds;
 
	//if resource injection is not support, you still can get it manually.
//	public CustomerBean(){
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mkyongdb");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
// 
//	}
 
	//connect to DB and get customer list
	public List<Post> getPostList() throws SQLException{
 
		if(ds==null)
			throw new SQLException("Can't get data source");
 
		//get database connection
		Connection con = ds.getConnection();
 
		if(con==null)
			throw new SQLException("Can't get database connection");
 
		PreparedStatement ps 
			= con.prepareStatement(
			   "select postID,user,title,text,created_date from post"); 
 
		//get customer data from database
		ResultSet result =  ps.executeQuery();
 
		List<Post> list = new ArrayList<Post>();
 
		while(result.next()){
			Post p = new Post();
 
			p.setPostID(result.getLong("postID"));
			p.setUser(result.getString("user"));
			p.setTitle(result.getString("title"));
			p.setText(result.getString("text"));
			p.setCreated_date(result.getDate("created_date"));			
			
			//store all data into a List
			list.add(p);
		}
 
		return list;
	}
}