/**
 * 
 */
package io.uetunited.oneheed.dao;


import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author la-pc
 *
 */
@Repository
public class MessageDao {
    @Autowired
    Jdbi jdbi = null;

}
