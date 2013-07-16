package ch.hwz.logbook.jsf.service;

import java.util.Date;

import javax.inject.Named;

import ch.hwz.logbook.jsf.domain.Post;

@Named
public class PostManager
{
    public void create(Post post, String user)
    {
        post.setDate(new Date());
        post.setUser(user);
    }
}
