package dev.estillero.models;

public class Request {
	
	private RequestInfo ri;
	private RequestStatus rs;
	private FundInfo fi;
	
	
	public Request() {
		super();
	}
	
	
	public Request(RequestInfo ri, RequestStatus rs, FundInfo fi) {
		super();
		this.ri = ri;
		this.rs = rs;
		this.fi = fi;
	}
	
	
	public RequestInfo getRi() {
		return this.ri;
	}
	
	
	public void setRi(RequestInfo ri) {
		this.ri = ri;
	}
	
	
	public RequestStatus getRs() {
		return this.rs;
	}
	
	
	public void setRs(RequestStatus rs) {
		this.rs = rs;
	}
	
	
	public FundInfo getFi() {
		return this.fi;
	}
	
	
	public void setFi(FundInfo fi) {
		this.fi = fi;
	}
	
	
	@Override
	public String toString() {
		return "Request [ri=" + this.ri + ", rs=" + this.rs + ", fi=" + this.fi + "]";
	}
}
