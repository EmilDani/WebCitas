import java.sql.Date;

public class DinnerDate {
	
	private meetState state;
	private User proposer;
	private User receiver;
	private Date proposal_sello;
	private Date response_sello;
	private Date fecha;
	
	public meetState getState() {
		return state;
	}
	public void setState(meetState state) {
		this.state = state;
	}
	public User getProposer() {
		return proposer;
	}
	public void setProposer(User proposer) {
		this.proposer = proposer;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public Date getProposal_sello() {
		return proposal_sello;
	}
	public void setProposal_sello(Date proposal_sello) {
		this.proposal_sello = proposal_sello;
	}
	public Date getResponse_sello() {
		return response_sello;
	}
	public void setResponse_sello(Date response_sello) {
		this.response_sello = response_sello;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
