package all;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSearch extends Algorithm {
	/**
	 * Get solution of problem using random search algorithm which choose one hundred times random solution and pick the best one.
	 */
	@Override
	public Solution GetSolution() {
		Random rand= new Random();
		List<Integer> indexes = new ArrayList<Integer>();
		int Index=0;
		Solution opt = new Solution(); 
		opt.valueBackpack=0;
		Solution helper = new Solution();
		int BackpackSize = instance.GetCapacity();
		for(int i=0;i<100;i++)
		{
			indexes.clear();
			for(int j=0;j<instance.GetSize();j++)
			{
				do {
				Index = rand.nextInt(instance.GetSize());
				}
				while(indexes.contains(Index));
				indexes.add(Index);
			if(BackpackSize-instance.GetItem(Index).GetWeight()>=0)
			{
				helper.Items.add(instance.GetItem(Index));
				helper.valueBackpack+=instance.GetItem(Index).GetValue();
				BackpackSize-=instance.GetItem(Index).GetWeight();
			}
			}
			if(helper.valueBackpack>opt.valueBackpack)
			{
				opt=helper;
			}
			helper=new Solution();
		}
		return opt;
	}
}
