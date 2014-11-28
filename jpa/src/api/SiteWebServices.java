package api;


import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.neu.cs5200.ide.jpa.Site;
import edu.neu.cs5200.ide.jpa.SiteDAO;
 

@Path("/site")
public class SiteWebServices {

	
	SiteDAO siteDaoObj = new SiteDAO();
/*
findAllSites()
Get
api/site
none
JSON array of all site instances
*/
	
	@GET	
	@Produces("application/json")
	@Path("/")
	public List<Site> findAllSites(){
		return siteDaoObj.findAllSites();
		
	}
	
/*
findSite()
Get
api/site/ID
Site Id to be retrieved
JSON instance of site whose id is in path parameter	
	*/
	@GET	
	@Produces("application/json")
	@Path("/{ID}")
	public Site findSite(@PathParam("ID") int siteId){
	System.out.println("heellp");
		return siteDaoObj.findSite(siteId);		
	}
	

/*createSite()
Post
api/site
JSON instance of
site to be created
JSON array of all site instances*/
	
	@POST	
	@Path("/")
	@Consumes("application/json")	
	public List<Site> createSite(Site newSite){
		System.out.println("help");
		return siteDaoObj.createSite(newSite);		
	}

/*deleteSite()
Delete
api/site
Site Id to be deleted
JSON array of all site instances*/

	@DELETE	
	@Produces("application/json")
	@Path("/{ID}")
	public List<Site> deleteSite(@PathParam("ID") int siteId){
		return siteDaoObj.removeSite(siteId);		
	}

/*updateSite()
Update
api/site/ID
Site Id to be updated and
JSON instance of site
containing new property
values
JSON array of all site instances*/

	@PUT	
	@Produces("application/json")
	@Path("/{ID}")
	public List<Site> updateSite(@PathParam("ID") int siteId, Site newsite){
		return siteDaoObj.updateSite(siteId, newsite);		
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
