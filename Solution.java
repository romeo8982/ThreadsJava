package all;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Item> Items = new ArrayList<Item>();
	public double valueBackpack;
	
public void print()
	{
		for(int i=0;i<Items.size();i++)
		{
			System.out.println("Wartosc:" + Items.get(i).GetValue() + " " + "Waga:" + Items.get(i).GetWeight() );
		} 
		System.out.println("Wartosc plecaka:" + valueBackpack);
	}
}