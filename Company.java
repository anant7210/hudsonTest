import java.util.concurrent.locks.ReentrantLock;


public class Company {
	private String name;
	private final ReentrantLock lock= new ReentrantLock(); 
	public ReentrantLock getLock() {
		return lock;
	}
	Company(String s)
	{
		this.name=s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void talk(Company c) throws InterruptedException
	{
		if(c.getLock().tryLock())
		{
			lock.lock();
		try{
			System.out.println(name+" and "+c.getName()+" are talking");
			Thread.sleep(70);
		}
		finally
		{
			lock.unlock();
			c.getLock().unlock();
		}
		
	}
		else{
			System.out.println(name+" and "+c.getName()+" cannot talk as"+c.getName()+" is busy");
		}
	}

}
