package main;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/sar")
public class REST_controller {
	
	private RideManager r = new RideManager();
	private AccountManager a = new AccountManager();
	private ReportManager rm = new ReportManager();
	
	@Path("/accounts")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(String json) {
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		String first = obj.get("first_name").getAsString();
		String last = obj.get("last_name").getAsString();
		String phone = obj.get("phone").getAsString();
		String picture = obj.get("picture").getAsString();
		Boolean isActive = obj.get("is_active").getAsBoolean();
		boolean atLeastOneAlpha = phone.matches(".*[a-zA-Z]+.");
		Gson gson = new Gson();
		
		if(atLeastOneAlpha) {
			return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Phone number is invalid")).build();
		}
		
		Account act = a.createAccount(first,last,phone,picture,isActive);
        String s = gson.toJson(act);
        return Response.status(Response.Status.CREATED).entity(s).build();
	}
	
	@Path("/accounts/{aid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAccount(@PathParam("aid") int aid, String json) {
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		String first = obj.get("first_name").getAsString();
		String last = obj.get("last_name").getAsString();
		String phone = obj.get("phone").getAsString();
		String picture = obj.get("picture").getAsString();
		boolean isActive = obj.get("is_active").getAsBoolean();
		Gson gson = new Gson();
		
		if(last==null||first==null) {
			return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("First Name or Last Name is invalid")).build();
		}
		
		boolean updated = a.updateAccount(aid, first, last, phone, picture, isActive);
		if(!updated) {
			return Response.status(Response.Status.NOT_FOUND).entity("Account is invalid").build();
		}
		
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	//no delete account method
	
	@Path("/accounts/{aid}/status")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response activateAccount(@PathParam("aid") int aid,String json) {
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		Boolean isActive = obj.get("is_active").getAsBoolean();
		Gson gson = new Gson();
		
		if(isActive==false&&isActive!=true) {
			return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Status is invalid.")).build();
		}
			
		boolean created = a.activateAccount(aid,isActive);
		
		if(!created) {
			return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("Account is invalid.")).build();
		}
		
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@Path("/accounts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccounts(@Context UriInfo uriInfo) {
		Gson gson = new Gson();
		String s;
		String key = uriInfo.getQueryParameters().getFirst("key");
		
		if(key==""||key==null) {
			s = gson.toJson(a.viewAllAccounts());
		}
		else {
			s = gson.toJson(a.searchAccounts(key));
		}
		
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/accounts/{aid}/ratings")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response rateAccount(@PathParam("aid") int aid, String json, @Context UriInfo uriInfo) {
		Gson gson = new Gson();
		String s;
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		int rid = obj.get("rid").getAsInt();
		Rating rate = new Gson().fromJson(obj.toString(),Rating.class);
		Rating r = a.rateAccount(aid,rate);
		s = gson.toJson(r);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path("accounts/"+aid+"/ratings/"+r.getSid());
		return Response.created(builder.build()).entity(s).build();
	}
	
	@Path("/accounts/{aid}/driver")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDriverRatings(@PathParam("aid") int aid) { 
		Gson gson = new Gson();
		String s = gson.toJson(a.viewDriverRatings(aid));
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/accounts/{aid}/rider")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRiderRatings(@PathParam("aid") int aid) { 
		Gson gson = new Gson();
		String s = gson.toJson(a.viewRiderRatings(aid));
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/rides")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRide(String json) {
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		int aid  = obj.get("aid").getAsInt();
		LocationInfo location = new Gson().fromJson(obj.toString(),LocationInfo.class);
		DateTime dateTime = new Gson().fromJson(obj.toString(),DateTime.class);
		CarInfo carInfo = new Gson().fromJson(obj.toString(),CarInfo.class);
		int maxPassengers  = obj.get("max_passengers").getAsInt();
		int amountPerPassenger  = obj.get("amount_per_passenger").getAsInt();
		String conditions  = obj.get("conditions").getAsString();
		Gson gson = new Gson();
		
		Ride ride = r.createRide(aid,location,dateTime,carInfo,maxPassengers,amountPerPassenger,conditions);
		
        String s = gson.toJson(ride);
        return Response.status(Response.Status.CREATED).entity(s).build();
	}
	
