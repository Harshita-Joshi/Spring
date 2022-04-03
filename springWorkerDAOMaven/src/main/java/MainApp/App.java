package MainApp;

import helpers.WorkerHelper;
import model.Worker;
import services.WorkerJDBCTemplate;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.WorkerDAO;
import model.Worker;


@SuppressWarnings("unused")
public class App {

    static Date NOW(){
        return new Date();
    }

    public static void main(String[] args) throws Exception {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WorkerJDBCTemplate workerJDBCTemplate = (WorkerJDBCTemplate) context.getBean("workerJDBCTemplate");
    	
		System.out.println("************** Records Creation **************");
		workerJDBCTemplate.add(10001, "Goat", "Grass",13500, (java.sql.Date)NOW(), "IT");
		System.out.println();
		
		
		System.out.println("************** Displaying Worker Records **************");
		List<Worker> workers = workerJDBCTemplate.getWorkers(); 
		WorkerHelper.printAllWorkers(workers);
		


    }
}
