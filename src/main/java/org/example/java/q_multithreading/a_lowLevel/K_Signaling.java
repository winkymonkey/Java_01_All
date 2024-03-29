package org.example.java.q_multithreading.a_lowLevel;


class MonitorObject {
	//
}


/**
 * --------------------------------------------
 * Basic Wait Notify
 * --------------------------------------------
 */
class Test13 {
	
	private MonitorObject monitorObj = new MonitorObject();

	public void doWait() {					// called by the waiting thread
		synchronized (monitorObj) {
			try {
				monitorObj.wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void doNotify() {				// called by the notifying thread
		synchronized (monitorObj) {
			monitorObj.notify();
		}
	}
	
}




/**
 * --------------------------------------------
 * Solve Missed Signal Issue
 * --------------------------------------------
 */
class Test14 {
	
	private MonitorObject monitorObj = new MonitorObject();
	private boolean wasSignalled = false;

	public void doWait() {					// called by the waiting thread
		synchronized (monitorObj) {
			if (!wasSignalled) {			// if notifying signal is not already triggered
				try {
					monitorObj.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			wasSignalled = false;			// clear signal and continue running.
		}
	}

	public void doNotify() {				// called by the notifying thread
		synchronized (monitorObj) {
			wasSignalled = true;
			monitorObj.notify();
		}
	}
	
}




/**
 * --------------------------------------------
 * Solve Spurious Wake up Issue
 * --------------------------------------------
 */
class Test15 {
	
	private MonitorObject monitorObj = new MonitorObject();
	private boolean wasSignalled = false;

	public void doWait() {
		synchronized (monitorObj) {
			while (!wasSignalled) {			// until notifying signal is not already triggered
				try {
					monitorObj.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			wasSignalled = false;			// clear signal and continue running.
		}
	}

	public void doNotify() {
		synchronized (monitorObj) {
			wasSignalled = true;
			monitorObj.notify();
		}
	}
	
}
