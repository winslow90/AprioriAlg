package com.su90.AprioriAlg.controller;

public class MainEntry {
    
    private static void process_sample(){
        DataInitializer datainit = new DataInitializer();
        datainit.formatToSampleDate();

        AprioriAlgProcessor processor= new AprioriAlgProcessor(0.2);
        processor.do_process();
        
    }
    private static void process_random(){
        DataInitializer datainit = new DataInitializer();
        datainit.formatToRandomDate(20);

        AprioriAlgProcessor processor= new AprioriAlgProcessor(0.2);
        processor.do_process();
        
    }   
    
    private static void process_selfdefined(){
        DataInitializer datainit = new DataInitializer();
        
        String[] itemnames= new String[]{"ink","pen","cheese","bag","milk","juice"};
        String[][] transitemnamesstr= new String[][] {
            {"ink","pen","cheese","bag"},
            {"milk","pen","juice","cheese"},
            {"milk","juice"},
            {"juice","milk","cheese"}
        };
        
        datainit.formatToSelfDefinedData(itemnames, transitemnamesstr);

        AprioriAlgProcessor processor= new AprioriAlgProcessor(0.5);
        processor.do_process();
        
    }   

	public static void main(String[] args) {		
//            System.out.println("SAMPLE DATA RESULT: ");
//            process_sample();
//            for(int i=0; i<3; i++){
//                System.out.println("RANDOM DATA "+i+" RESULT: ");
//                process_random();
//            }
            System.out.println("Test DATA RESULT: ");
            process_selfdefined();
	}

}
