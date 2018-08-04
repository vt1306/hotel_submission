package Model;

public class RootObject {
	private Cmfoodchain cmfoodchain;

	public Cmfoodchain getCmfoodchain() {
		return this.cmfoodchain;
	}

	public void setCmfoodchain(Cmfoodchain cmfoodchain) {
		this.cmfoodchain = cmfoodchain;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** CM Details *****\n");
		sb.append("CM Food Chain"+getCmfoodchain()+"\n");
		sb.append("*****************************");
		
		return sb.toString();
	}
}
