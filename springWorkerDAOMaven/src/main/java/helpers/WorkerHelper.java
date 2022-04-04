package helpers;

import java.util.List;

import model.Worker;

public class WorkerHelper {
	public static void printAllWorkers(List<Worker> workers) {
		for(Worker worker: workers) {
			System.out.println("Worker ID: " + worker.getWORKER_ID());
			System.out.println("First Name: " + worker.getFIRST_NAME());
			System.out.println("Last Name: " + worker.getLAST_NAME());
			System.out.println("Salary: "+worker.getSALARY());
			System.out.println("Joining Date: "+ worker.getJOINING_DATE());
			System.out.println("Department: "+ worker.getDEPARTMENT());
			System.out.println();
		}
	}
}