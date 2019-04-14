package all;
public class BruteForce extends Algorithm {
	/**
	 * Get solution of problem using brute force which checked all possible combinations of taken items and choose optimum.
	 */
	@Override
	public Solution GetSolution() {
		Solution opt = new Solution(); 
		opt.valueBackpack=0;
		Solution helper = new Solution();
		int BackpackSize = instance.GetCapacity();
		
		for(int i=0;i<=2<<instance.GetSize();i++)
		{
			for(int j=0;j<instance.GetSize();j++)
			{
				if((2<<j&i)==0)
				{
					if(BackpackSize-instance.GetItem(j).GetWeight()>=0)
					{
						helper.Items.add(instance.GetItem(j));
						helper.valueBackpack+=instance.GetItem(j).GetValue();
						BackpackSize-=instance.GetItem(j).GetWeight();
					}
				}
			}
			if(helper.valueBackpack>opt.valueBackpack)
			{
				opt=helper;
			}
			helper=new Solution();
			BackpackSize = instance.GetCapacity();
			}
		
		return opt;
	}

	@Override
	public String GetName() {
		return "Brute";
	}	
}