	@Path("/rides/{rid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRide(@PathParam("rid") int aid, String json) {
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		LocationInfo location = new Gson().fromJson(obj.toString(),LocationInfo.class);
		DateTime dateTime = new Gson().fromJson(obj.toString(),DateTime.class);
		CarInfo carInfo = new Gson().fromJson(obj.toString(),CarInfo.class);
		int maxPassengers  = obj.get("max_passengers").getAsInt();
		int amountPerPassenger  = obj.get("amount_per_passenger").getAsInt();
		String conditions  = obj.get("conditions").getAsString();
		Gson gson = new Gson();
		
		boolean updated = r.updateRide(aid,location,dateTime,carInfo,maxPassengers,amountPerPassenger,conditions);
		if(!updated) {
			return Response.status(Response.Status.NOT_FOUND).entity("Account is invalid").build();
		}
		
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	
	@Path("/rides/{rid}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRide(@PathParam("rid") int rid) {
		boolean delete = r.deleteRide(rid);
		if(delete) {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		
		return Response.status(Response.Status.NOT_FOUND).entity("Ride is invalid.").build();
	}
	
	@Path("/rides")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewAllRides(@Context UriInfo uriInfo) {
		Gson gson = new Gson();
		String s;
		String fromLocation = uriInfo.getQueryParameters().getFirst("from");
		String toLocation = uriInfo.getQueryParameters().getFirst("to");
		String dateTime = uriInfo.getQueryParameters().getFirst("date");
		
		if(fromLocation==null||toLocation==null) {
			s = gson.toJson(r.viewAllRides());
		}
		else {
			s = gson.toJson(r.searchRides(fromLocation, toLocation, dateTime));
			
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/rides/{rid}/messages") 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(@PathParam("rid") int rid, String json, @Context UriInfo uriInfo) {
		JsonObject jobj = new Gson().fromJson(json, JsonObject.class);
		Gson gson = new Gson();
		int aid = jobj.get("aid").getAsInt();
		String message = jobj.get("msg").getAsString();
		
		Message m = r.addMessage(rid,aid,message);
		String s = gson.toJson(m);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path("rides/"+ rid +"/messages/"+m.getMid());
		
		return Response.created(builder.build()).entity(s).build();
	}
	
	@Path("/rides/{rid}/messages")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessages(@PathParam("rid") int rid) {
		Gson gson = new Gson();
		String s = gson.toJson(r.getMessages(rid));
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/rides/{rid}/join_requests")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response requestJoinRide(@PathParam("rid") int rid, String json, @Context UriInfo uriInfo) {
		Gson gson = new Gson();
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		String s;
		int aid = obj.get("aid").getAsInt();
		int passengers = obj.get("passengers").getAsInt();
		
		JoinRequest join = r.requestJoinRide(rid,aid,passengers);
		
		if(join==null) {
			return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Account is invalid.")).build();
		}
		
		s = gson.toJson(join);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path("rides/"+rid+"/join_requests/"+join.getJid());
        return Response.created(builder.build()).entity(s).build();
    }
	
	@Path("/rides/{rid}/join_requests/{jid}")
	//@PATCH - creates a compiler error for some reason
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public Response confirmPickupRequest(@PathParam("rid") int rid, @PathParam("jid") int jid, String json) {
		JsonObject obj = new Gson().fromJson(json, JsonObject.class);
		boolean confirmed;
		
		if(obj.has("pickip_confirmed")) {
			boolean pi = obj.get("pickup_confirmed").getAsBoolean();
			confirmed = r.confirmPickupRequest(rid,jid,pi);
		}
		
		if(obj.has("ride_confirmed")) {
			boolean ri = obj.get("ride_confirmed").getAsBoolean();
			confirmed = r.confirmPickupRequest(rid, jid, ri);
		}
		
		return Response.status(Response.Status.OK).entity(" ").build();
	}
	
	@Path("/reports/{pid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReport(@PathParam("pid") int pid, @Context UriInfo uriInfo) {
		Gson gson = new Gson();
		String s = gson.toJson(rm.getReport(pid));
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/reports")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReports() {
		Gson gson = new Gson();
		String s = gson.toJson(rm.viewAllReports());
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}