/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blog.ejb;

/**
 *
 * @author talestk
 */
import java.util.ArrayList;
import java.util.List;
 
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import com.mycompany.blog.entity.BlogEntry;
 
@Stateless
public class BlogEntryEJB {
    
    // The unit name that we’re using in @PersistenceContext should  
    // correspond to the defined named in our persistence.xml

	@PersistenceContext(unitName = "defaultPersistenceUnit")
	private EntityManager	em;
 
	public BlogEntry saveBlogEntry(BlogEntry blogEntry) {
		em.persist(blogEntry);
		return blogEntry;
	}
 
	public List<BlogEntry> findBlogEntries() {
		final Query query = em.createQuery("SELECT b FROM BlogEntry b ORDER BY b.created DESC");
		List<BlogEntry> entries = query.getResultList();
		if (entries == null) {
			entries = new ArrayList<BlogEntry>();
		}
		return entries;
	}
 
	public void deleteBlogEntry(BlogEntry blogEntry) {
		blogEntry = em.merge(blogEntry);
		em.remove(blogEntry);
	}
}