package dev.estillero.models;

public class FundInfo {
	
	private int request_id;
	private double amt_requested;
	private double amt_awarded;
	private double amt_reimbursed;
	
	
	public FundInfo() {
		super();
	}
	
	
	public FundInfo(double amt_requested) {
		super();
		this.amt_requested = amt_requested;
	}
	
	
	public FundInfo(double amt_requested, double amt_awarded) {
		super();
		this.amt_requested = amt_requested;
		this.amt_awarded = amt_awarded;
	}
	
	
	public FundInfo(double amt_requested, double amt_awarded, double amt_reimbursed) {
		super();
		this.amt_requested = amt_requested;
		this.amt_awarded = amt_awarded;
		this.amt_reimbursed = amt_reimbursed;
	}
	
	
	public FundInfo(int request_id, double amt_requested, double amt_awarded, double amt_reimbursed) {
		super();
		this.request_id = request_id;
		this.amt_requested = amt_requested;
		this.amt_awarded = amt_awarded;
		this.amt_reimbursed = amt_reimbursed;
	}
	
	
	public int getRequest_id() {
		return this.request_id;
	}
	
	
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	
	
	public double getAmt_requested() {
		return this.amt_requested;
	}
	
	
	public void setAmt_requested(double amt_requested) {
		this.amt_requested = amt_requested;
	}
	
	
	public double getAmt_awarded() {
		return this.amt_awarded;
	}
	
	
	public void setAmt_awarded(double amt_awarded) {
		this.amt_awarded = amt_awarded;
	}
	
	
	public double getAmt_reimbursed() {
		return this.amt_reimbursed;
	}
	
	
	public void setAmt_reimbursed(double amt_reimbursed) {
		this.amt_reimbursed = amt_reimbursed;
	}
	
	
	@Override
	public String toString() {
		return "FundInfo [request_id=" + this.request_id + ", amt_requested=" + this.amt_requested + ", amt_awarded="
			+ this.amt_awarded + ", amt_reimbursed=" + this.amt_reimbursed + "]";
	}
}
