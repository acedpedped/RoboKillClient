
/**
 * Class Weapon.
 * 
 * @author ParhamMLK
 * @author pedram
 * @version 1.0
 */

package robokill;

public class Weapon
{
	private double fireRate;
	private int requiredLevel;
	private double damage;
	private int cost;
	private int type;
	
	private static String[] typeNames = {"Light", "Medium", "Heavy"};
	private static double[] typeCoeff = {1, 1.5, 2};
	
	public Weapon(double fireRate, int requiredLevel, double damage, int cost, int type)
	{
		this.fireRate = fireRate;
		this.requiredLevel = requiredLevel;
		this.damage = damage;
		this.cost = cost;
		this.type = type;
	}	

	public static String[] getTypeNames()
	{
		return typeNames;
	}

	public static void setTypeNames(String[] aTypeNames)
	{
		typeNames = aTypeNames;
	}

	public static double[] getTypeCoeff()
	{
		return typeCoeff;
	}

	public static void setTypeCoeff(double[] aTypeCoeff)
	{
		typeCoeff = aTypeCoeff;
	}
	

	public double getFireRate()
	{
		return fireRate;
	}

	public void setFireRate(double fireRate)
	{
		this.fireRate = fireRate;
	}

	public int getRequiredLevel()
	{
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel)
	{
		this.requiredLevel = requiredLevel;
	}

	public double getDamage()
	{
		return damage;
	}

	public void setDamage(double damage)
	{
		this.damage = damage;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}
	
}
