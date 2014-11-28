package edu.neu.cs5200.ide.jpa;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
 
/**
 * @author Guna
 *
 */
public class SiteDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
	
	EntityManager em = null;
	
	public SiteDAO(){
		em = factory.createEntityManager();
	}
	
	// returns an instance of Site representing a record whose id is siteId	
	public Site findSite(int siteId) {
		em.getTransaction().begin();
		Site siteObj = em.find(Site.class, siteId);		
		em.getTransaction().commit();
		return siteObj;		
	}
	
	// returns a list of Site instances
	public List<Site> findAllSites() {
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT s FROM Site s", Site.class);
		List<Site> lstSite = q.getResultList();
		em.getTransaction().commit();
		return lstSite;
	}
	
	// Update the site data with given id with values given by new site object
	public List<Site> updateSite(int siteId, Site site)
	{			
		em.getTransaction().begin();
		Site siteObj = em.find(Site.class, siteId);		
		siteObj.setLatitude(site.getLatitude());
		siteObj.setLongitude(site.getLongitude());
		siteObj.setName(site.getName());
		em.merge(siteObj);
		em.getTransaction().commit();
		return findAllSites();
	}

	//  removes a site record whose id is siteId and the returns a list of all the sites
	public List<Site> removeSite(int siteId){
		em.getTransaction().begin();
		// HOW DO I DELETE DATA FROM EQUIPMENT AND TOWER Before deleting the object from 
		// SITE
		Site siteObj = em.find(Site.class, siteId);	
		em.remove(siteObj);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	
	// inserts a new site record into the database and then returns a list of all the sites	
	public List<Site> createSite(Site siteObj){
		em.getTransaction().begin();
		em.persist(siteObj);
		em.getTransaction().commit();
		return findAllSites();
	}
		
	public static void main(String[] args) {
		
		// CREATE SITES
		
		//<site id="1" name="Site 1" latitude="12.23" longitude="23.34">
		/*Site siteObj = new Site("Site 1", 12.23,23.34);
		SiteDAO sitedaoObj = new SiteDAO();
		sitedaoObj.createSite(siteObj);	
		//<site id="2" name="Site 2" latitude="3434" longitude="342">
		Site siteObj1 = new Site("Site 2", 22 , 222);
		Site siteObj2 = new Site("Site 3", 33 , 333);
		Site siteObj21 = new Site("Site 7", 77 , 777);
		sitedaoObj.createSite(siteObj1);
		sitedaoObj.createSite(siteObj2);	*/
		
				
		// FIND ALL SITES
		SiteDAO sitedaoObj = new SiteDAO();
		System.out.println(sitedaoObj.findAllSites());
		
		// FIND BY ID
		System.out.println(sitedaoObj.findSite(5));
		
		// UPDATE BY ID
	//	Site siteObj2 = new Site("Site 6", 633 , 6333);		
		//sitedaoObj.updateSite(6, siteObj2);
		
		// REMOVE BY ID
		//sitedaoObj.removeSite(8);
	}

	
}

/*
<siteDatabase>
<site id="1" name="Site 1" latitude="12.23" longitude="23.34">
  <tower id="1" name="Tower A" height="123.45" sides="3">
    <equipment id="1" name="Equipment 1" brand="Brand 1" description="Description 1" price="1234.56"/>
    <equipment id="2" name="Equipment 2" brand="Brand 2" description="Description 2" price="2345.67"/>
  </tower>
  <tower id="2" name="Tower B" height="244" sides="43">
    <equipment id="3" name="Equipment 3" brand="Brand 3" description="Description 3" price="77"/>
    <equipment id="4" name="Equipment 4" brand="Brand 4" description="Description 4" price="97"/>
  </tower>
</site>
<site id="2" name="Site 2" latitude="3434" longitude="342">
  <tower id="3" name="Tower C" height="352" sides="34">
    <equipment id="5" name="Equipment 5" brand="Brand 5" description="Description 5" price="2423"/>
    <equipment id="6" name="Equipment 6" brand="Brand 6" description="Description 6" price="242"/>
  </tower>
  <tower id="4" name="Tower D" height="868" sides="35">
    <equipment id="7" name="Equipment 7" brand="Brand 7" description="Description 7" price="954"/>
    <equipment id="8" name="Equipment 8" brand="Brand 8" description="Description 8" price="532"/>
  </tower>
</site>
</siteDatabase>*/