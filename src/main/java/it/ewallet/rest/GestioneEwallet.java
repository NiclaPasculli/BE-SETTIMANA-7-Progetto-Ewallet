package it.ewallet.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import it.ewallet.pojo.ContoCorrente;
import it.ewallet.pojo.Movimento;



@Path("/contocorrente")
public class GestioneEwallet {
	
	private static List<ContoCorrente> conti = new ArrayList<ContoCorrente>();
	private static List<Movimento> movimenti = new ArrayList<Movimento>();
	
	@GET
	@Path("/listaconti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContoCorrente> retrieveConti(){
		return conti;
	}
	
	@GET
	@Path("/listamovimenti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimento> retrieveMovimenti(){
		return movimenti;
	}
	
	@POST
	@Path("/creaconto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserisciConto(ContoCorrente c) {
		conti.add(c);
		return Response.status(200).entity("Inserimento avvenuto con successo").build();
	}
	
	@DELETE
	@Path("/cancellaconto/{iban}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminaContoCorrente(@PathParam("iban") int iban) {
		//conti.remove(c);
		for(ContoCorrente con : conti) {
			if(con.getIban() == iban) {
				conti.remove(con);
				break;
			}
		}
		return Response.status(200).entity("Eliminazione avvenuta con successo").build();
				}
	
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiornaConto(ContoCorrente c) {
		
		for(ContoCorrente con : conti) {
			if(con.getIban() == c.getIban()) {
				int index = conti.lastIndexOf(con);
				conti.set(index, c);
			}
		}
		return Response.status(200).entity("Aggiornamento avvenuto con successo").build();
	}
	@GET
	@Path("/cercaconto/{iban}")
	@Produces(MediaType.APPLICATION_JSON)
	public ContoCorrente retrieveByPk(@PathParam("iban") int iban) {
		ContoCorrente c = null;
		for(ContoCorrente con : conti) {
			if(con.getIban() == iban) {
				c= con;
			}
		}
		return c;
	}
	@PUT
	@Path("/preleva/{importo}/{dataM}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response prelievo(ContoCorrente c, @PathParam("importo")double importo, @PathParam("dataM")String dataM) {
		
		for(ContoCorrente con : conti) {
			if(con.getIban() == c.getIban()) {
				double nuovoSaldo = c.getSaldo()-importo;
				c.setSaldo(nuovoSaldo);
				Movimento m = new Movimento();
				m.setImporto(importo);
				m.setTipo("prelievo");
				m.setIbanM(c.getIban());
				m.setDataM(dataM);
				movimenti.add(m);
				int index = conti.lastIndexOf(con);
				conti.set(index, c);
			}
		}
		return Response.status(200).entity("Prelievo avvenuto con successo").build();
	}
	
	@PUT
	@Path("/versa/{importo}/{dataM}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response versamento(ContoCorrente c, @PathParam("importo")double importo, @PathParam("dataM")String dataM) {
		
		for(ContoCorrente con : conti) {
			if(con.getIban() == c.getIban()) {
				double nuovoSaldo = c.getSaldo()+importo;
				c.setSaldo(nuovoSaldo);
				Movimento m = new Movimento();
				m.setImporto(importo);
				m.setTipo("versamento");
				m.setIbanM(c.getIban());
				m.setDataM(dataM);
				movimenti.add(m);
				int index = conti.lastIndexOf(con);
				conti.set(index, c);
			}
		}
		return Response.status(200).entity("Versamento avvenuto con successo").build();
	}
	
	
		
	
}
