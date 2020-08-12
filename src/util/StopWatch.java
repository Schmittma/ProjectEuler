package util;

/**
 * This Class shall be used to keep track of execution times.
 * This class depends on System.currentTimeMillis to keep track of time.
 * 
 * @author deschmm3
 */

public class StopWatch {

	long startTime;
	long elapsedTime;
	boolean isStopped;
	
	/**
	 * Starts the timer and removes the previously timed value
	 */
	public void start(){
		elapsedTime = 0;
		startTime = System.nanoTime();
		isStopped = false;
	}
	
	/**
	 * Stops the timer
	 */
	public void stop(){
		if(!isStopped){
			elapsedTime += (System.nanoTime() - startTime);
		}
		isStopped = true;
	}
	
	/**
	 * Restarts the stopped timer and adds onto the previously elapsed time
	 */
	public void restart(){
		if(isStopped){
			startTime = System.nanoTime();
		}
		
	}
	
	public long getTimeMilliseconds(){
		if(!isStopped){
			this.stop(); //Update elapsed time
			this.restart();
		}
		
		return elapsedTime / 1000000;
	}
	
	public double getTimeSeconds(){
		return getTimeMilliseconds() / 1000.0; 
	}
	
	@Override
	public String toString() {
		return "Elapsed Time: " + getTimeSeconds() + " seconds";
	}
	
	
}
