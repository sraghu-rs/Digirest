package com.digibank.service.api;


import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.digibank.bean.AccountBean;
import com.digibank.bean.RequestAccountBean;
import com.digibank.db.DBAccountProcessor;


@Path("/AccountService")
public class AccountService {

		@POST
		@Path("/onlinepayment")
		@PermitAll
		@Produces(MediaType.TEXT_XML)
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response onlinepayment(@FormParam("username") String username,@FormParam("password") String password,@FormParam("bank") String bank,@FormParam("accno") String accno,@FormParam("amount") String amount) 
		{
			RequestAccountBean reqAccBean =new RequestAccountBean();
			reqAccBean.setUsername(username);
			reqAccBean.setPassword(password);
			reqAccBean.setWithdraw_amount(Double.parseDouble(amount));
			DBAccountProcessor accCtrl=new DBAccountProcessor();
			AccountBean accBean = accCtrl.withdrawMoney(reqAccBean);
			return Response.status(200).entity(accBean).build();	
		}
	}

