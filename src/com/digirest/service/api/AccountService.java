package com.digirest.service.api;


import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.digirest.bean.AccountBean;
import com.digirest.bean.RequestAccountBean;
import com.digirest.db.DBAccountProcessor;


@Path("/AccountService")
public class AccountService {

		@POST
		@Path("/onlinepayment")
		@PermitAll
		@Produces(MediaType.TEXT_HTML)
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response onlinepayment(@FormParam("username") String username,@FormParam("password") String password,@FormParam("bank") String bank,@FormParam("accno") String account_number,@FormParam("amount") String amount,@FormParam("urlpath") String urlpath) 
		{
			System.out.println("Request received from :"+ username);
			RequestAccountBean reqAccBean =new RequestAccountBean();
			reqAccBean.setUsername(username);
			reqAccBean.setPassword(password);
			reqAccBean.setWithdraw_amount(Double.parseDouble(amount));
			reqAccBean.setAccount_number(Integer.parseInt(account_number));
			DBAccountProcessor accCtrl=new DBAccountProcessor();
			AccountBean accBean = accCtrl.withdrawMoney(reqAccBean);
			String successmsg="Your payment is successful. To Go back to PetClinic:<a href=" + urlpath + "> Click here </a>";
			return Response.status(200).entity(successmsg).build();	
		}
	}

