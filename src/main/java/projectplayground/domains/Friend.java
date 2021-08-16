package projectplayground.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;

/**
 * class to map the friends list to the
 *
 */


@Getter
@Setter
public class Friend
{
    @JoinTable()
    public User user ;
    public User friend;
}
