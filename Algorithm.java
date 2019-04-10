package deafult;
public abstract class Algorithm {
	
	protected Instance instance;
	
	/**
	 * Add instance of problem to Algorithm
	 * @param instance - instance of problem
	 */
	public void AddInstance(Instance instance){
		this.instance=instance;
	};
	/**
	 * Abstract function which have to be extend
	 * @return Problem solution
	 */
	public abstract Solution GetSolution();
}
