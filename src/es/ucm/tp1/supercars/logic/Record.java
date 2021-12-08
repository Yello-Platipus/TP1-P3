package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Record {
    private Level level;
    private long recordTime;
    private Scanner scanner;

    public Record(Level level){
        this.level = level;
        try{
            searchRecord();
        }
        catch(InputOutputRecordException iore){

        }
    }

    public void searchRecord() throws InputOutputRecordException{
        File file = new File("record.txt");
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException fnfe){
            throw new InputOutputRecordException();
        }
        while(scanner.findInLine(level.toString() + ": ") == null){
            scanner.nextLine();
        }
        recordTime = scanner.nextLong();

    }

    public long getRecord(){
        return recordTime;
    }
}
