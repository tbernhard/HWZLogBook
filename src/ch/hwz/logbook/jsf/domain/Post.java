package ch.hwz.logbook.jsf.domain;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * A simple data class representing a post.
 * 
 * @author Siebe Joris Jochems
 * 
 */
public class Post
{
    @Size(min = 2, max = 120)
    private String text;
    private Date date;

    /**
     * @return the actual text of this {@link Post}.
     */
    public String getText()
    {
        return text;
    }

    /**
     * Set the actual text of this {@link Post}. Size is restricted to minimal 2
     * and maximal 120 characters.
     * 
     * @param text The text to set.
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * @return The creation date of this {@link Post}.
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date The creation date of this {@link Post}.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }
}
