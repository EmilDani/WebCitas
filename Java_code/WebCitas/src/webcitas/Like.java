package webcitas;

public class Like {
	
	private User RecMG;
	private User PropMG;
	private boolean heart = false;
	private int idMG;
	public User getRecMG() {
		return RecMG;
	}
	public void setRecMG(User recMG) {
		RecMG = recMG;
	}
	public User getPropMG() {
		return PropMG;
	}
	public void setPropMG(User propMG) {
		PropMG = propMG;
	}
	public boolean isHeart() {
		return heart;
	}
	public void setHeart(boolean heart) {
		this.heart = heart;
	}
	public void toggleHeart() {
		this.heart = !heart;
	}
	public int getIdMG() {
		return idMG;
	}
	public void setIdMG(int idMG) {
		this.idMG = idMG;
	}
	
	

}
